package io.accelerate.solutions.CHK.model.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
public class MultiItemOffer implements SpecialOffer {

    private final Map<ItemType, Long> targetProducts;
    private OfferBundle offerBundle;

    /**
     * Simple offer
     */
    public static MultiItemOffer of(ItemType itemType, long targetAmount, int totalBundlePrice) {
        return MultiItemOffer.of(Map.of(itemType, targetAmount), Map.of(itemType, targetAmount), totalBundlePrice);
    }

    /**
     * Multi item offer
     */
    public static MultiItemOffer of(Map<ItemType, Long> targetProducts, Map<ItemType, Long> bundleItems, int totalBundlePrice) {
        return new MultiItemOffer(targetProducts, new OfferBundle(bundleItems, totalBundlePrice));
    }

    public int getBundlePrice() {
        return offerBundle.totalPrice();
    }

    @Override
    public int getAppliedDiscount() {
        int originalPrice = offerBundle.itemsInBundle().entrySet()
                .stream()
                .mapToInt(entry -> (int) (entry.getKey().getBasePrice() * entry.getValue()))
                .sum();
        return originalPrice - offerBundle.totalPrice();
    }
}
