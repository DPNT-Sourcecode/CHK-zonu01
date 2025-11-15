package io.accelerate.solutions.CHK.model.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MultiItemOffer implements SpecialOffer {

    private final Map<ItemType, Long> targetProducts;
    private BundlePrice bundlePrice;

    public static MultiItemOffer of(Map<ItemType, Long> targetProducts, Map<ItemType, Long> bundleItems, int totalBundlePrice) {
        return new MultiItemOffer(targetProducts, new BundlePrice(bundleItems, totalBundlePrice));
    }

    @Override
    public int getBundlePrice() {
        return bundlePrice.totalPrice();
    }

    @Override
    public int getAppliedDiscount() {
        int originalPrice = bundlePrice.itemsInBundle().entrySet()
                .stream()
                .mapToInt(entry -> (int) (entry.getKey().getBasePrice() * entry.getValue()))
                .sum();
        return originalPrice - bundlePrice.totalPrice();
    }
}
