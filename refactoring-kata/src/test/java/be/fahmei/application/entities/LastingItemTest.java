package be.fahmei.application.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lasting pass tests")
class LastingItemTest {

    @Test
    @DisplayName("quality increases by 1 when sellIn is not passed")
    void updateQualityWhenSellInIsNotPassedTest() {
        testValues(10, 11, 25);
    }

    @Test
    @DisplayName("quality increases by 2 when sellIn is passed")
    void updateQualityWhenSellInIsPassedTest() {
        testValues(10, 12, -2);
    }

    void testValues(int inputQuality, int expectedQuality, int sellIn) {
        LastingItem input = getLastingItem(sellIn, inputQuality);
        LastingItem expected = getLastingItem(sellIn - 1, expectedQuality);

        input.update();

        assertEquals(input, expected);
    }

    private LastingItem getLastingItem(int sellIn, int quality) {
        return new LastingItem("Aged Brie", sellIn, quality);
    }

}