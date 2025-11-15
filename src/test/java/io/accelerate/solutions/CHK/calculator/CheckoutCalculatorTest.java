package io.accelerate.solutions.CHK.calculator;

import io.accelerate.solutions.CHK.calculator.offer.MultiItemOfferProcessor;
import io.accelerate.solutions.CHK.calculator.offer.SpecialOfferResult;
import io.accelerate.solutions.CHK.model.Basket;
import io.accelerate.solutions.CHK.model.ItemType;
import io.accelerate.solutions.CHK.model.offer.MultiItemOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CheckoutCalculatorTest {

    private CheckoutCalculator checkoutCalculator;
    private MultiItemOfferProcessor processor;

    @BeforeEach
    void setUp() {
        processor = Mockito.mock(MultiItemOfferProcessor.class);
        checkoutCalculator = new CheckoutCalculator(processor);
    }

    @Test
    void calculateTotalPriceWithoutOffers() {
        when(processor.process(
                any(), any()
        )).thenReturn(SpecialOfferResult.builder()
                .totalPriceApplied(0)
                .itemsProcessed(Map.of())
                .build());
        when(processor.process(
                MultiItemOffer.of(ItemType.A, 3, 130), Basket.fromSkus("AABCDEE")
        )).thenReturn(SpecialOfferResult.builder()
                .totalPriceApplied(0)
                .itemsProcessed(Map.of(ItemType.B, 1L))
                .build());

        Integer result = checkoutCalculator.calculateTotalPrice(Basket.fromSkus("AABCDEE"));

        assertEquals(result, 195);
    }
}
