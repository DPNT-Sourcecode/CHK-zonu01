package io.accelerate.solutions.CHK.model.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupDiscountOffer implements SpecialOffer {

    private ItemGroup itemGroup;
    private int bundlePrice;

    public static GroupDiscountOffer of(ItemGroup itemGroup, int bundlePrice) {
        return new GroupDiscountOffer(itemGroup, bundlePrice);
    }

    @Override
    public int getBundlePrice() {
        return bundlePrice;
    }

    @Override
    public int getAppliedDiscount() {
        // Only possible to know real value after applying offer
        // For now, average
        return (int) itemGroup.getItemsInGroup()
                .stream()
                .mapToInt(ItemType::getBasePrice).average().orElse(0);
    }
}

