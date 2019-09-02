package com.gildedrose;

import java.util.Arrays;

public class UpdatedGildedRose {

    private final ItemValue itemValue;

    public UpdatedGildedRose(ItemValue itemValue) {
        this.itemValue = itemValue;
    }

    public void doUpdate(Item[] items) {
        Arrays.stream(items).anyMatch(item -> item.name == itemValue.cursed_sword);
    }
}
