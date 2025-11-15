package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.SimpleOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

import java.util.HashMap;
import java.util.Map;

public class SimpleOfferProcessor implements OfferProcessor {

    public SpecialOfferResult process(SpecialOffer specialOffer, Map<ItemType, Long> itemsInBasket) {

        SimpleOffer offer = (SimpleOffer) specialOffer;

        Map<ItemType, Long> itemsLeftInBasket = new HashMap<>(itemsInBasket);
        Map<ItemType, Long> itemsProcessedForOffers = new HashMap<>();
        int totalPriceOfOffers = 0;

        while (basketContainsItemsForOffer(itemsLeftInBasket, offer)) {
            totalPriceOfOffers += offer.getTotalBundlePrice();
            removeItemsFromBasket(offer, itemsLeftInBasket);

            Long currentItemProcessed = itemsProcessedForOffers.computeIfAbsent(offer.getItemType(), k -> 0L);
            itemsProcessedForOffers.put(offer.getItemType(), currentItemProcessed + offer.getTargetAmount());
        }

        return SpecialOfferResult.builder()
                .itemsProcessed(itemsProcessedForOffers)
                .totalPriceApplied(totalPriceOfOffers)
                .build();
    }

    private void removeItemsFromBasket(SimpleOffer offer, Map<ItemType, Long> itemsLeftInBasket) {
        itemsLeftInBasket.put(offer.getItemType(), itemsLeftInBasket.get(offer.getItemType()) - offer.getTargetAmount());
    }

    private boolean basketContainsItemsForOffer(Map<ItemType, Long> itemsInBasket, SimpleOffer offer) {
        Long actualAmount = itemsInBasket.get(offer.getItemType());
        return actualAmount != null && actualAmount >= offer.getTargetAmount();
    }
}

