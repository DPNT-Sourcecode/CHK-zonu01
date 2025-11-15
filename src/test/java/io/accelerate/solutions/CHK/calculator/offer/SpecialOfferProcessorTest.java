package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.SpecialOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialOfferProcessorTest {

    private SpecialOfferProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new SpecialOfferProcessor();
    }

    @Test
    public void shouldProcessItemsInBasket() {
        Map<ItemType, Long> itemsInBasket = Map.of(
                ItemType.A, 4L,
                ItemType.B, 2L,
                ItemType.C, 5L
        );
        SpecialOffer specialOffer = SpecialOffer.builder().itemType(ItemType.A).targetAmount(3).totalBundlePrice(130).build();

        SpecialOfferResult result = processor.process(specialOffer, itemsInBasket);

        assertEquals(result.getItemsProcessed(), Map.of(ItemType.A, 3L));
        assertEquals(result.getTotalPriceApplied(), 130);
    }
}