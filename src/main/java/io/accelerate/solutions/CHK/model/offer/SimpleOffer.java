package io.accelerate.solutions.CHK.model.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SimpleOffer implements SpecialOffer {

    private ItemType itemType;
    private int targetAmount;
    private int totalBundlePrice;
    private final int appliedDiscount;

    public static SimpleOffer of(ItemType itemType, int targetAmount, int totalBundlePrice) {
        int appliedDiscount = targetAmount * itemType.getBasePrice() - totalBundlePrice;

        return new SimpleOffer(itemType, targetAmount, totalBundlePrice, appliedDiscount);
    }

    @Override
    public int getBundlePrice() {
        return totalBundlePrice;
    }
}
