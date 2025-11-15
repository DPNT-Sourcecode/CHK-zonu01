package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferProcessor;
import io.accelerate.solutions.CHK.model.Basket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutCalculatorTest {

    private CheckoutCalculator checkoutCalculator;

    @BeforeEach
    void setUp() {
        SpecialOfferProcessor processor = Mockito.mock(SpecialOfferProcessor.class);
        checkoutCalculator = new CheckoutCalculator(processor);
    }

    @Test
    void calculateTotalPrice() {
        Integer result = checkoutCalculator.calculateTotalPrice(Basket.fromSkus("AABBCD"));

        assertEquals(result, 165);
    }
}