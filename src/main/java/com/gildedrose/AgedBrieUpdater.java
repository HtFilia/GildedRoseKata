package com.gildedrose;

public class AgedBrieUpdater implements IUpdater {

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn > 0 ? item.sellIn - 1 : 0;
    }

    private void updateQuality(Item item) {
        if (item.quality == 50) return;
        item.quality = item.sellIn > 0 ? Math.min(item.quality + 1, 50) :
                                         Math.min(item.quality + 2, 50);
    }

    @Override
    public void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }
}
