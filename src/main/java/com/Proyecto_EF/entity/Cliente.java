package com.Proyecto_EF.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String correo;
	private String  celular;
	private String direccion;
	private int estado;
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Reclamo> listaReclamo;
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Pedido> listaPedido;
	public List<Reclamo> getListaReclamo() {
		return listaReclamo;
	}
	public void setListaReclamo(List<Reclamo> listaReclamo) {
		this.listaReclamo = listaReclamo;
	}
	public List<Pedido> getListaPedido() {
		return listaPedido;
	}
	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nac")
	private Date fechaNac;	
	@ManyToOne
	@JoinColumn(name = "id_dep")
	private Departamento departamento;
	@ManyToOne
	//(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_ciu")
	private Ciudad ciudad;
	@ManyToOne
	//(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_dis")
	private Distrito distrito;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
}
