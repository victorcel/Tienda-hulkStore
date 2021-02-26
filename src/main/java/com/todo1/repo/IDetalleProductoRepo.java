package com.todo1.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.todo1.model.DetalleProducto;

public interface IDetalleProductoRepo extends JpaRepository<DetalleProducto, Integer>{

	List<DetalleProducto> findAllByProductoId(Integer id);
	
	@Query("SELECT d FROM detalle_producto d WHERE producto_id = :id ORDER BY id DESC limit 1")
	List<DetalleProducto> fila(@Param("id") String id);
}