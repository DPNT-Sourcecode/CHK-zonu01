package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.offer.GroupDiscountOffer;
import io.accelerate.solutions.CHK.model.offer.ItemGroup;
import io.accelerate.solutions.CHK.model.offer.MultiItemOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

public class GroupDiscountOfferProcessor implements OfferProcessor {

    @Override
    public SpecialOfferResult process(SpecialOffer offer, Basket basket) {
        GroupDiscountOffer groupDiscountOffer = (GroupDiscountOffer) offer;

        Basket basketToProcess = basket.mutableCopy();
        Basket itemsProcessed = Basket.empty();
        int totalPriceOfOffers = 0;

        // check if basket contains the target amount of group items
//        while (basketToProcess.contains(groupDiscountOffer.getItemGroup())) {
////            basketToProcess.remove(groupDiscountOffer.getTargetProducts());
////            itemsProcessed.put(groupDiscountOffer.getOfferBundle().itemsInBundle());
//            totalPriceOfOffers += groupDiscountOffer.getBundlePrice();
//        }

        return SpecialOfferResult.builder()
                .itemsProcessed(itemsProcessed.getItems())
                .totalPriceApplied(totalPriceOfOffers)
                .build();
    }
}

