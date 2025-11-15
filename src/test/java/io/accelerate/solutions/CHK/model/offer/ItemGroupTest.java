package io.accelerate.solutions.CHK.model.offer;


import io.accelerate.solutions.CHK.model.ItemType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemGroupTest {

    @Test
    void shouldCreateItemGroupWithOrderedListOfItems() {
        ItemGroup itemGroup = ItemGroup.of(Any.of(
                ItemType.S, ItemType.T, ItemType.X, ItemType.Y, ItemType.Z
        ), 5);

        assertEquals(5, itemGroup.getTargetAmount());
        List<ItemType> itemList = itemGroup.getItemsInGroup();
        assertEquals(ItemType.Z, itemList.get(0));
        assertEquals(ItemType.X, itemList.get(4));
    }
}