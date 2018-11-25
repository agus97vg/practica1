package datapackage;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ALOJAMIENTOS database table.
 * 
 */
@Entity
@Table(name="ALOJAMIENTOS")
@NamedQuery(name="Alojamiento.findAll", query="SELECT a FROM Alojamiento a")
@NamedQuery(name="Alojamiento.findBusqueda", query="SELECT a FROM Alojamiento a WHERE a.ciudad = (:_varCiudad) AND "
		+ "(a.fecha_inicio < (:_varFechaInicio) OR a.fecha_inicio = (:_varFechaInicio)) AND (a.fecha_fin> (:_varFechaFin) OR a.fecha_fin= (:_varFechaFin)) AND (a.numero_huespedes > (:_varHuespedes) OR a.numero_huespedes = (:_varHuespedes)) AND a.tipo =(:_varTipo) "
		+ "AND (a.precio < (:_varPrecio) OR a.precio = (:_varPrecio))")
@NamedQuery(name="Alojamiento.findCorreo", query="SELECT a FROM Alojamiento a WHERE a.id.ANFITRIONES_USUARIOS_Correo like (:_varCorreo)")
public class Alojamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlojamientoPK id;

	
	private String ANFITRIONES_USUARIOS_Correo;
	
	

	private String ciudad;

	private String decripcion_larga;

	private String descripcion_breve;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_fin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_inicio;

	@Column(nullable = false, name = "Foto", columnDefinition="BINARY(500000)")
	private byte [] foto;

	private int numero_camas;

	private int numero_huespedes;

	private int precio;

	private String tipo;

	//bi-directional many-to-one association to Anfitrione
	@ManyToOne
	@JoinColumn(name="ANFITRIONES_USUARIOS_Correo", insertable=false, updatable=false)
	private Anfitrione anfitrione;

	public Alojamiento() {
	}

	public AlojamientoPK getId() {
		return this.id;
	}

	public void setId(AlojamientoPK id) {
		this.id = id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDecripcion_larga() {
		return this.decripcion_larga;
	}

	public void setDecripcion_larga(String decripcion_larga) {
		this.decripcion_larga = decripcion_larga;
	}

	

	public Date getFecha_fin() {
		return this.fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_inicio() {
		return this.fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public byte [] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] data) {
		this.foto = data;
	}

	

	public String getDescripcion_breve() {
		return descripcion_breve;
	}

	public void setDescripcion_breve(String descripcion_breve) {
		this.descripcion_breve = descripcion_breve;
	}

	public int getNumero_camas() {
		return numero_camas;
	}

	public void setNumero_camas(int numero_camas) {
		this.numero_camas = numero_camas;
	}

	public int getNumero_huespedes() {
		return numero_huespedes;
	}

	public void setNumero_huespedes(int numero_huespedes) {
		this.numero_huespedes = numero_huespedes;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Anfitrione getAnfitrione() {
		return this.anfitrione;
	}

	public void setAnfitrione(Anfitrione anfitrione) {
		this.anfitrione = anfitrione;
	}

	


	public String getANFITRIONES_USUARIOS_Correo() {
		return ANFITRIONES_USUARIOS_Correo;
	}

	public void setANFITRIONES_USUARIOS_Correo(String aNFITRIONES_USUARIOS_Correo) {
		ANFITRIONES_USUARIOS_Correo = aNFITRIONES_USUARIOS_Correo;
	}
}