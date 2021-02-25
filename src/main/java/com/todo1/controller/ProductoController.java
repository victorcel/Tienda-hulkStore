package com.todo1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.todo1.exception.RecordNotFoundException;
import com.todo1.model.Producto;
import com.todo1.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	ProductoService service;

	@GetMapping
	public String index(Model model) {
		List<Producto> listaProductos = service.getAllProductos();
		model.addAttribute("productos", listaProductos);
		return "productos/index";
	}

	@GetMapping(path = { "/save", "/edit/{id}" })
	public String editProductoById(Model model, @PathVariable("id") Optional<Integer> id)
			throws RecordNotFoundException {

		if (id.isPresent()) {
			Producto entity = service.getProductoById(id.get());
			model.addAttribute("producto", entity);
		} else {
			model.addAttribute("producto", new Producto());
		}
		return "productos/edit";
	}

	@PostMapping
	public String save(@Valid Producto producto, BindingResult result) throws RecordNotFoundException {

		if (result.hasErrors()) {
			return "productos/edit";
		}
		service.createOrUpdateProducto(producto);
		return "redirect:/productos";
	}

	@GetMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) throws RecordNotFoundException {
		service.deleteProductoById(id);
		return "redirect:/productos";
	}

}
