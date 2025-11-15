package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferProcessor;
import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.SpecialOffer;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class CheckoutCalculator {

    private SpecialOfferProcessor offerProcessor;

    private static final List<SpecialOffer> specialOffers = new ArrayList<>(List.of(
        SpecialOffer.of(ItemType.A, 3, 130),
        SpecialOffer.of(ItemType.B, 2, 45)
    ));

    static {
        specialOffers.sort(Comparator.comparing(SpecialOffer::getAppliedDiscount).reversed());
    }

    public Integer calculateTotalPrice(Basket basket) {
        Map<ItemType, Long> itemsInBasket = basket.getItems();
        int totalPrice = 0;

        //specialOffers.forEach(offer -> processItemsApplicableForOffer(offer, itemsInBasket));

        return 0;
    }

}
