package be.fahmei.application;

import be.fahmei.application.entities.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Quality updater tests")
class QualityUpdaterTest {

    private final QualityUpdater qualityUpdater = new QualityUpdater();

    @Test
    void updateTest() {
        List<Item> inputList = Arrays.asList(
                new LastingItem("Aged Brie", 2, 0),
                new PerishableItem("Elixir of the Mongoose", 5, 7),
                new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new ConjuredItem("Conjured Mana Cake", 3, 6)
        );

        List<Item> expectedList = Arrays.asList(
                new LastingItem("Aged Brie", 1, 1),
                new PerishableItem("Elixir of the Mongoose", 4, 6),
                new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new ConjuredItem("Conjured Mana Cake", 2, 4)
        );

        qualityUpdater.update(inputList);

        assertEquals(inputList, expectedList);

    }
}