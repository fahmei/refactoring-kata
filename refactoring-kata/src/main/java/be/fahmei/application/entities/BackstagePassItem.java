package be.fahmei.application.entities;

public class BackstagePassItem extends UpdatableItem {

    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (isSellDatePassed()) {
            this.quality = 0;
        } else {
            increaseQuality();
            if (this.sellIn < 11) {
                increaseQuality();
            }
            if (this.sellIn < 6) {
                increaseQuality();
            }
        }
    }
}
