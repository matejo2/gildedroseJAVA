package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QualityTest {

    ItemValue itemValue = new ItemValue();

    @Test
    public void QualityNeverDropsBelow_0() {
        Item[] items = new Item[]{
                new Item(ItemValue.POTION, 0, 0),
                new Item(ItemValue.ELIXIR_OF_THE_MOONGOOSE, 2, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(0);
        assertThat(items[1].quality).isEqualTo(0);
    }

    @Test
    public void QualityDropsByOne() {
        Item[] items = new Item[]{
                new Item(ItemValue.POTION, 12, 30),
                new Item(ItemValue.ELIXIR_OF_THE_MOONGOOSE, 12, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString() + "\n" + items[1].toString());
        assertThat(items[0].quality).isEqualTo(26);
        assertThat(items[1].quality).isEqualTo(16);
    }

    @Test
    public void QualityDropsDoulbeWhenSellInPasses() {
        Item[] items = new Item[]{
                new Item(ItemValue.POTION, 0, 30),
                new Item(ItemValue.ELIXIR_OF_THE_MOONGOOSE, 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString() + "\n" + items[1].toString());
        assertThat(items[0].quality).isEqualTo(22);
        assertThat(items[1].quality).isEqualTo(12);
    }

    @Test
    public void QualityIsNeverOver_50() {
        Item[] items = new Item[]{
                new Item(ItemValue.AGED_BRIE, 9, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString());
        assertThat(items[0].quality).isEqualTo(50);
    }

    @Ignore //because cursed attribute isn't added yet
    @Test
    public void CursedItemQualityDropsDouble() {
        Item[] items = new Item[]{
                new Item(ItemValue.CURSED_SWORD, 20, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString());
        assertThat(items[0].quality).isEqualTo(44);
    }

    @Test
    public void SulfurasQualityIsAlways_80() {
        Item[] items = new Item[]{
                new Item(ItemValue.SULFURAS_HAND_OF_RAGNAROS, 9, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString());
        assertThat(items[0].quality).isEqualTo(80);
    }


    @Test
    public void AgedBrieQualityIncreases() {
        Item[] items = new Item[]{
                new Item(ItemValue.AGED_BRIE, 12, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString());
        assertThat(items[0].quality).isEqualTo(2);
    }

    @Test
    public void BackstagePassesQualityIncreasesWhenSellInOver_10() {
        Item[] items = new Item[]{
                new Item(ItemValue.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 12, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString());
        assertThat(items[0].quality).isEqualTo(2);
    }

    @Test
    public void BackstagePassesQualityIncreasesBy_2_WhenSellInBelow_10() {
        Item[] items = new Item[]{
                new Item(ItemValue.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 9, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString());
        assertThat(items[0].quality).isEqualTo(4);
    }

    @Test
    public void BackstagePassesQualityIncreasesBy_3_WhenSellInBelow_5() {
        Item[] items = new Item[]{
                new Item(ItemValue.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 4, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString());
        assertThat(items[0].quality).isEqualTo(6);
    }

    @Test
    public void BackstagePassesQualityDropsTo_0_WhenSellInBelow_0() {
        Item[] items = new Item[]{
                new Item(ItemValue.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, 0, 23)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString());
        assertThat(items[0].quality).isEqualTo(0);
    }
}
