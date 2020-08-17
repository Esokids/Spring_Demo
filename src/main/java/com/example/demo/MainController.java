package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "<h1>Hello Index Page</h1>";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	@ResponseBody
	public String about() {
		return "<h1>Page About</h1>";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	@ResponseBody
	public String contact() {
		return "<h1>Page Contact</h1>";
	}
	
	//Path
	@GetMapping("/param/{id}/{name}")
	@ResponseBody
	public String param(@PathVariable int id, @PathVariable String name) {
		return "<h1>Param id = " + id + ", name = " + name + "</h1>";
	}
	
	//Query String
	@RequestMapping(path = "/param2")
	@ResponseBody
	public String param2(
			@RequestParam(defaultValue = "0") int id,
			@RequestParam(defaultValue = "Win", required = false) String name
			) {
		return "<h1>id = " + id + ", name = " + name + "</h1>";
	}
	
	@RequestMapping(path = "/param3")
	@ResponseBody
	public String param3(
			@RequestParam(name = "myId") int id,
			@RequestParam String name
			) {
		return "<h1>id = " + id + ", name = " + name + "</h1>";
	}
}
