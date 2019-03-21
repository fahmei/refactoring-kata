package be.fahmei.application.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Backstage pass tests")
class BackstagePassItemTest {

    @Test
    @DisplayName("quality increases by 1 when more than 10 days from SellIn")
    void updateQualityTestWhenMoreThan10DaysTest() {
        testValues(5, 6, 100);
    }

    @Test
    @DisplayName("quality increases by 2 when 10 or less days from SellIn")
    void updateQualityTestWhenLessThan10DaysTest() {
        testValues(5, 7, 10);
    }

    @Test
    @DisplayName("quality increases by 3 when 5 or less days from SellIn")
    void updateQualityTestWhenLessThan5DaysTest() {
        testValues(5, 8, 5);
    }

    @Test
    @DisplayName("quality drops to 0 when SellIn is passed")
    void updateQualityTestSellInIsPassedTest() {
        testValues(5, 0, 0);
    }

    void testValues(int inputQuality, int expectedQuality, int sellIn) {
        BackstagePassItem input = getBackstagePassItem(sellIn, inputQuality);
        BackstagePassItem expected = getBackstagePassItem(sellIn - 1, expectedQuality);

        input.update();

        assertEquals(input, expected);
    }

    private BackstagePassItem getBackstagePassItem(int sellIn, int quality) {
        return new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }
}