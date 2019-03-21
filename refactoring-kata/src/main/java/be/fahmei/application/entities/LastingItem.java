package be.fahmei.application.entities;

public class LastingItem extends UpdatableItem {
    public LastingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        if (isSellDatePassed()) {
            increaseQuality();
        }
    }

}
