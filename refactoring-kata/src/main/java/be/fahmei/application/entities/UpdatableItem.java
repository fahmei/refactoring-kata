package be.fahmei.application.entities;

import java.util.Objects;

public abstract class UpdatableItem extends Item {
    private final int MIN_QUALITY = 0;

    private final int MAX_QUALITY = 50;
    protected int qualityModificationRate = 1;

    public UpdatableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateQuality();

    public void update() {
        decreaseSellIn();
        updateQuality();
    }

    protected void decreaseQuality() {
        if (!isQualityAtMin()) {
            this.quality -= qualityModificationRate;
        }
    }

    protected void increaseQuality() {
        if (!isQualityAtMax()) {
            this.quality += qualityModificationRate;
        }
    }

    protected boolean isQualityAtMin() {
        return this.quality <= MIN_QUALITY;
    }

    protected boolean isQualityAtMax() {
        return this.quality >= MAX_QUALITY;
    }

    protected boolean isSellDatePassed() {
        return this.sellIn < 0;
    }

    protected void decreaseSellIn() {
        this.sellIn--;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return sellIn == item.sellIn &&
                quality == item.quality &&
                name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }
}
