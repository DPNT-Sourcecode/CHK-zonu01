package io.accelerate.solutions.HLO;

import io.accelerate.solutions.SUM.SumSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloSolutionTest {
    private HelloSolution hello;

    @BeforeEach
    public void setUp() {
        hello = new HelloSolution();
    }

    @Test
    public void shouldSayHelloToTheWorld() {
        String result = hello.hello("mellon");

        assertEquals("Hello, world", result);
    }
}