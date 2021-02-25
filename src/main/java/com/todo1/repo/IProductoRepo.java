package com.todo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo1.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{

}
