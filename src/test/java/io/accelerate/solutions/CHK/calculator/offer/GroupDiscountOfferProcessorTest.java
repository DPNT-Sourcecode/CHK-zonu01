package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.accelerate.solutions.CHK.model.ItemType.*;
import static org.junit.jupiter.api.Assertions.*;

class GroupDiscountOfferProcessorTest {

    private GroupDiscountOfferProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new GroupDiscountOfferProcessor();
    }

    @Test
    void shouldProcessMultipleItemsFromBasket() {
        SpecialOffer offer = GroupDiscountOffer.of(
                ItemGroup.of(Any.of(S, T, X, Y, Z), 5), 45);
        Basket basket = Basket.fromSkus("XXXSZZZ");

        SpecialOfferResult result = processor.process(offer, basket);

        assertEquals(result.getItemsProcessed().size(), 3);
        assertEquals(result.getItemsProcessed().get(ItemType.Z), 3L);
        assertEquals(result.getItemsProcessed().get(ItemType.S), 1L);
        assertEquals(result.getItemsProcessed().get(ItemType.X), 1L);
        assertEquals(result.getTotalPriceApplied(), 45);
    }
}