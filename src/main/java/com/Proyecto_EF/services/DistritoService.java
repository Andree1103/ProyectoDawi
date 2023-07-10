package com.Proyecto_EF.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_EF.dao.DistritoRepository;
import com.Proyecto_EF.entity.Distrito;

@Service
public class DistritoService {
	@Autowired
	private DistritoRepository repo;
	public List<Distrito> listarDistritos(){
		return repo.findAll();
	}
}
