package io.accelerate.solutions.CHK.model.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MultiItemOffer implements SpecialOffer {

    private final Map<ItemType, Long> targetProducts;


    @Override
    public int getBundlePrice() {
        return 0;
    }

    @Override
    public int getAppliedDiscount() {
        return 0;
    }
}
