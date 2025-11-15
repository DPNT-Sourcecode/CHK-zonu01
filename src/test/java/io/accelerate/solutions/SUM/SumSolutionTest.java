package io.accelerate.solutions.SUM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SumSolutionTest {
    private SumSolution sum;

    @BeforeEach
    public void setUp() {
        sum = new SumSolution();
    }

    @Test
    public void compute_sum() {
        assertThat(sum.compute(1, 1), equalTo(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    public void shouldThrowIllegalArgumentExceptionWhenXOutOfBounds(int invalidX) {
        assertThrows(IllegalArgumentException.class, () -> {
           sum.compute(invalidX, 50);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    public void shouldThrowIllegalArgumentExceptionWhenYOutOfBounds(int invalidY) {
        assertThrows(IllegalArgumentException.class, () -> {
            sum.compute(50, invalidY);
        });
    }
}



