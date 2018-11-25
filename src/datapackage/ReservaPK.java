package datapackage;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESERVAS database table.
 * 
 */
@Embeddable
public class ReservaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String usuario;

	private String ALOJAMIENTOS_Nombre;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date Fecha_inicio;

	public ReservaPK() {
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getALOJAMIENTOS_Nombre() {
		return this.ALOJAMIENTOS_Nombre;
	}
	public void setALOJAMIENTOS_Nombre(String ALOJAMIENTOS_Nombre) {
		this.ALOJAMIENTOS_Nombre = ALOJAMIENTOS_Nombre;
	}
	public java.util.Date getFecha_inicio() {
		return this.Fecha_inicio;
	}
	public void setFecha_inicio(java.util.Date fecha_inicio) {
		this.Fecha_inicio = fecha_inicio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReservaPK)) {
			return false;
		}
		ReservaPK castOther = (ReservaPK)other;
		return 
			this.usuario.equals(castOther.usuario)
			&& this.ALOJAMIENTOS_Nombre.equals(castOther.ALOJAMIENTOS_Nombre)
			&& this.Fecha_inicio.equals(castOther.Fecha_inicio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuario.hashCode();
		hash = hash * prime + this.ALOJAMIENTOS_Nombre.hashCode();
		hash = hash * prime + this.Fecha_inicio.hashCode();
		
		return hash;
	}
}