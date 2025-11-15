package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.calculator.CheckoutCalculator;
import io.accelerate.solutions.CHK.model.Basket;

import static java.util.stream.Collectors.groupingBy;

public class CheckoutSolution {

    private CheckoutCalculator checkoutCalculator;

    public Integer checkout(String skus) {
        Basket basket = Basket.fromSkus(skus);

        return checkoutCalculator.calculateTotalPrice(basket);
    }

}
