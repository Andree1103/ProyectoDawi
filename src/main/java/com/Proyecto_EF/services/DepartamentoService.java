package com.Proyecto_EF.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_EF.dao.DepartamentoRepository;
import com.Proyecto_EF.entity.Ciudad;
import com.Proyecto_EF.entity.Departamento;

@Service
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository repo;
	public List<Departamento> listarDepartamentos(){
		return repo.findAll();
	}
	public List<Ciudad> listarCiudadPorIdDepartamento(int idDep){
		return repo.findAllByIdDepartamento(idDep);
	}
}
