package io.accelerate.solutions.CHK.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    public void shouldInitializeBasket() {
        String skus = "ABCDAB";

        Basket result = Basket.fromSkus(skus);

        assertEquals(2, result.getItems().get(ItemType.A));
        assertEquals(2, result.getItems().get(ItemType.B));
        assertEquals(1, result.getItems().get(ItemType.C));
    }

}