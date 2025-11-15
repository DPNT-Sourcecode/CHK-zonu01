package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.offer.MultiItemOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

public class MultiItemOfferProcessor implements OfferProcessor {

    @Override
    public SpecialOfferResult process(SpecialOffer offer, Basket basket) {
        MultiItemOffer multiItemOffer = (MultiItemOffer) offer;

        Basket basketToProcess = basket.mutableCopy();
        Basket itemsProcessed = Basket.empty();
        int totalPriceOfOffers = 0;

        // check if basket contains both the target items and the items to which to apply the promotion to
        while (basketToProcess.contains(multiItemOffer.getTargetProducts())
                && basketToProcess.contains(multiItemOffer.getOfferBundle().itemsInBundle())) {
            basketToProcess.remove(multiItemOffer.getTargetProducts());
            itemsProcessed.put(multiItemOffer.getOfferBundle().itemsInBundle());
            totalPriceOfOffers += multiItemOffer.getBundlePrice();
        }

        return SpecialOfferResult.builder()
                .itemsProcessed(itemsProcessed.getItems())
                .totalPriceApplied(totalPriceOfOffers)
                .build();
    }
}

