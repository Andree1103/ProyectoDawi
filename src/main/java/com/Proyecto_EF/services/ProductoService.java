package com.Proyecto_EF.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_EF.dao.ProductoRepository;
import com.Proyecto_EF.entity.Producto;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository repo;
	public List<Producto> listarProductos(){
		return repo.findAll();
	}
	public void grabar(Producto bean) {
		repo.save(bean);
	}
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	public Producto buscar(Integer id) {
		return repo.findById(id).orElse(null);
	}
}
