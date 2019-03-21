package be.fahmei.application.entities;

public class ConjuredItem extends PerishableItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.qualityModificationRate *= 2;
    }
}
