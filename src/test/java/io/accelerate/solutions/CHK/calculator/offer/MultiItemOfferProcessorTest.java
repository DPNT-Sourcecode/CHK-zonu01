package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.MultiItemOffer;
import io.accelerate.solutions.CHK.model.offer.SpecialOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MultiItemOfferProcessorTest {

    private MultiItemOfferProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new MultiItemOfferProcessor();
    }

    @Test
    void shouldProcessMultipleItemsFromBasket() {
        SpecialOffer offer = MultiItemOffer.of(
                Map.of(ItemType.C, 2L),
                Map.of(ItemType.D, 1L),
                10
        );
        Map<ItemType, Long> itemsInBasket = Map.of(ItemType.C, 4L, ItemType.D, 3L);

        SpecialOfferResult result = processor.process(offer, itemsInBasket);

        assertEquals(result.getItemsProcessed().size(), 1);
        assertEquals(result.getItemsProcessed().get(ItemType.D), 2L);
        assertEquals(result.getTotalPriceApplied(), 20);
    }
}