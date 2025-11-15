package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.GroupDiscountOffer;
import io.accelerate.solutions.CHK.model.offer.ItemGroup;
import io.accelerate.solutions.CHK.model.offer.MultiItemOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class GroupDiscountOfferProcessor implements OfferProcessor {

    @Override
    public SpecialOfferResult process(SpecialOffer offer, Basket basket) {
        GroupDiscountOffer groupDiscountOffer = (GroupDiscountOffer) offer;

        Basket basketToProcess = basket.mutableCopy();
        Basket itemsProcessed = Basket.empty();
        int totalPriceOfOffers = 0;

        // check if basket contains the target amount of group items
        while (basketToProcess.contains(groupDiscountOffer.getItemGroup())) {
            Map<ItemType, Long> itemsRemoved = removeItemGroupFromBasket(basketToProcess, groupDiscountOffer.getItemGroup());
            itemsProcessed.put(itemsRemoved);
            totalPriceOfOffers += groupDiscountOffer.getBundlePrice();
        }

        return SpecialOfferResult.builder()
                .itemsProcessed(itemsProcessed.getItems())
                .totalPriceApplied(totalPriceOfOffers)
                .build();
    }

    private Map<ItemType, Long> removeItemGroupFromBasket(Basket basket, ItemGroup itemGroup) {
        long count = 0;
        Map<ItemType, Long> itemsRemoved = new HashMap<>();

        for (ItemType itemType : itemGroup.getItemsInGroup()) {
            Long amountOfCurrentType = basket.getItems().get(itemType);
            if (amountOfCurrentType != null && amountOfCurrentType > 0) {
                long processedAmount = Math.min(itemGroup.getTargetAmount() - count, amountOfCurrentType);
                count += processedAmount;
                itemsRemoved.put(itemType,processedAmount);
                basket.remove(Map.of(itemType, processedAmount));
            }
            if (count >= itemGroup.getTargetAmount()) {
                break;
            }
        }

        return itemsRemoved;
    }
}




