package com.Proyecto_EF.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_distrito")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_ciu")
	private Ciudad ciudad;
	@JsonIgnore
	@OneToMany(mappedBy="distrito")
	private List<Usuario> listaUsuarios;
	@JsonIgnore
	@OneToMany(mappedBy="distrito")
	private List<Cliente> listaClientes;
	@JsonIgnore
	@OneToMany(mappedBy="distrito")
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

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
}
