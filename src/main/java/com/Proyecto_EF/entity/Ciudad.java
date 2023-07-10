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
@Table(name="tb_ciudad")
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "id_dep")
	private Departamento departamento;
	@JsonIgnore
	@OneToMany(mappedBy="ciudad")
	private List<Usuario> listaUsuarios;
	@JsonIgnore
	@OneToMany(mappedBy="ciudad")
	private List<Distrito> listaDistritos;
	@JsonIgnore
	@OneToMany(mappedBy="ciudad")
	private List<Cliente> listaClientes;
	@JsonIgnore
	@OneToMany(mappedBy="ciudad")
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

}
