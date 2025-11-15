package io.accelerate.solutions.CHK.model;

import io.accelerate.solutions.CHK.model.offer.ItemGroup;
import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class Basket {

    private Map<ItemType, Long> items;

    public static Basket fromSkus(String skus) {
        if (skus == null || skus.isBlank()) {
            return new Basket(Map.of());
        }

        Map<ItemType, Long> basketItems = skus.chars()
                .mapToObj(charInt -> (char) charInt)
                .map(String::valueOf)
                .map(ItemType::fromSku)
                .collect(groupingBy(Function.identity(), counting()));
        return new Basket(basketItems);
    }

    public static Basket empty() {
        return new Basket(new HashMap<>());
    }

    public Basket mutableCopy() {
        return new Basket(new HashMap<>(items));
    }

    public boolean contains(Map<ItemType, Long> itemsToCheck) {
        for (Map.Entry<ItemType, Long> itemToCheck : itemsToCheck.entrySet()) {
            Long existingAmount = this.items.get(itemToCheck.getKey());
            if (existingAmount == null || existingAmount < itemToCheck.getValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(ItemGroup itemGroup) {
        int count = 0;

        for (ItemType itemType : itemGroup.getItemsInGroup()) {
            count += this.items.getOrDefault(itemType, 0L);
            if (count >= itemGroup.getTargetAmount()) {
                return true;
            }
        }

        return false;
    }

    public void put(Map<ItemType, Long> itemsToAdd) {
        for (Map.Entry<ItemType, Long> itemToAdd : itemsToAdd.entrySet()) {
            this.items.merge(itemToAdd.getKey(), itemToAdd.getValue(), Long::sum);
        }
    }

    public void remove(Map<ItemType, Long> itemsToRemove) {
        for (Map.Entry<ItemType, Long> itemToRemove : itemsToRemove.entrySet()) {
            items.put(itemToRemove.getKey(), items.get(itemToRemove.getKey()) - itemToRemove.getValue());
        }
    }

    public boolean includesInvalidItems() {
        return items.get(ItemType.INVALID) != null;
    }
}
