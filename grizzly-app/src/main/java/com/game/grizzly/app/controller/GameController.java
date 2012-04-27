package com.game.grizzly.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/game")
@SessionAttributes({ "user" })
public class GameController {

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createGame() {
		
		return "game";
	}
}
