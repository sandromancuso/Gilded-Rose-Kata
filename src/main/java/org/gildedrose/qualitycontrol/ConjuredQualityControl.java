package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public class ConjuredQualityControl implements QualityControl {

	private static final int CONJURED_QUALITY_DROP = DEFAULT_QUALITY_DROP * 2;

	public void updateQualityFor(Item item) {
		item.setQuality(item.getQuality() - qualityDropFor(item));
	}

	private int qualityDropFor(Item item) {
		return item.getQuality() - CONJURED_QUALITY_DROP > 0
					? CONJURED_QUALITY_DROP
				    : item.getQuality();
						
	}

}
