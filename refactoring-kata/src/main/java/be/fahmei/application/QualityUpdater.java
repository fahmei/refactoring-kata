package be.fahmei.application;

import be.fahmei.application.entities.Item;
import be.fahmei.application.entities.UpdatableItem;

import java.util.List;
import java.util.stream.Collectors;

public class QualityUpdater {

    public void update(List<Item> items) {
        items.stream()
                .filter(this::isUpdatable)
                .map(item -> (UpdatableItem) item)
                .collect(Collectors.toList())
                .forEach(UpdatableItem::update);
    }

    private boolean isUpdatable(Item item) {
        return item instanceof UpdatableItem;
    }
}
