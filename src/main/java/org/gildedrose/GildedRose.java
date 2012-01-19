package org.gildedrose;

import java.util.List;

public class GildedRose {

	private QualityControlFactory qualityControlFactory;
	
	public GildedRose(QualityControlFactory qualityControl) {
		this.qualityControlFactory = qualityControl;
	}

	public void updateQualityFor(List<Item> items) {
		for (Item item : items) {
			udpateSellInFor(item);
			updateQualityFor(item);
		}
	}
	
	private void updateQualityFor(Item item) {
		QualityControl qualityControl = qualityControlFactory.qualityControlFor(item);
		qualityControl.updateQualityFor(item);
	}

	private void udpateSellInFor(Item item) {
		item.setSellIn(item.getSellIn() - sellInDecreaseFor(item));
	}

	private int sellInDecreaseFor(Item item) {
		return "Sulfuras, Hand of Ragnaros".equals(item.getName()) ? 0 : 1; 
	}
	
}