package datapackage;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMINISTRADORES database table.
 * 
 */
@Entity
@NamedQuery(name="Administradores.findAll", query="SELECT a FROM Administradores a")
public class Administradores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String USUARIOS_Correo;

	//uni-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="USUARIOS_Correo",insertable=false, updatable=false)
	private Usuario usuario;

	public Administradores() {
	}

	public String getUSUARIOS_Correo() {
		return this.USUARIOS_Correo;
	}

	public void setUSUARIOS_Correo(String USUARIOS_Correo) {
		this.USUARIOS_Correo = USUARIOS_Correo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}