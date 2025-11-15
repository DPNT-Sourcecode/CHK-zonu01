package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.calculator.CheckoutCalculator;
import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import lombok.AccessLevel;
import lombok.Setter;

@Setter(AccessLevel.PACKAGE)
public class CheckoutSolution {

    private CheckoutCalculator checkoutCalculator;

    public Integer checkout(String skus) {
        Basket basket = Basket.fromSkus(skus);

        if (basket.includesInvalidItems()) {
            return ItemType.INVALID.getBasePrice();
        }

        return checkoutCalculator.calculateTotalPrice(basket);
    }

}

