package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.OfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.SimpleOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferResult;
import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.SimpleOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class CheckoutCalculator {

    private Map<String, OfferProcessor> processorMap;

    public CheckoutCalculator(SimpleOfferProcessor simpleOfferProcessor) {
        processorMap = Map.of(
                SimpleOffer.class.getSimpleName(), simpleOfferProcessor
        );
    }

    private static final List<SpecialOffer> specialOffers = new ArrayList<>(List.of(
        SimpleOffer.of(ItemType.A, 3, 130),
        SimpleOffer.of(ItemType.A, 5, 200),
        SimpleOffer.of(ItemType.B, 2, 45)
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

    private void removeItemsFromBasket(Map<ItemType, Long> itemsInBasket, Map<ItemType, Long> itemsProcessed) {
        itemsProcessed.forEach((itemType, processedAmount) -> {
            itemsInBasket.put(itemType, itemsInBasket.get(itemType) - processedAmount);
        });
    }

}
