package com.game.grizzly.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.game.grizzly.app.bean.User;
import com.game.grizzly.app.ds.service.UserService;

@Controller
@SessionAttributes({ "user" })
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String cerate() {
		return "/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@RequestParam String name, Model model) {
		User user = new User();
		user.setName(name);
		userService.createUser(user);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String name, ModelMap modelMap) {
		User user = userService.getUser(name);
		modelMap.addAttribute(user);
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String game() {

		return "game";
	}
}
