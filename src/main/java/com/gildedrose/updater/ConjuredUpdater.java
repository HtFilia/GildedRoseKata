/**
 *  Copyright Murex S.A.S., 2003-2021. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.gildedrose.updater;

import com.gildedrose.Item;


public final class ConjuredUpdater implements IUpdater {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }

    private void updateSellIn(Item item) {
        item.sellIn = (item.sellIn > 0) ? (item.sellIn - 1) : 0;
    }

    private void updateQuality(Item item) {
        if (item.quality == 0)
            return;
        item.quality = (item.sellIn > 0) ? Math.max(item.quality - 2, 0) : Math.max(item.quality - 4, 0);
    }
}
