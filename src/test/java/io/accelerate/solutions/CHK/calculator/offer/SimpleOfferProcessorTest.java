package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.SimpleOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleOfferProcessorTest {

    private SimpleOfferProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new SimpleOfferProcessor();
    }

    @Test
    public void shouldProcessItemsInBasket() {
        Map<ItemType, Long> itemsInBasket = Map.of(
                ItemType.A, 7L,
                ItemType.B, 2L,
                ItemType.C, 5L
        );
        SimpleOffer simpleOffer = SimpleOffer.of(ItemType.A, 3, 130);

        SpecialOfferResult result = processor.process(simpleOffer, itemsInBasket);

        assertEquals(result.getItemsProcessed(), Map.of(ItemType.A, 6L));
        assertEquals(result.getTotalPriceApplied(), 260);
    }
}