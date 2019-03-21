package be.fahmei.application;

import be.fahmei.application.entities.Item;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemFactory factory = new ItemFactory();

        List<Item> items = Arrays.asList(
                factory.getItem("+5 Dexterity Vest", 10, 20),
                factory.getItem("Aged Brie", 2, 0),
                factory.getItem("Elixir of the Mongoose", 5, 7),
                factory.getItem("Sulfuras, Hand of Ragnaros", 0, 80),
                factory.getItem("Sulfuras, Hand of Ragnaros", -1, 80),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                factory.getItem("Conjured Mana Cake", 3, 6)
        );

        int days = (args.length > 0) ? Integer.parseInt(args[0]) + 1 : 10;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            QualityUpdater.update(items);
        }

    }
}
