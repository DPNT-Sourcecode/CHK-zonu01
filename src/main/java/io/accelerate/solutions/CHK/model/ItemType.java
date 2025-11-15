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
    F(10),
    G(20),
    H(10),
    I(35),
    J(60),
    K(80),
    L(90),
    M(15),
    N(40),
    O(10),
    P(50),
    Q(30),
    R(50),
    S(30),
    T(20),
    U(40),
    V(50),
    W(20),
    X(90),
    Y(10),
    Z(50),
    INVALID(-1);

    private final int basePrice;

    public static ItemType fromSku(String sku) {
        return Arrays.stream(values())
                .filter(item -> item.name().equals(sku))
                .findFirst().orElse(INVALID);
    }
}

