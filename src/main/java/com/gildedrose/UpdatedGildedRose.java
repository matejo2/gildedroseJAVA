package com.gildedrose;

import java.util.Arrays;

public class UpdatedGildedRose {
    public void update(Item[] items) {
        Arrays.stream(items)
                .map(this::decreaseItem)
                .toArray();
    }

    private Item decreaseItem(Item item) {
        //aged brie
        if(item.name == ItemValue.AGED_BRIE){
            item.quality = IncreaseQuality(item.quality);
        }
        else {
            item.quality = DecreaseQuality(item.quality);
        }
        item.sellIn = item.sellIn - 1;
        return item;
    }

    private int IncreaseQuality(int quality) {
        if (quality == 50) {
            return 50;
        }
        return quality +1;
    }

    private int DecreaseQuality(int quality) {
        if (quality == 0){
            return 0;
        }
        return quality -1;
    }
}
