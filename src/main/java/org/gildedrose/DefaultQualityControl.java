package org.gildedrose;

public class DefaultQualityControl implements QualityControl {

	private static final int DEFAULT_QUALITY_HIKE = 1;

	public void updateQualityFor(Item item) {
		if (qualityCanBeIncreasedFor(item)) {
			item.setQuality(item.getQuality() + DEFAULT_QUALITY_HIKE);
		}
		
		if (qualityCanBeDecreasedFor(item)) {
			item.setQuality(item.getQuality() - qualityDropFor(item));
		} 

	}
	
	private int qualityDropFor(Item item) {
		return ("Conjured Mana Cake".equals(item.getName()) || item.getSellIn() < 0)
					? 2 
					: 1;
	}
	
	private boolean qualityCanBeIncreasedFor(Item item) {
		return !qualityDecreasesAsItGetsOlder(item) && item.getQuality() < 50;
	}

	private boolean qualityCanBeDecreasedFor(Item item) {
		return qualityDecreasesAsItGetsOlder(item) && item.getQuality() > 0;
	}

	private boolean qualityDecreasesAsItGetsOlder(Item item) {
		return !"Aged Brie".equals(item.getName());
	}
	
}
