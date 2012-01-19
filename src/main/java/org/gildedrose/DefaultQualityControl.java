package org.gildedrose;

public class DefaultQualityControl implements QualityControl {

	public void updateQualityFor(Item item) {
		if (qualityCanBeDecreasedFor(item)) {
			item.setQuality(item.getQuality() - qualityDropFor(item));
		} 
	}
	
	private int qualityDropFor(Item item) {
		return ("Conjured Mana Cake".equals(item.getName()) || item.getSellIn() < 0)
					? 2 
					: 1;
	}
	
	private boolean qualityCanBeDecreasedFor(Item item) {
		return item.getQuality() > 0;
	}

}
