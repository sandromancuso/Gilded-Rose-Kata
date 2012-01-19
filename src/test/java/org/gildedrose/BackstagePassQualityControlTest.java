package org.gildedrose;

import static org.gildedrose.ItemBuilder.anItem;
import static org.gildedrose.QualityControlFactory.BACKSTAGE_PASS_ITEM_NAME;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BackstagePassQualityControlTest {

	private static final int TWENTY_DAYS = 20;
	private static final int TEN_DAYS = 10;
	private static final int FIVE_DAYS = 5;
	private static final int ZERO_DAYS = 0;
	
	private BackstagePassQualityControl qualityControl;
	private Item backstagePass;

	@Before
	public void initialise() {
		qualityControl = new BackstagePassQualityControl();
		backstagePass = anItem()
				.withName(BACKSTAGE_PASS_ITEM_NAME)
				.build();
	}
	
	@Test public void
	shouldIncreaseQualityAsDaysGoBy() {
		backstagePass.setSellIn(TWENTY_DAYS);
		backstagePass.setQuality(10);

		qualityControl.updateQualityFor(backstagePass);
		
		assertThat(backstagePass.getQuality(), is(11));
	}
	
	@Test public void
	shouldIncreaseQualityByTwoWhenNeedsToBeSoldInTenDaysOrLess() {
		backstagePass.setSellIn(TEN_DAYS);
		backstagePass.setQuality(10);
		
		qualityControl.updateQualityFor(backstagePass);
		
		assertThat(backstagePass.getQuality(), is(12));
	}
	
	@Test public void
	shouldIncreaseQualityByThreeWhenNeedsToBeSoldInFiveDaysOrLess() {
		backstagePass.setSellIn(FIVE_DAYS);
		backstagePass.setQuality(10);
		
		qualityControl.updateQualityFor(backstagePass);
		
		assertThat(backstagePass.getQuality(), is(13));
	}
	
	@Test public void
	shouldSetQualityToZeroAfterConcert() {
		backstagePass.setSellIn(ZERO_DAYS);
		backstagePass.setQuality(10);
		
		qualityControl.updateQualityFor(backstagePass);
		
		assertThat(backstagePass.getQuality(), is(0));
	}
	
	
	
}
