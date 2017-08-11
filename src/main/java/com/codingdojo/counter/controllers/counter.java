package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counter {

	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer counter = (Integer) session.getAttribute("counter");
		if(counter == null) {
			counter = 1;
		}
		else {
			counter ++;
		}
		session.setAttribute("counter", counter);
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		Integer counter = (Integer) session.getAttribute("counter");
		model.addAttribute("counter", counter);
		return "count.jsp";
	}
}
