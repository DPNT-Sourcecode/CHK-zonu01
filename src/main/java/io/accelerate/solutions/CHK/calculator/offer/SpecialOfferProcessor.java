package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.SpecialOffer;

import java.util.Map;

public class SpecialOfferProcessor {

    public SpecialOfferResult process(SpecialOffer offer, Map<ItemType, Long> itemsInBasket) {
        return SpecialOfferResult.builder().build();
    }
}
