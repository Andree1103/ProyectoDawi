package com.Proyecto_EF.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class RolEnlacePK implements Serializable{
	private int idrol;
	private int idenlace;
	@Override
	public int hashCode() {
		return Objects.hash(idenlace, idrol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return idenlace == other.idenlace && idrol == other.idrol;
	}
	public int getIdRol() {
		return idrol;
	}
	public void setIdRol(int idRol) {
		this.idrol = idRol;
	}
	public int getIdEnlace() {
		return idenlace;
	}
	public void setIdEnlace(int idenlace) {
		this.idenlace = idenlace;
	}
}
