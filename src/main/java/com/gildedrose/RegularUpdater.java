package com.gildedrose;

public class RegularUpdater implements IUpdater {

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn > 0 ? item.sellIn - 1 : 0;
    }

    private void updateQuality(Item item) {
        if (item.quality == 0) return;
        item.quality = item.sellIn > 0 ? Math.max(item.quality - 1, 0) : Math.max(item.quality - 2, 0);
    }

    @Override
    public void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }
}
