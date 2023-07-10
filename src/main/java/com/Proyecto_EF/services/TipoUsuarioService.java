package com.Proyecto_EF.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_EF.dao.TipoUsuarioRepository;
import com.Proyecto_EF.entity.TipoUsuario;

@Service
public class TipoUsuarioService {
	@Autowired
	private TipoUsuarioRepository repo;
	public List<TipoUsuario> listarTipoUsuario(){
		return repo.findAll();
	}
}	
