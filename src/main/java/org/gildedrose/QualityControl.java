package org.gildedrose;

public interface QualityControl {
	
	int MAX_QUALITY_ALLOWED = 50;
	int DEFAULT_QUALITY_HIKE = 1;
	
	void updateQualityFor(Item item);

}