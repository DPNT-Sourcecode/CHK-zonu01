package io.accelerate.solutions.CHK.calculator.offer;

import io.accelerate.solutions.CHK.model.ItemType;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class SpecialOfferResult {
    private Map<ItemType, Long> itemsProcessed;
    private int totalPriceApplied;
}
