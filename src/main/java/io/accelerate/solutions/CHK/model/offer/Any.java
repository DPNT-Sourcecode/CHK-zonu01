package io.accelerate.solutions.CHK.model.offer;


import io.accelerate.solutions.CHK.model.ItemType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Any {
    private Set<ItemType> anyItems;

    public static Any of(ItemType... types) {
        return new Any(new HashSet<>(Arrays.asList(types)));
    }
}
