package org.gildedrose.qualitycontrol;

import static org.gildedrose.builder.ItemBuilder.anItem;
import static org.gildedrose.qualitycontrol.QualityControlFactory.CONJURED_ITEM_NAME;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.gildedrose.Item;
import org.gildedrose.qualitycontrol.ConjuredQualityControl;
import org.junit.Test;

public class ConjuredQualityControlTest {
	
	private ConjuredQualityControl conjuredQualityControl = new ConjuredQualityControl();

	@Test public void
	shouldDecreaseQualityByTwoForAllConjuredItems() {
		Item conjured = anItem()
				.withName(CONJURED_ITEM_NAME)
				.withQuality(20)
				.withSellIn(10).build();
		
		conjuredQualityControl.updateQualityFor(conjured);
		
		assertThat(conjured.getQuality(), is(18));
	}

	@Test public void
	shouldNeverSetQualityForLessThanZero() {
		Item conjured = anItem()
				.withName(CONJURED_ITEM_NAME)
				.withQuality(0)
				.withSellIn(10).build();
		
		conjuredQualityControl.updateQualityFor(conjured);
		
		assertThat(conjured.getQuality(), is(0));
	}
	

}
