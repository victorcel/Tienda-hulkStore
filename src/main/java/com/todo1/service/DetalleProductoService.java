package com.todo1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo1.model.DetalleProducto;
import com.todo1.repo.IDetalleProductoRepo;

@Service
public class DetalleProductoService {

	@Autowired
	private IDetalleProductoRepo repository;

	public List<DetalleProducto> getDetalleProductoById(Integer id) {
		List<DetalleProducto> detalleProducto = repository.findAllByProductoId(id);
		if (detalleProducto.size() > 0) {
			return detalleProducto;
		} else {
			return new ArrayList<DetalleProducto>();
		}
	}

	public DetalleProducto createOrUpdateDetalleProducto(DetalleProducto entity) {
		if (entity.getId() == 0) {
			entity = repository.save(entity);

			return entity;
		} else {
			Optional<DetalleProducto> detalleProducto = repository.findById(entity.getId());

			if (detalleProducto.isPresent()) {
				DetalleProducto newDetalleProducto = detalleProducto.get();
				newDetalleProducto.setProductoId(entity.getId());
				newDetalleProducto.setFecha(entity.getFecha());
				newDetalleProducto.setDescripcion(entity.getDescripcion());
				newDetalleProducto.setVlr_unitario(entity.getVlr_unitario());
				newDetalleProducto.setEn_cantidad(entity.getEn_cantidad());
				newDetalleProducto.setEn_valor(entity.getEn_valor());
				newDetalleProducto.setSa_cantidad(entity.getSa_cantidad());
				newDetalleProducto.setSa_valor(entity.getSa_valor());
				newDetalleProducto.setSaldo_cantidad(entity.getSaldo_cantidad());
				newDetalleProducto.setSaldo_valor(entity.getSa_valor());
				newDetalleProducto = repository.save(newDetalleProducto);

				return newDetalleProducto;
			} else {
				entity = repository.save(entity);

				return entity;
			}
		}
	}
	
	public List<DetalleProducto> ultimaFila(Integer id) {
		
		List<DetalleProducto> detalleProducto = repository.fila(id.toString());
		
		return detalleProducto;
		
	}

}
