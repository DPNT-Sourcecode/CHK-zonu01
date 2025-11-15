package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.GroupDiscountOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.MultiItemOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferResult;
import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CheckoutCalculatorTest {

    private CheckoutCalculator checkoutCalculator;
    private MultiItemOfferProcessor multiItemOfferProcessor;
    private GroupDiscountOfferProcessor groupDiscountOfferProcessor;

    @BeforeEach
    void setUp() {
        multiItemOfferProcessor = Mockito.mock(MultiItemOfferProcessor.class);
        groupDiscountOfferProcessor = Mockito.mock(GroupDiscountOfferProcessor.class);
        checkoutCalculator = new CheckoutCalculator(multiItemOfferProcessor, groupDiscountOfferProcessor);

        when(groupDiscountOfferProcessor.process(
                any(), any()
        )).thenReturn(SpecialOfferResult.builder()
                .totalPriceApplied(0)
                .itemsProcessed(Map.of())
                .build());
    }

    @Test
    void calculateTotalPriceWithOffers() {
        when(multiItemOfferProcessor.process(
                any(), any()
        )).thenReturn(SpecialOfferResult.builder()
                        .totalPriceApplied(0)
                        .itemsProcessed(Map.of())
                        .build())
                .thenReturn(SpecialOfferResult.builder()
                        .totalPriceApplied(0)
                        .itemsProcessed(Map.of(ItemType.B, 1L))
                        .build())
                .thenReturn(SpecialOfferResult.builder()
                        .totalPriceApplied(130)
                        .itemsProcessed(Map.of(ItemType.A, 3L))
                        .build())
                .thenReturn(SpecialOfferResult.builder()
                        .totalPriceApplied(0)
                        .itemsProcessed(Map.of())
                        .build());

        Integer result = checkoutCalculator.calculateTotalPrice(Basket.fromSkus("AAABCDEE"));

        assertEquals(245, result);
    }

    @Test
    void calculateTotalPriceWithoutOffers() {
        when(multiItemOfferProcessor.process(
                any(), any()
        )).thenReturn(SpecialOfferResult.builder()
                        .totalPriceApplied(40)
                        .itemsProcessed(Map.of(ItemType.F, 6L))
                        .build())
                .thenReturn(SpecialOfferResult.builder()
                        .totalPriceApplied(0)
                        .itemsProcessed(Map.of())
                        .build());

        Integer result = checkoutCalculator.calculateTotalPrice(Basket.fromSkus("FFFFFF"));

        assertEquals(40, result);
    }
}
