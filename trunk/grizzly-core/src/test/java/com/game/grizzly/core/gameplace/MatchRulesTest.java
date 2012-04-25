package com.game.grizzly.core.gameplace;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.game.grizzly.core.gameplace.match.MatchRules;

public class MatchRulesTest {

	@Test
	public void testIsFinish() {
		MatchRules rules = new MatchRules();
		rules.setMaxScore(11);
		
		List<Integer> scores = new ArrayList<Integer>();
		scores.add(11);
		scores.add(0);
		
		Assert.assertTrue("is't false", rules.isFinish(scores));
	}
}
