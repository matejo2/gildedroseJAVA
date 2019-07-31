package com.gildedrose;

class GildedRose {
    Item[] items;
    ItemNames itemNames = new ItemNames();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals(itemNames.aged_brie)
                    && !items[i].name.equals(itemNames.backstage_passes_to_a_TAFKAL80ETC_concert)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(itemNames.sulfuras_hand_of_ragnaros)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(itemNames.backstage_passes_to_a_TAFKAL80ETC_concert)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(itemNames.sulfuras_hand_of_ragnaros)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(itemNames.aged_brie)) {
                    if (!items[i].name.equals(itemNames.backstage_passes_to_a_TAFKAL80ETC_concert)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(itemNames.sulfuras_hand_of_ragnaros)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
