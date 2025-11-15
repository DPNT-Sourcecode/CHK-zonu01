package io.accelerate.solutions.CHK.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ItemType {

    A(50),
    B(30),
    C(20),
    D(15);

    private final int basePrice;
}