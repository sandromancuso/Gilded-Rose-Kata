package org.gildedrose;

import static org.gildedrose.ItemBuilder.anItem;
import static org.gildedrose.QualityControlFactory.BACKSTAGE_PASS_ITEM_NAME;
import static org.gildedrose.QualityControlFactory.SULFURAS_HAND_OF_RAGNAROS;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
				anItem().withName(SULFURAS_HAND_OF_RAGNAROS).build());
		
		assertThat(qualityControl, is(instanceOf(SulfurasQualityControl.class)));
	}
	
}
