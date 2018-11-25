package datapackage;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ANFITRIONES database table.
 * 
 */
@Entity
@Table(name="ANFITRIONES")
@NamedQuery(name="Anfitrione.findAll", query="SELECT a FROM Anfitrione a")
public class Anfitrione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String USUARIOS_Correo;

	//bi-directional many-to-one association to Alojamiento
	@OneToMany(mappedBy="anfitrione")
	private List<Alojamiento> alojamientos;

	//uni-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="USUARIOS_Correo",insertable=false, updatable=false)
	private Usuario usuario;

	public Anfitrione() {
	}

	public String getUSUARIOS_Correo() {
		return this.USUARIOS_Correo;
	}

	public void setUSUARIOS_Correo(String USUARIOS_Correo) {
		this.USUARIOS_Correo = USUARIOS_Correo;
	}

	public List<Alojamiento> getAlojamientos() {
		return this.alojamientos;
	}

	public void setAlojamientos(List<Alojamiento> alojamientos) {
		this.alojamientos = alojamientos;
	}

	public Alojamiento addAlojamiento(Alojamiento alojamiento) {
		getAlojamientos().add(alojamiento);
		alojamiento.setAnfitrione(this);

		return alojamiento;
	}

	public Alojamiento removeAlojamiento(Alojamiento alojamiento) {
		getAlojamientos().remove(alojamiento);
		alojamiento.setAnfitrione(null);

		return alojamiento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}