package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.SpecialOffer;

import java.util.List;

public class CheckoutCalculator {

    List<SpecialOffer> specialOffers = List.of(
        SpecialOffer.builder().itemType(ItemType.A).targetAmount(3).totalBundlePrice(130).build(),
        SpecialOffer.builder().itemType(ItemType.B).targetAmount(2).totalBundlePrice(130).build()
    );

    public Integer calculateTotalPrice(Basket basket) {
        return 0;
    }
}

