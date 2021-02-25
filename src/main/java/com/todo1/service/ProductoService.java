package com.todo1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.exception.RecordNotFoundException;
import com.todo1.model.Producto;
import com.todo1.repo.IProductoRepo;

@Service
public class ProductoService {

	@Autowired
	private IProductoRepo repository;

	public List<Producto> getAllProductos() {
		List<Producto> result = (List<Producto>) repository.findAll();

		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Producto>();
		}
	}
	
    public Producto getProductoById(Integer id) throws RecordNotFoundException 
    {
        Optional<Producto> producto = repository.findById(id);
         
        if(producto.isPresent()) {
            return producto.get();
        } else {
            throw new RecordNotFoundException("No existe ID producto");
        }
    }
    
    public Producto createOrUpdateProducto(Producto entity) 
    {
        if(entity.getId() == 0) 
        {
            entity = repository.save(entity);
             
            return entity;
        } 
        else
        {
            Optional<Producto> producto = repository.findById(entity.getId());
             
            if(producto.isPresent()) 
            {
            	Producto newProducto = producto.get();
            	newProducto.setArticulo(entity.getArticulo());
            	newProducto.setLocalizacion(entity.getLocalizacion());
            	newProducto.setReferencia(entity.getReferencia());
            	newProducto.setProveedor(entity.getProveedor());
            	newProducto.setUnidad(entity.getUnidad());
            	newProducto.setMin(entity.getMin());
            	newProducto.setMax(entity.getMax());
 
            	newProducto = repository.save(newProducto);
                 
                return newProducto;
            } else {
                entity = repository.save(entity);
                 
                return entity;
            }
        }
    } 

    public void deleteProductoById(Integer id) throws RecordNotFoundException 
    {
        Optional<Producto> producto = repository.findById(id);
         
        if(producto.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No existe ID producto");
        }
    } 
}
