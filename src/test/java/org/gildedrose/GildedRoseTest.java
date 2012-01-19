package org.gildedrose;
import static org.gildedrose.ItemBuilder.anItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {
	
	private static final int EXPIRED = -1;
	
	@Mock private QualityControlFactory qualityControlFactory;
	@Mock private DefaultQualityControl qualityControl;
	private GildedRose gildedRose;
	
	@Before 
	public void initialise() {
		when(qualityControlFactory.qualityControlFor(Mockito.any(Item.class))).thenReturn(qualityControl);
//		gildedRose = new GildedRose(qualityControlFactory);
		gildedRose = new GildedRose(new QualityControlFactory());
	}
	
	@Test public void
	shouldUpdateItemsQuality() {
		GildedRose gildedRose = new GildedRose(qualityControlFactory);
		Item item1 = anItem().build();
		Item item2 = anItem().build();
		
		gildedRose.updateQualityFor(listContaining(item1, item2));
		
		verifyIfQualityWasUpdatedFor(item1, item2);
	}

	@Test public void 
	shouldLowerTheSellInValue() {
		Item dexterityVest = anItem().withName("+5 Dexterity Vest").withSellIn(10).build();
		
		gildedRose.updateQualityFor(listContaining(dexterityVest));
		
		assertThat(dexterityVest.getSellIn(), is(9));
	}
	
	@Test public void
	shouldLowerTheQualityValue() {
		Item dexterityVest = anItem().withName("+5 Dexterity Vest").withQuality(10).build();
		
		gildedRose.updateQualityFor(listContaining(dexterityVest));
		
		assertThat(dexterityVest.getQuality(), is(9));
	}
	
	@Test public void
	shouldLowerTheQualityValueTwiceAsFastWhenSellByDateHasPassed() {
		Item dexterityVest = anItem()
								.withName("+5 Dexterity Vest")
								.withQuality(10)
								.withSellIn(EXPIRED).build();
		
		gildedRose.updateQualityFor(listContaining(dexterityVest));
		
		assertThat(dexterityVest.getQuality(), is(8));
	}
	
	@Test public void
	shouldNeverLowerTheQualityToANegativeValue() {
		Item dexterityVest = anItem().withName("+5 Dexterity Vest").withQuality(0).build();
		
		gildedRose.updateQualityFor(listContaining(dexterityVest));
		
		assertThat(dexterityVest.getQuality(), is(0));
	}
	
	@Test public void
	shouldIncreaseAgedBrieWheverItGetsOlder() {
		Item agedBrie = anItem().withName("Aged Brie").withQuality(10).build();
		
		gildedRose.updateQualityFor(listContaining(agedBrie));
		
		assertThat(agedBrie.getQuality(), is(11));
	}
	
	@Test public void
	shouldNeverIncreaseTheQualityOfAItemToMoreThanFifty() {
		Item agedBrie = anItem().withName("Aged Brie").withQuality(50).build();
		
		gildedRose.updateQualityFor(listContaining(agedBrie));
		
		assertThat(agedBrie.getQuality(), is(50));
	}
	
	@Test public void
	shouldNeverChangeSellInAndQualityOfSulfuras() {
		Item sulfuras = anItem()
								.withName("Sulfuras, Hand of Ragnaros")
								.withQuality(20)
								.withSellIn(10).build();
		
		gildedRose.updateQualityFor(listContaining(sulfuras));
		
		assertThat(sulfuras.getQuality(), is(20));
		assertThat(sulfuras.getSellIn(), is(10));
	}
	
	@Test public void
	shouldIncreaseQualityByTwoOfBackstageWhenNeedsToBeSoldInTenDays() {
		Item backstage = anItem()
								.withName("Backstage passes to a TAFKAL80ETC concert")
								.withQuality(20)
								.withSellIn(10).build();
		
		gildedRose.updateQualityFor(listContaining(backstage));
		
		assertThat(backstage.getQuality(), is(22));
	}
	
	@Test public void
	shouldIncreaseQualityByThreeOfBackstageWhenNeedsToBeSoldInLessThanSixDays() {
		Item backstage = anItem()
							.withName("Backstage passes to a TAFKAL80ETC concert")
							.withQuality(20)
							.withSellIn(5).build();
		
		gildedRose.updateQualityFor(listContaining(backstage));
		
		assertThat(backstage.getQuality(), is(23));
	}
	
	@Test public void
	shouldIncreaseQualityOfBackstagePassToMaximulOfFifty() {
		Item backstage = anItem()
				.withName("Backstage passes to a TAFKAL80ETC concert")
				.withQuality(49)
				.withSellIn(5).build();
		
		gildedRose.updateQualityFor(listContaining(backstage));
		
		assertThat(backstage.getQuality(), is(50));
	}
	
	@Test public void
	shouldSetQualityToZeroForBackstageAfterConcert() {
		Item backstage = anItem()
				.withName("Backstage passes to a TAFKAL80ETC concert")
				.withQuality(20)
				.withSellIn(0).build();
		
		gildedRose.updateQualityFor(listContaining(backstage));
		
		assertThat(backstage.getQuality(), is(0));
	}
	
	@Test public void
	shouldDecreaseQualityByTwoForAllConjuredItems() {
		Item conjured = anItem()
				.withName("Conjured Mana Cake")
				.withQuality(20)
				.withSellIn(10).build();
		
		gildedRose.updateQualityFor(listContaining(conjured));
		
		assertThat(conjured.getQuality(), is(18));
	}

	private void verifyIfQualityWasUpdatedFor(Item... items) {
		for (Item item : items) {
			verify(qualityControl).updateQualityFor(item);
		}
	}

	private List<Item> listContaining(Item... items) {
		return Arrays.asList(items);
	}	
	
}
