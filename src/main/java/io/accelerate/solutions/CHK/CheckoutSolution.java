package io.accelerate.solutions.CHK;

import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        Basket basket = Basket.fromSkus(skus);
        System.out.println(basket);
        return 0;
    }

}


