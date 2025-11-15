package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.MultiItemOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.OfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferResult;
import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.MultiItemOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class CheckoutCalculator {

    private Map<String, OfferProcessor> processorMap;

    public CheckoutCalculator(MultiItemOfferProcessor multiItemOfferProcessor) {
        processorMap = Map.of(
                MultiItemOffer.class.getSimpleName(), multiItemOfferProcessor
        );
    }

    private static final List<SpecialOffer> specialOffers = new ArrayList<>(List.of(
            MultiItemOffer.of(ItemType.A, 3, 130),
            MultiItemOffer.of(ItemType.A, 5, 200),
            MultiItemOffer.of(ItemType.B, 2, 45),
            MultiItemOffer.of(Map.of(ItemType.E, 2L), Map.of(ItemType.B, 1L), 0)
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


