package io.accelerate.solutions.CHK.calculator.offer;

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
        SpecialOffer offer = MultiItemOffer.of(Map.of())

        processor.process()
    }
}