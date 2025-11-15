package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.SimpleOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

import java.util.HashMap;
import java.util.Map;

public class SimpleOfferProcessor implements OfferProcessor {

    public SpecialOfferResult process(SpecialOffer specialOffer, Basket basket) {

        SimpleOffer offer = (SimpleOffer) specialOffer;

        Basket basketToProcess = basket.mutableCopy();
        Map<ItemType, Long> itemsProcessedForOffers = new HashMap<>();
        int totalPriceOfOffers = 0;

        while (removeItemsApplicableForOffer(basketToProcess, offer)) {
            totalPriceOfOffers += offer.getTotalBundlePrice();

            Long currentItemProcessed = itemsProcessedForOffers.computeIfAbsent(offer.getItemType(), k -> 0L);
            itemsProcessedForOffers.put(offer.getItemType(), currentItemProcessed + offer.getTargetAmount());
        }

        return SpecialOfferResult.builder()
                .itemsProcessed(itemsProcessedForOffers)
                .totalPriceApplied(totalPriceOfOffers)
                .build();
    }

    private boolean removeItemsApplicableForOffer(Basket basket, SimpleOffer offer) {
//        Long actualAmount = itemsInBasket.get(offer.getItemType());
//        return actualAmount != null && actualAmount >= offer.getTargetAmount();
        return false;
    }
}
