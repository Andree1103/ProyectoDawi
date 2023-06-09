package com.Proyecto_EF.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto_EF.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query("select c from Cliente c where c.apellido like ?1")
	public List<Cliente> listAllAtCliente(String ape);

}
