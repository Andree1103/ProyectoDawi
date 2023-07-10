package com.Proyecto_EF.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_EF.dao.RolRepository;
import com.Proyecto_EF.entity.Rol;

@Service
public class RolService {
	@Autowired
	private RolRepository repo;
	
	public List<Rol> listarRoles(){
		return repo.findAll();
	}
}
