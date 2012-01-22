package org.gildedrose.stories;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.TXT;

import java.util.List;

import org.gildedrose.steps.UpdateItemsQualitySteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class GildedRoseStories extends JUnitStories {

	public GildedRoseStories() {
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats()
								.withFormats(CONSOLE, TXT));
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()).getFile(), asList("**/"
						+ System.getProperty("storyFilter", "*") + ".story"),
				null);
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
      return new InstanceStepsFactory(configuration(), 
    		  new UpdateItemsQualitySteps()).createCandidateSteps();
	}
	
}
