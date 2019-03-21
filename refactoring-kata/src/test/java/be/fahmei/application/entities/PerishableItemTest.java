package be.fahmei.application.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Perishable Items tests")
class PerishableItemTest {

    @Test
    @DisplayName("quality decreases by 1 when sellIn is not passed")
    void updateQualityWhenSellInIsNotPassedTest() {
        testValues(10, 9, 25);
    }

    @Test
    @DisplayName("quality decreases by 2 when sellIn is passed")
    void updateQualityWhenSellInIsPassedTest() {
        testValues(10, 8, -2);
    }

    void testValues(int inputQuality, int expectedQuality, int sellIn) {
        PerishableItem input = getPerishableItem(sellIn, inputQuality);
        PerishableItem expected = getPerishableItem(sellIn - 1, expectedQuality);

        input.update();

        assertEquals(input, expected);
    }

    private PerishableItem getPerishableItem(int sellIn, int quality) {
        return new PerishableItem("Tomato", sellIn, quality);
    }
}