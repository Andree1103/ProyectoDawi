package com.Proyecto_EF.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto_EF.entity.Ciudad;
import com.Proyecto_EF.entity.Distrito;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
	@Query("select tp from Distrito tp where tp.ciudad.id=?1")
	public List<Distrito> findAllByIdCiudad(int idCiu);
	
}
