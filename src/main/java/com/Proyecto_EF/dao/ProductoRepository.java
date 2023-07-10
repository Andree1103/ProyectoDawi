package com.Proyecto_EF.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto_EF.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
