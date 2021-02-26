package com.todo1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.todo1.exception.RecordNotFoundException;
import com.todo1.model.DetalleProducto;
import com.todo1.model.Producto;
import com.todo1.service.DetalleProductoService;
import com.todo1.service.ProductoService;

@Controller
@RequestMapping("/detalleProductos")
public class DetalleProductoControlller {

	@Autowired
	DetalleProductoService service;

	@Autowired
	ProductoService productoService;

	int producto_id = 0;

	@GetMapping
	public String index(Model model) {

		return "detalleProductos/index";
	}

	@GetMapping(path = { "/{id}" })
	public String detalleById(Model model, @PathVariable("id") Optional<Integer> id) throws RecordNotFoundException {

		if (id.isPresent()) {
			List<DetalleProducto> entity = service.getDetalleProductoById(id.get());
			Producto producto = productoService.getProductoById(id.get());
			if (producto.getId() == 0) {
				return "redirect:/productos";
			} else {

				model.addAttribute("producto", producto);
				model.addAttribute("detallesproductos", entity);
			}

		}
		return "detalleProductos/index";
	}

	@GetMapping(path = { "insertar/{id}" })
	public String insertarDetalleById(Model model, @PathVariable("id") Optional<Integer> id)
			throws RecordNotFoundException {

		model.addAttribute("detalleProducto", new DetalleProducto());
		producto_id = id.get();
		return "detalleProductos/form";
	}

	@PostMapping
	public String save(@Valid DetalleProducto detalleProducto, BindingResult result) throws RecordNotFoundException {
		if (result.hasErrors()) {
			return "detalleProductos/form";
		}
		if (detalleProducto.getMovimiento() ==1) {
			int entrada_cant = detalleProducto.getSaldo_cantidad();
			int entrada_valor = detalleProducto.getSaldo_valor();
			int vlr_unitario = entrada_valor / entrada_cant;

			detalleProducto.setVlr_unitario(vlr_unitario);
			detalleProducto.setEn_cantidad(entrada_cant);
			detalleProducto.setEn_valor(entrada_valor);
			detalleProducto.setSaldo_cantidad(entrada_cant);
			detalleProducto.setSaldo_valor(entrada_valor);
		}
		detalleProducto.setProductoId(producto_id);
		//service.createOrUpdateDetalleProducto(detalleProducto);
		return "redirect:/productos";
	}

}
