package io.accelerate.solutions.CHK.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTypeTest {

    @Test
    public void shouldMapToValidItemType() {
        assertEquals(ItemType.A, ItemType.fromSku("A"));
        assertEquals(ItemType.B, ItemType.fromSku("B"));
    }

    @Test
    public void shouldMapToInvalidItemType() {
        assertEquals(ItemType.INVALID, ItemType.fromSku("5"));
    }

}