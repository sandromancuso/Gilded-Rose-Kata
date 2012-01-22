package org.gildedrose;

import java.util.List;

import org.gildedrose.qualitycontrol.QualityControl;
import org.gildedrose.qualitycontrol.QualityControlFactory;
import org.gildedrose.sellincontrol.SellInControl;

public class GildedRose {

	private QualityControlFactory qualityControlFactory;
	private SellInControl sellInControl;
	
	public GildedRose(QualityControlFactory qualityControl, SellInControl sellInControl) {
		this.qualityControlFactory = qualityControl;
		this.sellInControl = sellInControl;
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
		sellInControl.updateSellInFor(item);
	}

}