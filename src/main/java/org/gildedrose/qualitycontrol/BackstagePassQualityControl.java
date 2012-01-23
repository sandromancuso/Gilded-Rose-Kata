package org.gildedrose.qualitycontrol;

import org.gildedrose.Item;

public class BackstagePassQualityControl implements QualityControl {

	private static final int ELEVE_DAYS = 11;
	private static final int FIVE_DAYS = 5;
	
	private static final int NO_EXTRA_QUALITY_HIKE = 0;
	private static final int DOUBLE_EXTRA_QUALITY_HIKE = 2;
	private static final int EXTRA_QUALITY_HIKE = 1;

	public void updateQualityFor(Item backstagePass) {
		if (backstagePass.getSellIn() > 0) {
			backstagePass.setQuality(backstagePass.getQuality() + qualityHikeFor(backstagePass));
			if (backstagePass.getQuality() > MAX_QUALITY_ALLOWED) {
				backstagePass.setQuality(MAX_QUALITY_ALLOWED);
			}
		} else {
			backstagePass.setQuality(0);
		}
	}
	
	private int qualityHikeFor(Item backstagePass) {
		return DEFAULT_QUALITY_HIKE + extraQualityFor(backstagePass);
	}

	private int extraQualityFor(Item backstagePass) {
		if (concertIsWithinSixAndTenDays(backstagePass)) {
			return EXTRA_QUALITY_HIKE;
		} else if (concertIsInFiveOrLessDays(backstagePass)) {
			return DOUBLE_EXTRA_QUALITY_HIKE;
		}
		return NO_EXTRA_QUALITY_HIKE;
	}

	private boolean concertIsInFiveOrLessDays(Item backstagePass) {
		return backstagePass.getSellIn() <= FIVE_DAYS;
	}

	private boolean concertIsWithinSixAndTenDays(Item backstagePass) {
		return backstagePass.getSellIn() > FIVE_DAYS && backstagePass.getSellIn() < ELEVE_DAYS;
	}


}
