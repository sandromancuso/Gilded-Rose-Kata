package org.gildedrose;
import static org.gildedrose.ItemBuilder.anItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class GildedRoseTest {
	
	private static final int EXPIRED = -1;
	private List<Item> items;
	
	@Before 
	public void initialise() {
		this.items = new ArrayList<Item>();
	}

	@Test public void 
	shouldLowerTheSellInValue() {
		Item dexterityVest = anItem().withName("+5 Dexterity Vest").withSellIn(10).build();
		items.add(dexterityVest);
		
		GildedRose.updateQuality(items);
		
		assertThat(dexterityVest.getSellIn(), is(9));
	}
	
	@Test public void
	shouldLowerTheQualityValue() {
		Item dexterityVest = anItem().withName("+5 Dexterity Vest").withQualily(10).build();
		items.add(dexterityVest);
		
		GildedRose.updateQuality(items);
		
		assertThat(dexterityVest.getQuality(), is(9));
	}
	
	
	@Test public void
	shouldLowerTheQualityValueTwiceAsFastWhenSellByDateHasPassed() {
		Item dexterityVest = anItem()
								.withName("+5 Dexterity Vest")
								.withQualily(10)
								.withSellIn(EXPIRED).build();
		items.add(dexterityVest);
		
		GildedRose.updateQuality(items);
		
		assertThat(dexterityVest.getQuality(), is(8));
	}
	
	@Test public void
	shouldNeverLowerTheQualityToANegativeValue() {
		Item dexterityVest = anItem().withName("+5 Dexterity Vest").withQualily(0).build();
		items.add(dexterityVest);
		
		GildedRose.updateQuality(items);
		
		assertThat(dexterityVest.getQuality(), is(0));
	}
	
	@Test public void
	shouldIncreaseAgedBrieWheverItGetsOlder() {
		Item agedBrie = anItem().withName("Aged Brie").withQualily(10).build();
		items.add(agedBrie);
		
		GildedRose.updateQuality(items);
		
		assertThat(agedBrie.getQuality(), is(11));
	}
	
	@Test public void
	shouldNeverIncreaseTheQualityOfAItemToMoreThanFifty() {
		Item agedBrie = anItem().withName("Aged Brie").withQualily(50).build();
		items.add(agedBrie);
		
		GildedRose.updateQuality(items);
		
		assertThat(agedBrie.getQuality(), is(50));
	}
	
	@Test public void
	shouldNeverChangeSellInAndQualityOfSulfuras() {
		Item sulfuras = anItem()
								.withName("Sulfuras, Hand of Ragnaros")
								.withQualily(20)
								.withSellIn(10).build();
		items.add(sulfuras);
		
		GildedRose.updateQuality(items);
		
		assertThat(sulfuras.getQuality(), is(20));
		assertThat(sulfuras.getSellIn(), is(10));
	}
	
	@Test public void
	shouldIncreaseQualityByTwoOfBackstageWhenNeedsToBeSoldInTenDays() {
		Item backstage = anItem()
								.withName("Backstage passes to a TAFKAL80ETC concert")
								.withQualily(20)
								.withSellIn(10).build();
		items.add(backstage);
		
		GildedRose.updateQuality(items);
		
		assertThat(backstage.getQuality(), is(22));
	}
	
	@Test public void
	shouldIncreaseQualityByThreeOfBackstageWhenNeedsToBeSoldInLessThanSixDays() {
		Item backstage = anItem()
							.withName("Backstage passes to a TAFKAL80ETC concert")
							.withQualily(20)
							.withSellIn(5).build();
		items.add(backstage);
		
		GildedRose.updateQuality(items);
		
		assertThat(backstage.getQuality(), is(23));
	}
	
	@Test public void
	shouldSetQualityToZeroForBackstageAfterConcert() {
		Item backstage = anItem()
				.withName("Backstage passes to a TAFKAL80ETC concert")
				.withQualily(20)
				.withSellIn(0).build();
		items.add(backstage);
		
		GildedRose.updateQuality(items);
		
		assertThat(backstage.getQuality(), is(0));
	}
	
	@Ignore
	@Test public void
	shouldDecreaseQualityByTwoForAllConjuredItems() {
		Item conjured = anItem()
				.withName("Conjured Mana Cake")
				.withQualily(20)
				.withSellIn(10).build();
		items.add(conjured);
		
		GildedRose.updateQuality(items);
		
		assertThat(conjured.getQuality(), is(18));
	}
	
}
