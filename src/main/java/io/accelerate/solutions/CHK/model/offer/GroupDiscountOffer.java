package io.accelerate.solutions.CHK.model.offer;

public class GroupDiscountOffer implements SpecialOffer {

    private ItemGroup itemGroup;
    private int bundlePrice;

    @Override
    public int getBundlePrice() {
        return 45;
    }

    @Override
    public int getAppliedDiscount() {
        return 0;
    }
}
