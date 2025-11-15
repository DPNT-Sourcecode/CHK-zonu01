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

        while (basketToProcess.contains(multiItemOffer.getTargetProducts())) {
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
