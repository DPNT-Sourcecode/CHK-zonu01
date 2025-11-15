package io.accelerate.solutions.SUM;

import io.accelerate.runner.SolutionNotImplementedException;

@SuppressWarnings("unused")
public class SumSolution {

    /**
     * sum(integer, integer) -> integer
     *  @param x a positive integer between 0-100
     *  @param y = a positive integer between 0-100
     *  @return = an integer representing the sum of the two numbers
     */
    public int compute(int x, int y) {
        if (x < 0 || x > 100 || y < 0 || y > 100) {
            throw new IllegalArgumentException("Invalid argument. Either argument must be a positive integer between 0-100");
        }
        return x + y;
    }

}
