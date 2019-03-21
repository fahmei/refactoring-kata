package be.fahmei.application;

import be.fahmei.application.entities.*;

import java.util.Arrays;
import java.util.List;

public class ItemFactory {

    private final List<String> LEGENDARY_ITEM_NAMES = Arrays.asList("Sulfuras, Hand of Ragnaros");
    private final List<String> LASTING_ITEM_NAMES = Arrays.asList("Aged Brie");
    private final List<String> BACKSTAGE_PASS_ITEM_NAMES = Arrays.asList("Backstage passes to a TAFKAL80ETC concert");
    private final List<String> CONJURED_ITEM_NAMES = Arrays.asList("Conjured Mana Cake");


    public Item getItem(String name, int sellIn, int quality) {
        if (isEmpty(name)) {
            if (isLegendaryItem(name)) return new Item(name, sellIn, quality);
            if (isLastingItem(name)) return new LastingItem(name, sellIn, quality);
            if (isBackstagePass(name)) return new BackstagePassItem(name, sellIn, quality);
            if (isConjuredItem(name)) return new ConjuredItem(name, sellIn, quality);
            else return new PerishableItem(name, sellIn, quality);
        } else {
            return null;
        }
    }

    private boolean isEmpty(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private boolean isBackstagePass(String name) {
        return BACKSTAGE_PASS_ITEM_NAMES.contains(name);
    }

    private boolean isLastingItem(String name) {
        return LASTING_ITEM_NAMES.contains(name);
    }

    private boolean isLegendaryItem(String name) {
        return LEGENDARY_ITEM_NAMES.contains(name);
    }

    private boolean isConjuredItem(String name) {
        return CONJURED_ITEM_NAMES.contains(name);
    }
}
