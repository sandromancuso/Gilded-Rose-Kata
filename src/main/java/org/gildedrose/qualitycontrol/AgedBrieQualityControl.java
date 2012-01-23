package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public class AgedBrieQualityControl implements QualityControl {

	public void updateQualityFor(Item item) {
		if (item.getQuality() < MAX_QUALITY_ALLOWED) {
			item.setQuality(item.getQuality() + DEFAULT_QUALITY_HIKE);
		}
	}

}
