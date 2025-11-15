package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.SimpleOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

import java.util.Map;

public interface OfferProcessor {
    SpecialOfferResult process(SpecialOffer offer, Map<ItemType, Long> itemsInBasket);
}
