package org.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private QualityControl qualityControl;
	
	public GildedRose(QualityControl qualityControl) {
		this.qualityControl = qualityControl;
	}

	public void updateQualityFor(List<Item> items) {
		for (Item item : items) {
			udpateSellInFor(item);
			qualityControl.updateQualityFor(item);
		}
	}
	
	private void udpateSellInFor(Item item) {
		item.setSellIn(item.getSellIn() - sellInDecreaseFor(item));
	}

	private int sellInDecreaseFor(Item item) {
		return "Sulfuras, Hand of Ragnaros".equals(item.getName()) ? 0 : 1; 
	}

	public static void main(String[] args) {

		System.out.println("OMGHAI!");
		List<Item> items = null;

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		GildedRose gildedRose = new GildedRose(new QualityControl());
		gildedRose.updateQualityFor(items);
	}

	
	
}