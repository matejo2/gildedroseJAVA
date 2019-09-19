package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        Arrays.stream(items).forEach(this::doStuffForEachItem);
    }

    private void doStuffForEachItem(Item item) {

        if (item.name.equals(ItemValue.SULFURAS_HAND_OF_RAGNAROS)) {
            return;
        }

        if (item.name.equals(ItemValue.AGED_BRIE)) {
            item.quality = IncreaseQuality(item);
        }

        if (item.name.equals(ItemValue.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
            item.quality = IncreaseQuality(item);
            if (item.sellIn < 11) {
                item.quality = IncreaseQuality(item);

            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = IncreaseQuality(item);
                }
            }

        }

        if (!IsAgedBrie(item) && !IsConcertTicket(item)) {
            if (itemQualityIsOverZero(item)) {
                if (!IsSulfuras(item)) {
                    item.quality = DecreaseQuality(item);
                }
            }
        }

        item.sellIn = item.sellIn - 1;
        UpdateQualityWhenSellInIsBelowZero(item);
    }

    private void UpdateQualityWhenSellInIsBelowZero(Item item) {
        if (item.sellIn < 0) {
            if (!IsAgedBrie(item)) {
                if (!IsConcertTicket(item)) {
                    if (itemQualityIsOverZero(item)) {
                        item.quality = DecreaseQuality(item);

                    }
                } else {
                    item.quality = 0;
                }
            }
        }
    }


    private int DecreaseQuality(Item item) {
        return item.quality - 1;
    }

    private int IncreaseQuality(Item item) {
        if (item.quality == 50) {
            return 50;
        }
        return item.quality + 1;
    }

    private boolean IsSulfuras(Item item) {
        return item.name.equals(ItemValue.SULFURAS_HAND_OF_RAGNAROS);
    }

    private boolean IsConcertTicket(Item item) {
        return item.name.equals(ItemValue.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT);
    }

    private boolean IsAgedBrie(Item item) {
        return item.name.equals(ItemValue.AGED_BRIE);
    }

    private boolean itemQualityIsOverZero(Item item) {
        return item.quality > 0;
    }

}
