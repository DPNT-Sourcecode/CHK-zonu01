package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.GroupDiscountOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.MultiItemOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.OfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferResult;
import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.*;
import lombok.AllArgsConstructor;

import java.util.*;

import static io.accelerate.solutions.CHK.model.ItemType.*;

@AllArgsConstructor
public class CheckoutCalculator {

    private Map<String, OfferProcessor> processorMap;

    public CheckoutCalculator(MultiItemOfferProcessor multiItemOfferProcessor,
                              GroupDiscountOfferProcessor groupDiscountOfferProcessor) {
        processorMap = Map.of(
                MultiItemOffer.class.getSimpleName(), multiItemOfferProcessor,
                GroupDiscountOffer.class.getSimpleName(), groupDiscountOfferProcessor
        );
    }

    static final List<SpecialOffer> specialOffers = new ArrayList<>(List.of(
            MultiItemOffer.of(ItemType.A, 3, 130),
            MultiItemOffer.of(ItemType.A, 5, 200),
            MultiItemOffer.of(ItemType.B, 2, 45),
            MultiItemOffer.of(Map.of(ItemType.E, 2L), Map.of(ItemType.B, 1L), 0),
            MultiItemOffer.of(ItemType.F, 3, 20),
            MultiItemOffer.of(ItemType.H, 5, 45),
            MultiItemOffer.of(ItemType.H, 10, 80),
            MultiItemOffer.of(ItemType.K, 2, 120),
            MultiItemOffer.of(Map.of(ItemType.N, 3L), Map.of(ItemType.M, 1L), 0),
            MultiItemOffer.of(ItemType.P, 5, 200),
            MultiItemOffer.of(ItemType.Q, 3, 80),
            MultiItemOffer.of(Map.of(ItemType.R, 3L), Map.of(ItemType.Q, 1L), 0),
            MultiItemOffer.of(ItemType.U, 4, 120),
            MultiItemOffer.of(ItemType.V, 2, 90),
            MultiItemOffer.of(ItemType.V, 3, 130),
            GroupDiscountOffer.of(ItemGroup.of(Any.of(S, T, X, Y, Z), 5), 45)
    ));

    static {
        specialOffers.sort(Comparator.comparing(SpecialOffer::getAppliedDiscount).reversed());
    }

    public Integer calculateTotalPrice(Basket basket) {
        Basket processingBasket = basket.mutableCopy();
        int totalPrice = 0;

        for (SpecialOffer offer : specialOffers) {
            String offerType = offer.getClass().getSimpleName();
            SpecialOfferResult specialOfferResult = processorMap.get(offerType).process(offer, processingBasket);
            processingBasket.remove(specialOfferResult.getItemsProcessed());
            totalPrice += specialOfferResult.getTotalPriceApplied();
        }

        for (Map.Entry<ItemType, Long> item : processingBasket.getItems().entrySet()) {
            totalPrice += (int) (item.getKey().getBasePrice() * item.getValue());
        }

        return totalPrice;
    }
}

