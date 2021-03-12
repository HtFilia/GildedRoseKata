package com.gildedrose;

public class BackstagePassUpdater implements IUpdater {

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn > 0 ? item.sellIn - 1 : 0;
    }

    private void updateQuality(Item item) {
        if (item.quality == 0) return;
        if (item.sellIn > 10) {
            item.quality = Math.min(item.quality + 1, 50);
        } else if (item.sellIn > 5) {
            item.quality = Math.min(item.quality + 2, 50);
        } else if (item.sellIn > 0) {
            item.quality = Math.min(item.quality + 3, 50);
        } else {
            item.quality = 0;
        }
    }

    @Override
    public void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }
}
