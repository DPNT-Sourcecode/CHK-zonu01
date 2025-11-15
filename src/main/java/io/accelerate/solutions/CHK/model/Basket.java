package io.accelerate.solutions.CHK.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Basket {

    private Map<ItemType, Long> items;

    public static Basket fromSkus(String skus) {
        Map<ItemType, Long> basket = skus.chars()
                .mapToObj(charInt -> (char) charInt)
                .map(String::valueOf)
                .map(ItemType::fromSku)
                .collect(groupingBy(Function.identity(), counting()));
        return new Basket(basket);
    }
}
