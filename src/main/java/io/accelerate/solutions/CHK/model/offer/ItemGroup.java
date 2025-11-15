package io.accelerate.solutions.CHK.model.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ItemGroup {
    private List<ItemType> itemsInGroup;
    private int targetAmount;

    public static ItemGroup of(Any any, int targetAmount) {
        List<ItemType> itemsOrderedByPriceDesc = any.getAnyItems()
                .stream()
                .sorted(Comparator.comparing(ItemType::getBasePrice).reversed())
                .toList();
        return new ItemGroup(itemsOrderedByPriceDesc, targetAmount);
    }
}
