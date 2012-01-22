package org.gildedrose.qualitycontrol;

import static org.gildedrose.builder.ItemBuilder.anItem;
import static org.gildedrose.qualitycontrol.QualityControlFactory.AGED_BRIE_ITEM_NAME;
import static org.gildedrose.qualitycontrol.QualityControlFactory.BACKSTAGE_PASS_ITEM_NAME;
import static org.gildedrose.qualitycontrol.QualityControlFactory.CONJURED_ITEM_NAME;
import static org.gildedrose.qualitycontrol.QualityControlFactory.SULFURAS_ITEM_NAME;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.gildedrose.qualitycontrol.AgedBrieQualityControl;
import org.gildedrose.qualitycontrol.BackstagePassQualityControl;
import org.gildedrose.qualitycontrol.ConjuredQualityControl;
import org.gildedrose.qualitycontrol.DefaultQualityControl;
import org.gildedrose.qualitycontrol.QualityControl;
import org.gildedrose.qualitycontrol.QualityControlFactory;
import org.gildedrose.qualitycontrol.SulfurasQualityControl;
import org.junit.Before;
import org.junit.Test;

public class QualityControlFactoryTest {
	
	private QualityControlFactory factory;

	@Before 
	public void initialise() {
		factory = new QualityControlFactory();
	}
	
	@Test public void
	shouldReturnDefaultQualityControlStrategy() {
		QualityControl qualityControl = factory.qualityControlFor(anItem().build());
		
		assertThat(qualityControl, is(instanceOf(DefaultQualityControl.class)));
	}
	
	@Test public void
	shouldReturnBackstageQualityControlWhenItemIsABackstatePass() {
		QualityControl qualityControl = factory.qualityControlFor(
				anItem().withName(BACKSTAGE_PASS_ITEM_NAME).build());
		
		assertThat(qualityControl, is(instanceOf(BackstagePassQualityControl.class)));
	}

	@Test public void
	shouldReturnSulfurasQualityControlWhenItemIsASulfuras() {
		QualityControl qualityControl = factory.qualityControlFor(
				anItem().withName(SULFURAS_ITEM_NAME).build());
		
		assertThat(qualityControl, is(instanceOf(SulfurasQualityControl.class)));
	}
	
	@Test public void
	shouldReturnAgedBrieQualityControlWhenItemIsAgedBrie() {
		QualityControl qualityControl = factory.qualityControlFor(
				anItem().withName(AGED_BRIE_ITEM_NAME).build());
		
		assertThat(qualityControl, is(instanceOf(AgedBrieQualityControl.class)));
	}
	
	@Test public void
	shouldReturnConjuredQualityControlWhenItemIsConjured() {
		QualityControl qualityControl = factory.qualityControlFor(
				anItem().withName(CONJURED_ITEM_NAME).build());
		
		assertThat(qualityControl, is(instanceOf(ConjuredQualityControl.class)));
	}
	
}
