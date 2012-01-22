package org.gildedrose.sellincontrol;

import static org.gildedrose.qualitycontrol.QualityControlFactory.SULFURAS_ITEM_NAME;

import org.gildedrose.Item;

public class SellInControl {

	public void updateSellInFor(Item item) {
		item.setSellIn(item.getSellIn() - sellInDecreaseFor(item));
	}

	private int sellInDecreaseFor(Item item) {
		return SULFURAS_ITEM_NAME.equals(item.getName()) ? 0 : 1; 
	}
}
