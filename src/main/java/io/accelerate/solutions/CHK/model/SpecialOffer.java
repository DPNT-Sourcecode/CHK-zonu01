package io.accelerate.solutions.CHK.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecialOffer {

    private ItemType itemType;
    private int targetAmount;
    private int totalBundlePrice;
    private final int appliedDiscount;

    public static SpecialOffer of(ItemType itemType, int targetAmount, int totalBundlePrice) {
        int appliedDiscount = targetAmount * itemType.getBasePrice() - totalBundlePrice;

        return new SpecialOffer(itemType, targetAmount, totalBundlePrice, appliedDiscount);
    }
}
