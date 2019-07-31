package com.gildedrose;

class GildedRose {
    Item[] items;
    ItemNames itemNames = new ItemNames();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            int Fifty = 50;
            int Eleven = 11;


            if (!IsAgedBrie(items[i], itemNames.aged_brie)
                    && !IsConcertTicket(items[i], itemNames.backstage_passes_to_a_TAFKAL80ETC_concert)) {
                if (itemQualityIsOverZero(items[i])) {
                    if (!IsSulfuras(items[i], itemNames.sulfuras_hand_of_ragnaros)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (itemQualityBelowFifty(items[i].quality, Fifty)) {
                    items[i].quality = items[i].quality + 1;

                    if (IsConcertTicket(items[i], itemNames.backstage_passes_to_a_TAFKAL80ETC_concert)) {

                        if (items[i].sellIn < Eleven) {
                            if (items[i].quality < Fifty) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (itemQualityBelowFifty(items[i].quality, Fifty)) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!IsSulfuras(items[i], itemNames.sulfuras_hand_of_ragnaros)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!IsAgedBrie(items[i], itemNames.aged_brie)) {
                    if (!IsConcertTicket(items[i], itemNames.backstage_passes_to_a_TAFKAL80ETC_concert)) {
                        if (itemQualityIsOverZero(items[i])) {
                            if (!IsSulfuras(items[i], itemNames.sulfuras_hand_of_ragnaros)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (itemQualityBelowFifty(items[i].quality, Fifty)) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private boolean IsSulfuras(Item item, String sulfuras_hand_of_ragnaros) {
        return item.name.equals(sulfuras_hand_of_ragnaros);
    }

    private boolean IsConcertTicket(Item item, String backstage_passes_to_a_tafkal80ETC_concert) {
        return item.name.equals(backstage_passes_to_a_tafkal80ETC_concert);
    }

    private boolean IsAgedBrie(Item item, String aged_brie) {
        return item.name.equals(aged_brie);
    }

    private boolean itemQualityIsOverZero(Item item) {
        return item.quality > 0;
    }

    private boolean itemQualityBelowFifty(int quality, int i2) {
        return quality < i2;
    }
}
