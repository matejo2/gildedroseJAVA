package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    UpdatedGildedRose updatedGildedRose = new UpdatedGildedRose();

    public void updateQuality() {

        Arrays.stream(items).forEach(this::doStuffForEachItem);

    }

    private void doStuffForEachItem(Item item) {
        int Fifty = 50;
        int Eleven = 11;


        if (!IsAgedBrie(item) && !IsConcertTicket(item)) {
            if (itemQualityIsOverZero(item)) {
                if (!IsSulfuras(item)) {
                    item.quality = DecreaseQuality(item);
                }
            }
        }
        else {
            if (itemQualityBelowFifty(item.quality)) {
                item.quality = IncreaseQuality(item);
            }
            if (IsConcertTicket(item)) {

                if (item.sellIn < Eleven) {
                    if (item.quality < Fifty) {
                        item.quality = IncreaseQuality(item);
                    }
                }

                if (item.sellIn < 6) {
                    if (itemQualityBelowFifty(item.quality)) {
                        item.quality = IncreaseQuality(item);
                    }
                }
            }

        }

        if (!IsSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!IsAgedBrie(item)) {
                if (!IsConcertTicket(item)) {
                    if (itemQualityIsOverZero(item)) {
                        if (!IsSulfuras(item)) {
                            item.quality = DecreaseQuality(item);
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (itemQualityBelowFifty(item.quality)) {
                    item.quality = IncreaseQuality(item);
                }
            }
        }
    }


    private int DecreaseQuality(Item item) {
        return item.quality - 1;
    }

    private int IncreaseQuality(Item item) {
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

    private boolean itemQualityBelowFifty(int quality) {
        return quality < 50;
    }
}
