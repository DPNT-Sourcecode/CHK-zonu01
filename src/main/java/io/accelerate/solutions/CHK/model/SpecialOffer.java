package io.accelerate.solutions.CHK.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpecialOffer {

    private ItemType itemType;
    private int targetAmount;
    private int totalBundlePrice;

    private final int appliedDiscount;

    private SpecialOffer(ItemType itemType, int targetAmount, int totalBundlePrice) {
        this.itemType = itemType;
        this.targetAmount = targetAmount;
        this.totalBundlePrice = totalBundlePrice;

        appliedDiscount = targetAmount * itemType.getBasePrice() - totalBundlePrice;
    }
}
