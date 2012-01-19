package org.gildedrose;

public class AgedBrieQualityControl implements QualityControl {

	public void updateQualityFor(Item item) {
		if (item.getQuality() < MAX_QUALITY_ALLOWED) {
			item.setQuality(item.getQuality() + 1);
		}
	}

}
