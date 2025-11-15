package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.SpecialOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CheckoutCalculator {

    private static List<SpecialOffer> specialOffers = new ArrayList<>(List.of(
        SpecialOffer.builder().itemType(ItemType.A).targetAmount(3).totalBundlePrice(130).build(),
        SpecialOffer.builder().itemType(ItemType.B).targetAmount(2).totalBundlePrice(130).build()
    ));

    static {
        specialOffers.sort(Comparator.comparing(SpecialOffer::getAppliedDiscount).reversed());
    }

    public Integer calculateTotalPrice(Basket basket) {
        Map<ItemType, Long> itemsInBasket = basket.getItems();
        int totalPrice = 0;

        specialOffers.forEach(offer -> processItemsApplicableForOffer(offer, itemsInBasket));

        return 0;
    }

    private void processItemsApplicableForOffer(SpecialOffer offer, Map<ItemType, Long> itemsInBasket) {

    }
}
