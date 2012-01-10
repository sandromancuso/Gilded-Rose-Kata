package org.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateQuality(items);
	}

	public static void updateQuality(List<Item> items) {
		for (Item item : items) {
			udpateSellInFor(item);
			updateQualityFor(item);
		}
	}
	
	private static void udpateSellInFor(Item item) {
		item.setSellIn(item.getSellIn() - sellInDecreaseFor(item));
	}

	private static int sellInDecreaseFor(Item item) {
		return "Sulfuras, Hand of Ragnaros".equals(item.getName()) ? 0 : 1; 
	}
	
	private static void updateQualityFor(Item item) {
		if (qualityCanBeIncreasedFor(item)) {
			item.setQuality(item.getQuality() + qualityHikeFor(item));
		}
		
		if (qualityCanBeDecreasedFor(item)) {
			item.setQuality(item.getQuality() - qualityDropFor(item));
		} 

		if (item.getSellIn() < 0 && !qualityCanBeDecreasedFor(item)) {
			item.setQuality(0);
		}
	}

	private static int qualityDropFor(Item item) {
		return item.getSellIn() < 0 ? 2 : 1;
	}
	
	private static int qualityHikeFor(Item item) {
		int qualityHike = 1;

		if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
			if (item.getSellIn() < 11 && item.getQuality() < 50) {
				qualityHike++;
			}

			if (item.getSellIn() < 6 && item.getQuality() < 50) {
				qualityHike++;
			}
		}

		return qualityHike;
	}
	
	private static boolean qualityCanBeIncreasedFor(Item item) {
		return !qualityDecreasesAsItGetsOlder(item) && item.getQuality() < 50;
	}

	private static boolean qualityCanBeDecreasedFor(Item item) {
		return qualityDecreasesAsItGetsOlder(item) 
			&& item.getQuality() > 0 
			&& !"Sulfuras, Hand of Ragnaros".equals(item.getName());
	}

	private static boolean qualityDecreasesAsItGetsOlder(Item item) {
		return !"Aged Brie".equals(item.getName())
			&& !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
	}

}