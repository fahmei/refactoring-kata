package be.fahmei.application.entities;

public class PerishableItem extends UpdatableItem {

    public PerishableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        if (isSellDatePassed()) {
            decreaseQuality();
        }
    }
}
