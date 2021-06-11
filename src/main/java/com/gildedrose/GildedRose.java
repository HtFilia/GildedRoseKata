/**
 *  Copyright Murex S.A.S., 2003-2021. All Rights Reserved.
 * 
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.gildedrose;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.gildedrose.updater.AgedBrieUpdater;
import com.gildedrose.updater.BackstagePassUpdater;
import com.gildedrose.updater.ConjuredUpdater;
import com.gildedrose.updater.IUpdater;
import com.gildedrose.updater.RegularUpdater;
import com.gildedrose.updater.SulfurasUpdater;
import com.gildedrose.util.NameUtil;


class GildedRose {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    Item[] items;
    private final Map<String, IUpdater> updaters = new HashMap<>();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors 
    //~ ----------------------------------------------------------------------------------------------------------------

    public GildedRose(Item[] items) {
        this.items = items;
        updaters.put(NameUtil.REGULAR, new RegularUpdater());
        updaters.put(NameUtil.AGED_BRIE, new AgedBrieUpdater());
        updaters.put(NameUtil.SULFURAS, new SulfurasUpdater());
        updaters.put(NameUtil.CONCERT, new BackstagePassUpdater());
        updaters.put(NameUtil.CONJURED, new ConjuredUpdater());
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> correctUpdater(item).update(item));
    }

    private IUpdater correctUpdater(Item item) {
        if (item.name.startsWith(NameUtil.CONJURED)) {
            return updaters.get(NameUtil.CONJURED);
        }
        return updaters.getOrDefault(item.name, updaters.get(NameUtil.REGULAR));
    }
}
