package io.accelerate.solutions.CHK.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void shouldInitializeBasket() {
        String skus = "ABCDAB";

        Basket result = Basket.fromSkus(skus);

        assertFalse(result.includesInvalidItems());
        assertEquals(2, result.getItems().get(ItemType.A));
        assertEquals(2, result.getItems().get(ItemType.B));
        assertEquals(1, result.getItems().get(ItemType.C));
    }

    @Test
    public void shouldReturnTrueWhenItContainsInvalidCharacters() {
        Basket basket = Basket.fromSkus("ASDF.");

        assertTrue(basket.includesInvalidItems());
    }

    @Test
    public void shouldCreateAMutableCopy() {
        String skus = "ABCDAB";

        Basket result = Basket.fromSkus(skus).mutableCopy();
        result.put(Map.of(ItemType.A, 2L));

        assertEquals(4, result.getItems().get(ItemType.A));

        result.remove(Map.of(ItemType.A, 2L));

        assertEquals(2, result.getItems().get(ItemType.A));

        assertTrue(result.contains(Map.of(ItemType.A, 2L, ItemType.B, 2L)));
    }

}