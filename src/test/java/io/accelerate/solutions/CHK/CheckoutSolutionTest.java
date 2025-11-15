package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {

    private CheckoutSolution solution;

    @BeforeEach
    void setUp() {
        solution = new CheckoutSolution();
    }

    @Test
    public void shouldReturnPriceTotalOfBasket() {
        Integer result = solution.checkout("AABCD");

        assertEquals(result, 165);
    }


}