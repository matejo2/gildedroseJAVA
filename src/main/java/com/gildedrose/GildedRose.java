package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    UpdatedGildedRose updatedGildedRose = new UpdatedGildedRose();

    public void updateQuality() {
        if (false) {
            updatedGildedRose.update(items);
            return;
        }
        for (int i = 0; i < items.length; i++) {

            int Fifty = 50;
            int Eleven = 11;


            if (!IsAgedBrie(items[i])
                    && !IsConcertTicket(items[i])) {
                if (itemQualityIsOverZero(items[i])) {
                    if (!IsSulfuras(items[i])) {
                        items[i].quality = DecreaseQuality(items[i].quality);
                    }
                }
            } else {
                if (itemQualityBelowFifty(items[i].quality, Fifty)) {
                    items[i].quality = IncreaseQuality(items[i]);

                    if (IsConcertTicket(items[i])) {

                        if (items[i].sellIn < Eleven) {
                            if (items[i].quality < Fifty) {
                                items[i].quality = IncreaseQuality(items[i]);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (itemQualityBelowFifty(items[i].quality, Fifty)) {
                                items[i].quality = IncreaseQuality(items[i]);
                            }
                        }
                    }
                }
            }

            if (!IsSulfuras(items[i])) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!IsAgedBrie(items[i])) {
                    if (!IsConcertTicket(items[i])) {
                        if (itemQualityIsOverZero(items[i])) {
                            if (!IsSulfuras(items[i])) {
                                items[i].quality = DecreaseQuality(items[i].quality);
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (itemQualityBelowFifty(items[i].quality, Fifty)) {
                        items[i].quality = IncreaseQuality(items[i]);
                    }
                }
            }
        }
    }



    private int DecreaseQuality(int quality) {
        return quality - 1;
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

    private boolean itemQualityBelowFifty(int quality, int i2) {
        return quality < i2;
    }
}
