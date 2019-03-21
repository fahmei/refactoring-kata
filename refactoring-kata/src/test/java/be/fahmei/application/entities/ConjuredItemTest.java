package be.fahmei.application.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Conjured pass tests")
class ConjuredItemTest {

    @Test
    @DisplayName("quality decreases by double the rate of a perishable when sellIn is not passed")
    void updateQualityWhenSellInIsNotPassed() {
        testValues(10, 8, 25);
    }

    @Test
    @DisplayName("quality decreases by by double the rate of a perishable when sellIn is passed")
    void updateQualityWhenSellInIsPassed() {
        testValues(10, 6, -2);
    }

    void testValues(int inputQuality, int expectedQuality, int sellIn) {
        ConjuredItem conjuredItemInput = getConjuredItem(sellIn, inputQuality);
        PerishableItem perishableItemInput = getPerishableItem(sellIn, inputQuality);
        ConjuredItem expected = getConjuredItem(sellIn - 1, expectedQuality);

        conjuredItemInput.update();

        perishableItemInput.update();
        perishableItemInput.update();

        assertEquals(perishableItemInput.quality, expected.quality);
    }

    private ConjuredItem getConjuredItem(int sellIn, int quality) {
        return new ConjuredItem("Aged Brie", sellIn, quality);
    }

    private PerishableItem getPerishableItem(int sellIn, int quality) {
        return new PerishableItem("Tomato", sellIn, quality);
    }

}