package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

public interface OfferProcessor {
    SpecialOfferResult process(SpecialOffer offer, Basket basket);
}
