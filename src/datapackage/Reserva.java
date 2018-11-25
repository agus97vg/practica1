package datapackage;

import java.io.Serializable;
import javax.persistence.*;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import java.util.Date;


/**
 * The persistent class for the RESERVAS database table.
 * 
 */
@Entity
@Table(name="RESERVAS")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
@NamedQuery(name="Reserva.findCorreo", query="SELECT r FROM Reserva r WHERE r.id.usuario like (:_varCorreo)")
@NamedQuery(name="Reserva.findAlojamiento", query="SELECT r FROM Reserva r WHERE "
		+ "r.id.ALOJAMIENTOS_Nombre like (:_varNombreAloj) AND ((r.id.Fecha_inicio <= (:_varFechaFin) AND r.Fecha_fin >= (:_varFechaFin)) OR (r.id.Fecha_inicio <= (:_varFechaInicio) AND r.Fecha_fin >= (:_varFechaInicio)))")

public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservaPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date Fecha_fin;

	private String ALOJAMIENTOS_anfitrion;

	public String getALOJAMIENTOS_anfitrion() {
		return ALOJAMIENTOS_anfitrion;
	}

	public void setALOJAMIENTOS_anfitrion(String aLOJAMIENTOS_anfitrion) {
		ALOJAMIENTOS_anfitrion = aLOJAMIENTOS_anfitrion;
	}

	//uni-directional many-to-one association to Alojamiento
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ALOJAMIENTOS_Anfitrion", referencedColumnName="ANFITRIONES_USUARIOS_Correo",insertable=false, updatable=false),
		@JoinColumn(name="ALOJAMIENTOS_Nombre", referencedColumnName="Nombre", insertable=false, updatable=false)
		})
	private Alojamiento alojamiento;

	public Reserva() {
	}

	public ReservaPK getId() {
		return this.id;
	}

	public void setId(ReservaPK id) {
		this.id = id;
	}

	public Date getFecha_fin() {
		return this.Fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.Fecha_fin = fecha_fin;
	}



	public Alojamiento getAlojamiento() {
		return this.alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

}