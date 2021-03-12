package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void RegularItemTest() {
        Item[] items = new Item[] { new Item("foo", 2, 3) };
        assertEquals("foo", items[0].name);
        assertEquals(2, items[0].sellIn);
        assertEquals(3, items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", items[0].name);
        assertEquals(1, items[0].sellIn);
        assertEquals(2, items[0].quality);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(0, items[0].quality);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void AgedBrieTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 48) };
        assertEquals("Aged Brie", items[0].name);
        assertEquals(2, items[0].sellIn);
        assertEquals(48, items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", items[0].name);
        assertEquals(1, items[0].sellIn);
        assertEquals(49, items[0].quality);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(50, items[0].quality);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void SulfurasTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 3) };
        assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
        assertEquals(2, items[0].sellIn);
        assertEquals(3, items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
        assertEquals(2, items[0].sellIn);
        assertEquals(3, items[0].quality);
    }

    @Test
    void BackstagePassTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10),
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 7, 10),
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 2, 10),
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10)
                                  };
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
        assertEquals(12, items[0].sellIn);
        assertEquals(10, items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
        assertEquals(11, items[0].sellIn);
        assertEquals(6, items[1].sellIn);
        assertEquals(1, items[2].sellIn);
        assertEquals(0, items[3].sellIn);
        assertEquals(11, items[0].quality);
        assertEquals(12, items[1].quality);
        assertEquals(13, items[2].quality);
        assertEquals(0, items[3].quality);
    }

    @Test
    void ConjuredItemTest() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 2, 7) };
        assertEquals("Conjured Mana Cake", items[0].name);
        assertEquals(2, items[0].sellIn);
        assertEquals(7, items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", items[0].name);
        assertEquals(1, items[0].sellIn);
        assertEquals(5, items[0].quality);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(1, items[0].quality);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

}
