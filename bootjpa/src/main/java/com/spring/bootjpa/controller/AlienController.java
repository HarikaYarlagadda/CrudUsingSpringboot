package com.spring.bootjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bootjpa.dao.AlienRepo;
import com.spring.bootjpa.model.Alien;

@Controller
public class AlienController
{
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int id)
	{
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		Alien alien=repo.findById(id).orElse(new Alien());
		mv.addObject(alien);
		return mv;
 }
}