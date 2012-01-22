package org.gildedrose.qualitycontrol;

import static org.gildedrose.builder.ItemBuilder.anItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.gildedrose.Item;
import org.gildedrose.qualitycontrol.SulfurasQualityControl;
import org.junit.Test;

public class SulfurasQualityControlTest {
	
	private SulfurasQualityControl sulfurasQualityControl = new SulfurasQualityControl();

	@Test public void
	shouldNeverChangeQuality() {
		Item sulfuras = anItem()
								.withName("Sulfuras, Hand of Ragnaros")
								.withQuality(20)
								.withSellIn(10).build();
		
		sulfurasQualityControl.updateQualityFor(sulfuras);
		
		assertThat(sulfuras.getQuality(), is(20));
	}


}
