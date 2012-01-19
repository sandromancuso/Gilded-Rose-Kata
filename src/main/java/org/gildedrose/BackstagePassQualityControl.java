package org.gildedrose;

public class BackstagePassQualityControl implements QualityControl {

	private static final int DEFAULT_QUALITY_HIKE = 1;

	public void updateQualityFor(Item backstagePass) {
		if (backstagePass.getSellIn() > 0) {
			backstagePass.setQuality(backstagePass.getQuality() + qualityHikeFor(backstagePass));
		} else {
			backstagePass.setQuality(0);
		}
	}
	
	private int qualityHikeFor(Item backstagePass) {
		return DEFAULT_QUALITY_HIKE + extraQualityFor(backstagePass);
	}

	private int extraQualityFor(Item backstagePass) {
		if (concertIsWithinSixAndTenDays(backstagePass)) {
			return 1;
		} else if (concertIsInFiveOrLessDays(backstagePass)) {
			return 2;
		}
		return 0;
	}

	private boolean concertIsInFiveOrLessDays(Item backstagePass) {
		return backstagePass.getSellIn() <= 5;
	}

	private boolean concertIsWithinSixAndTenDays(Item backstagePass) {
		return backstagePass.getSellIn() > 5 && backstagePass.getSellIn() < 11;
	}


}
