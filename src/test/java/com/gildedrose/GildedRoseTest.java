package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    ItemValue itemValue = new ItemValue();

    @Test
    public void ItemExists() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void QualityNeverDropsBelow_0() {
        Item[] items = new Item[]{
                new Item(itemValue.potion, 0, 0),
                new Item(itemValue.elixir_of_mongoose, 2, 1)};
        GildedRose app  = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(0);
        assertThat(items[1].quality).isEqualTo(0);
    }

    @Test
    public void QualityDropsDoulbeWhenSellInPasses() {
        Item[] items = new Item[]{
                new Item(itemValue.potion, 0, 30),
                new Item(itemValue.elixir_of_mongoose, 0, 20)};
        GildedRose app  = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString() + "\n" + items[1].toString());
        assertThat(items[0].quality).isEqualTo(22);
        assertThat(items[1].quality).isEqualTo(12);
    }

    @Test
    public void QualityDropsByOne() {
        Item[] items = new Item[]{
                new Item(itemValue.potion, 12, 30),
                new Item(itemValue.elixir_of_mongoose, 12, 20)};
        GildedRose app  = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        System.out.println(items[0].toString() + "\n" + items[1].toString());
        assertThat(items[0].quality).isEqualTo(26);
        assertThat(items[1].quality).isEqualTo(16);
    }
}

