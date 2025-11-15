package io.accelerate.solutions.CHK.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ItemType {

    A(50),
    B(30),
    C(20),
    D(15),
    E(40),
    INVALID(-1);

    private final int basePrice;

    public static ItemType fromSku(String sku) {
        return Arrays.stream(values())
                .filter(item -> item.name().equals(sku))
                .findFirst().orElse(INVALID);
    }
}

