package be.fahmei.application;

import be.fahmei.application.entities.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Item factory tests")
class ItemFactoryTest {

    private final String LEGENDARY_ITEM_NAME = "Sulfuras, Hand of Ragnaros";
    private final String LASTING_ITEM_NAME = "Aged Brie";
    private final String BACKSTAGE_PASS_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private final String CONJURED_ITEM_NAME = "Conjured Mana Cake";
    private final String PERISHABLE_ITEM_NAME = "Tomato";
    private final ItemFactory factory = new ItemFactory();

    @Test
    @DisplayName("create an item")
    void createItemTest() {
        assertTrue(factory.getItem(LEGENDARY_ITEM_NAME, 1, 1) instanceof Item);
    }

    @Test
    @DisplayName("create a lasting item")
    void createLastingItemTest() {
        assertTrue(factory.getItem(LASTING_ITEM_NAME, 1, 1) instanceof LastingItem);
    }

    @Test
    @DisplayName("create a backstage pass item")
    void createBackstagePassItemTest() {
        assertTrue(factory.getItem(BACKSTAGE_PASS_ITEM_NAME, 1, 1) instanceof BackstagePassItem);
    }

    @Test
    @DisplayName("create a conjured item")
    void createConjuredItemTest() {
        assertTrue(factory.getItem(CONJURED_ITEM_NAME, 1, 1) instanceof ConjuredItem);
    }

    @Test
    @DisplayName("create a perishable item")
    void createPerishableItemTest() {
        assertTrue(factory.getItem(PERISHABLE_ITEM_NAME, 1, 1) instanceof PerishableItem);
    }

    @Test
    @DisplayName("create an item with name null")
    void createItemWithNullNameTest() {
        assertTrue(factory.getItem(null, 1, 1) == null);
    }

    @Test
    @DisplayName("create an item with blank name")
    void createItemWithBlankNameTest() {
        assertTrue(factory.getItem("", 1, 1) == null);
        assertTrue(factory.getItem("  ", 1, 1) == null);
    }


}