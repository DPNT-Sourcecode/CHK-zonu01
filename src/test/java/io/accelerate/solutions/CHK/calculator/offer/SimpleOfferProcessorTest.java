package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.Basket;
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
        Basket basket = Basket.fromSkus("AAAAAAABBCCCCC");
        SimpleOffer simpleOffer = SimpleOffer.of(ItemType.A, 3, 130);

        SpecialOfferResult result = processor.process(simpleOffer, basket);

        assertEquals(result.getItemsProcessed(), Map.of(ItemType.A, 6L));
        assertEquals(result.getTotalPriceApplied(), 260);
    }
}