package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.model.Basket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutCalculatorTest {

    private CheckoutCalculator checkoutCalculator;

    @BeforeEach
    void setUp() {
        checkoutCalculator = new CheckoutCalculator();
    }

    @Test
    void calculateTotalPrice() {
        Integer result = checkoutCalculator.calculateTotalPrice(Basket.fromSkus("AABBCD"));

        assertEquals(result, 165);
    }
}