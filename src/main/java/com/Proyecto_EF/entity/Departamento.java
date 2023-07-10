package com.Proyecto_EF.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@JsonIgnore
	@OneToMany(mappedBy="departamento")
	private List<Ciudad> listaCiudades;
	@JsonIgnore
	@OneToMany(mappedBy="departamento")
	private List<Usuario> listaUsuarios;
	@JsonIgnore
	@OneToMany(mappedBy="departamento")
	private List<Cliente> listaClientes;
	@JsonIgnore
	@OneToMany(mappedBy="departamento")
	private List<Postulante> listaPostulantes;
	
	
	public List<Postulante> getListaPostulantes() {
		return listaPostulantes;
	}

	public void setListaPostulantes(List<Postulante> listaPostulantes) {
		this.listaPostulantes = listaPostulantes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ciudad> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}


}
