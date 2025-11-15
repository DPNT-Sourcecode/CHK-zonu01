package io.accelerate.solutions.CHK.model.offer;

import io.accelerate.solutions.CHK.model.ItemType;

import java.util.Map;

public record BundlePrice(Map<ItemType, Long> itemsInBundle, int totalPrice) {
}
