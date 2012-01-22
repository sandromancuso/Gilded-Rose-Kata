package org.gildedrose.qualitycontrol;

import static org.gildedrose.builder.ItemBuilder.anItem;
import static org.gildedrose.qualitycontrol.QualityControlFactory.AGED_BRIE_ITEM_NAME;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.gildedrose.Item;
import org.gildedrose.qualitycontrol.AgedBrieQualityControl;
import org.junit.Test;

public class AgedBrieQualityControlTest {
	
	private static final String AGED_BRIE = AGED_BRIE_ITEM_NAME;
	
	private AgedBrieQualityControl agedBrieQualityControl = new AgedBrieQualityControl();
	
	@Test public void
	shouldIncreaseAgedBrieWheverItGetsOlder() {
		Item agedBrie = anItem().withName(AGED_BRIE).withQuality(10).build();
		
		agedBrieQualityControl.updateQualityFor(agedBrie);
		
		assertThat(agedBrie.getQuality(), is(11));
	}
	
	@Test public void
	shouldNeverIncreaseTheQualityToMoreThanFifty() {
		Item agedBrie = anItem().withName("Aged Brie").withQuality(50).build();
		
		agedBrieQualityControl.updateQualityFor(agedBrie);
		
		assertThat(agedBrie.getQuality(), is(50));
	}
	
}
