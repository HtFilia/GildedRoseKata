package com.gildedrose;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    private final Map<String, IUpdater> updaters = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        updaters.put("Regular", new RegularUpdater());
        updaters.put("Aged Brie", new AgedBrieUpdater());
        updaters.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        updaters.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaters.put("Conjured", new ConjuredUpdater());
    }

    private IUpdater correctUpdater(Item item) {
        if (item.name.startsWith("Conjured")) {
            return updaters.get("Conjured");
        }
        return updaters.getOrDefault(item.name, updaters.get("Regular"));
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> correctUpdater(item).update(item));
    }
}