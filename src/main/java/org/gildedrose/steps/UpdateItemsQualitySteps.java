package org.gildedrose.steps;

import static java.util.Arrays.asList;
import static org.gildedrose.builder.ItemBuilder.anItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.gildedrose.GildedRose;
import org.gildedrose.Item;
import org.gildedrose.QualityControlFactory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class UpdateItemsQualitySteps {

	private Item item;
	private GildedRose gildedRose;
	
	@BeforeStory
	public void beforeStoryDo() {
		gildedRose = new GildedRose(new QualityControlFactory()); 
	}
	
	@Given("an item named <name>, with sell in <sellIn> days and quality <quality>")
	public void givenAnItemWithNameSellInAndQualitySetTo(@Named("name") String name, 
			@Named("sellIn") int sellIn, @Named("quality") int quality) {
		this.item = anItem()
						.withName(name)
						.withSellIn(sellIn)
						.withQuality(quality).build();
	}
	
	@When("the quality of the item is updated after one day")
	public void whenTheQualityOfTheItemIsUpdatedAfterOneDay(){
		gildedRose.updateQualityFor(asList(item));
	}
	
	@Then("sell in should be <newSellIn>")
	public void thenSellInShouldBe(@Named("newSellIn") int newSellIn){
		assertThat(item.getSellIn(), is(newSellIn));
	}
	
	@Then("quality should be <newQuality>")
	public void thenQualityShouldBe(@Named("newQuality") int newQuality){
		assertThat(item.getQuality(), is(newQuality));
	}

}
