package com.gildedrose;

import java.util.Arrays;

public class UpdatedGildedRose {

    private final ItemValue itemValue;

    public UpdatedGildedRose(ItemValue itemValue) {
        this.itemValue = itemValue;
    }

    public void doUpdate(Item[] items) {
        //maybe turn through another list and do things accordingly
        // Arrays.stream(items).anyMatch(item -> item.name.equals(itemValue.getPotion()));
        Arrays.stream(items).forEach(item -> updateOnNormalItem(item.quality));
    }

    private int updateOnNormalItem(int quality) {
        return quality = quality - 1;
    }
}
