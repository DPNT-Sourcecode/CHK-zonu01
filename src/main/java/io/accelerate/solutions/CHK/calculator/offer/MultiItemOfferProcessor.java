package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.MultiItemOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

import java.util.HashMap;
import java.util.Map;

public class MultiItemOfferProcessor implements OfferProcessor {

    @Override
    public SpecialOfferResult process(SpecialOffer offer, Basket basket) {
        MultiItemOffer multiItemOffer = (MultiItemOffer) offer;

        Basket basketToProcess = basket.mutableCopy();
        Map<ItemType, Long> itemsProcessedForOffers = new HashMap<>();
        int totalPriceOfOffers = 0;


        return SpecialOfferResult.builder()
                .itemsProcessed(itemsProcessedForOffers)
                .totalPriceApplied(totalPriceOfOffers)
                .build();
    }

    private boolean removeItemsFromBasketToApplyOffer(Map<ItemType, Long> itemsInBasket, Map<ItemType, Long> targetItems) {
//        Long actualAmount = itemsInBasket.get(offer.getItemType());
//        return actualAmount != null && actualAmount >= offer.getTargetAmount();
        return false;
    }
}
