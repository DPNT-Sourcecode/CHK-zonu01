package io.accelerate.solutions.CHK.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpecialOffer {

    private ItemType itemType;
    private int targetAmount;
    private int totalBundlePrice;

    @Builder.
    private final int appliedDiscount;

    private SpecialOffer(ItemType itemType, int targetAmount, int totalBundlePrice) {

    }
}

