package be.fahmei.application;

import be.fahmei.application.entities.Item;
import be.fahmei.application.entities.UpdatableItem;

import java.util.List;
import java.util.stream.Collectors;

public final class QualityUpdater {

    public static void update(List<Item> items) {
        items.stream()
                .filter(QualityUpdater::isUpdatable)
                .map(item -> (UpdatableItem) item)
                .collect(Collectors.toList())
                .forEach(UpdatableItem::update);
    }

    private static boolean isUpdatable(Item item) {
        return item instanceof UpdatableItem;
    }
}
