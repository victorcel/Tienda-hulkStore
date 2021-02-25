package com.todo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo1.repo.IProductoRepo;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoRepo repo;
	
	@GetMapping
	public String producto(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", repo.count());
		return "producto";
	}
}
