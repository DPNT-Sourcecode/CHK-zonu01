package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.MultiItemOffer;
import io.accelerate.solutions.CHK.model.offer.SimpleOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

import java.util.Map;

public class MultiItemOfferProcessor implements OfferProcessor {

    @Override
    public SpecialOfferResult process(SpecialOffer offer, Map<ItemType, Long> itemsInBasket) {
        MultiItemOffer multiItemOffer = (MultiItemOffer) offer;



        return null;
    }

    private boolean basketContainsItemsForOffer(Map<ItemType, Long> itemsInBasket, Map<ItemType, Long> targetItems) {
//        Long actualAmount = itemsInBasket.get(offer.getItemType());
//        return actualAmount != null && actualAmount >= offer.getTargetAmount();
    }
}
