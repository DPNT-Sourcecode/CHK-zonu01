package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.SimpleOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferResult;
import io.accelerate.solutions.CHK.model.Basket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CheckoutCalculatorTest {

    private CheckoutCalculator checkoutCalculator;
    private SimpleOfferProcessor processor;

    @BeforeEach
    void setUp() {
        processor = Mockito.mock(SimpleOfferProcessor.class);
        checkoutCalculator = new CheckoutCalculator(processor);
    }

    @Test
    void calculateTotalPriceWithoutOffers() {
        when(processor.process(any(), any())).thenReturn(SpecialOfferResult.builder()
                .totalPriceApplied(0)
                .itemsProcessed(Map.of())
                .build());

        Integer result = checkoutCalculator.calculateTotalPrice(Basket.fromSkus("AABBCD"));

        assertEquals(result, 195);
    }
}

