package org.gildedrose.builder;

import org.gildedrose.Item;


public class ItemBuilder {

	private String name;
	private int sellIn = 1;
	private int quality = 1;

	public static ItemBuilder anItem() {
		return new ItemBuilder();
	}

	public ItemBuilder withQuality(int quality) {
		this.quality = quality;
		return this;
	}

	public ItemBuilder withSellIn(int sellIn) {
		this.sellIn = sellIn;
		return this;
	}

	public ItemBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public Item build() {
		return new Item(name, sellIn, quality);
	}

}
