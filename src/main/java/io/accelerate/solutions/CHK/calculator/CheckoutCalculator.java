package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferResult;
import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.SpecialOffer;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class CheckoutCalculator {

    private SpecialOfferProcessor offerProcessor;

    private static final List<SpecialOffer> specialOffers = new ArrayList<>(List.of(
        SpecialOffer.of(ItemType.A, 3, 130),
        SpecialOffer.of(ItemType.B, 2, 45)
    ));

    static {
        specialOffers.sort(Comparator.comparing(SpecialOffer::getAppliedDiscount).reversed());
    }

    public Integer calculateTotalPrice(Basket basket) {
        Map<ItemType, Long> itemsInBasket = new HashMap<>(basket.getItems());
        int totalPrice = 0;

        for (SpecialOffer offer : specialOffers) {
            SpecialOfferResult specialOfferResult = offerProcessor.process(offer, itemsInBasket);
            removeItemsFromBasket(itemsInBasket, specialOfferResult.getItemsProcessed());
            totalPrice += specialOfferResult.getTotalPriceApplied();
        }

        for (Map.Entry<ItemType, Long> item : itemsInBasket.entrySet()) {
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
