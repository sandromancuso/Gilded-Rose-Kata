package org.gildedrose.steps;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GridSteps {

//	private Game game;
//	private StringRenderer renderer;

	@Given("a $width by $height game")
	@Aliases(values = { "a new game: $width by $height" })
	public void theGameIsRunning(int width, int height) {
		System.out.println("GIVEN: the game is running");
		throw new RuntimeException("*********************** BBBBB*");
//		game = new Game(width, height); 
//		renderer = new StringRenderer();
//		game.setObserver(renderer);
	}

	@When("I toggle the cell at ($column, $row)")
	public void iToggleTheCellAt(int column, int row) {
		System.out.println("WHEN: I toggle a cell at");
		throw new RuntimeException("*********************** AAAAAA*");
//		game.toggleCellAt(column, row);
	}

	@Then("the grid should look like $grid")
	@Aliases(values = { "the grid should be $grid" })
	public void theGridShouldLookLike(String grid) {
		System.out.println("THEN: the grid should look like");
//		assertThat(renderer.asString(), equalTo(grid));
	}

}
