package com.gildedrose;

class GildedRose {
    Item[] items;
    ItemValue itemValue = new ItemValue();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public UpdatedGildedRose updatedGildedRose;

    public void updateQuality() {
        if (true){
            updatedGildedRose.doUpdate(items);
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
        return item.name.equals(itemValue.getSulfuras_hand_of_ragnaros());
    }

    private boolean IsConcertTicket(Item item) {
        return item.name.equals(itemValue.getBackstage_passes_to_a_TAFKAL80ETC_concert());
    }

    private boolean IsAgedBrie(Item item) {
        return item.name.equals(itemValue.getAged_brie());
    }

    private boolean itemQualityIsOverZero(Item item) {
        return item.quality > 0;
    }

    private boolean itemQualityBelowFifty(int quality, int i2) {
        return quality < i2;
    }
}
