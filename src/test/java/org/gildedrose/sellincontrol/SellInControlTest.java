package org.gildedrose.sellincontrol;

import static org.gildedrose.builder.ItemBuilder.anItem;
import static org.gildedrose.qualitycontrol.QualityControlFactory.SULFURAS_ITEM_NAME;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.gildedrose.Item;
import org.gildedrose.sellincontrol.SellInControl;
import org.junit.Before;
import org.junit.Test;

public class SellInControlTest {
	
	private SellInControl sellInControl;

	@Before 
	public void initialise() {
		sellInControl = new SellInControl();
	}
	
	@Test public void
	shouldDecreaseSellInInOne() {
		Item item = anItem().withName("Ordinary item").withSellIn(10).build();
		
		sellInControl.updateSellInFor(item);
		
		assertThat(item.getSellIn(), is(9));
	}

	@Test public void
	shouldNotDecreaseSellInForSulfuras() {
		Item item = anItem().withName(SULFURAS_ITEM_NAME).withSellIn(10).build();
		
		sellInControl.updateSellInFor(item);
		
		assertThat(item.getSellIn(), is(10));
	}
	
}
