package com.game.grizzly.core.gameplace;

import org.junit.Before;
import org.junit.Test;

import com.game.grizzly.core.skills.AbstractSkillFactory;
import com.game.grizzly.core.skills.SkillFactory;
import com.game.grizzly.core.skills.SkillGroupType;

public class MatchTest {
	
	@Before
	public void init() {
		Match match = new Match();
		Player player = new Player();
		for (SkillGroupType skillType : SkillGroupType.values()) {
			AbstractSkillFactory skillFactory = SkillFactory.getSkillFactory(skillType);
		}
		
	}
	
	@Test
	public void initGame() {
		System.out.println("test");
	}
}
