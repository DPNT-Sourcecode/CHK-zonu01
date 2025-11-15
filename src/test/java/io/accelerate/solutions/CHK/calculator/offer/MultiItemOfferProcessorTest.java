package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
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
    void shouldProcessSingleItemsFromBasket() {
        SpecialOffer offer = MultiItemOffer.of(
                ItemType.C,
                2L,
                10
        );
        Basket basket = Basket.fromSkus("CCCDDD");

        SpecialOfferResult result = processor.process(offer, basket);

        assertEquals(result.getItemsProcessed().size(), 1);
        assertEquals(result.getItemsProcessed().get(ItemType.C), 2L);
        assertEquals(result.getTotalPriceApplied(), 10);
    }

    @Test
    void shouldProcessMultipleItemsFromBasket() {
        SpecialOffer offer = MultiItemOffer.of(
                Map.of(ItemType.C, 2L),
                Map.of(ItemType.D, 1L),
                10
        );
        Basket basket = Basket.fromSkus("CCCCDDD");

        SpecialOfferResult result = processor.process(offer, basket);

        assertEquals(result.getItemsProcessed().size(), 1);
        assertEquals(result.getItemsProcessed().get(ItemType.D), 2L);
        assertEquals(result.getTotalPriceApplied(), 20);
    }
}
