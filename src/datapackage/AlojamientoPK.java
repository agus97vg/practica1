package datapackage;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ALOJAMIENTOS database table.
 * 
 */
@Embeddable
public class AlojamientoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String nombre;

	@Column(insertable=false, updatable=false)
	private String ANFITRIONES_USUARIOS_Correo;

	public AlojamientoPK() {
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getANFITRIONES_USUARIOS_Correo() {
		return this.ANFITRIONES_USUARIOS_Correo;
	}
	public void setANFITRIONES_USUARIOS_Correo(String ANFITRIONES_USUARIOS_Correo) {
		this.ANFITRIONES_USUARIOS_Correo = ANFITRIONES_USUARIOS_Correo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AlojamientoPK)) {
			return false;
		}
		AlojamientoPK castOther = (AlojamientoPK)other;
		return 
			this.nombre.equals(castOther.nombre)
			&& this.ANFITRIONES_USUARIOS_Correo.equals(castOther.ANFITRIONES_USUARIOS_Correo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nombre.hashCode();
		hash = hash * prime + this.ANFITRIONES_USUARIOS_Correo.hashCode();
		
		return hash;
	}
}