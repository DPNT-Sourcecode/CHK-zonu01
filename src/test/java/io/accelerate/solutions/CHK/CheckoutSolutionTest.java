package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.calculator.CheckoutCalculator;
import io.accelerate.solutions.CHK.model.Basket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CheckoutSolutionTest {

    private CheckoutSolution solution;

    private CheckoutCalculator checkoutCalculator;

    @BeforeEach
    void setUp() {
        checkoutCalculator = mock(CheckoutCalculator.class);
        solution = new CheckoutSolution();
        solution.setCheckoutCalculator(checkoutCalculator);
    }

    @Test
    public void shouldReturnPriceTotalOfBasket() {
        int expected = 165;
        when(checkoutCalculator.calculateTotalPrice(any(Basket.class))).thenReturn(expected);

        Integer result = solution.checkout("AABCD");

        assertEquals(result, expected);
    }

}