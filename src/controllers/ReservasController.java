package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import datapackage.Alojamiento;
import datapackage.Reserva;
import datapackage.Usuario;

public class ReservasController {

	private String _unidadPersistencia;
	private EntityManager _em;
	private List <Reserva> listaReservas;

	public ReservasController(String unidadPersistencia) {
		super();

		this._unidadPersistencia = unidadPersistencia;
	}
	
	
	private void proxyCreateEntityManager() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(_unidadPersistencia);

		this._em = factory.createEntityManager();

	}
	
public List<Reserva> Busqueda (String correo){
		
		try {
			proxyCreateEntityManager();
			Query query = _em.createNamedQuery("Reserva.findCorreo",Reserva.class);
			
				query.setParameter("_varCorreo", correo);
		
								
				listaReservas = query.getResultList();
		} finally {
			_em.close();
		}
	
		return listaReservas;
		
	}


public List<Reserva> ocupado (Reserva realizacion){
	
	try {
		proxyCreateEntityManager();
		Query query = _em.createNamedQuery("Reserva.findAlojamiento",Reserva.class);
		
			query.setParameter("_varNombreAloj", realizacion.getId().getALOJAMIENTOS_Nombre());
			query.setParameter("_varFechaInicio",realizacion.getId().getFecha_inicio());
			query.setParameter("_varFechaFin", realizacion.getFecha_fin());
							
			listaReservas = query.getResultList();
	} finally {
		_em.close();
	}

	return listaReservas;
	
}


public void createReserva(Reserva reserva)  {

	try {
		proxyCreateEntityManager();
		_em.getTransaction().begin();
		_em.persist(reserva);
		_em.getTransaction().commit();
	} catch (Exception ex) {
		try {
			if (_em.getTransaction().isActive()) {
				_em.getTransaction().rollback();
			}
		} catch (Exception e) {
			ex.printStackTrace();
		}

	} finally {
		_em.close();
	}

}

public void deleteReserva(Reserva reserva)  {

	try {
		proxyCreateEntityManager();
		_em.getTransaction().begin();
		reserva = _em.merge(reserva);
		_em.remove(reserva);
		_em.getTransaction().commit();
	} catch (Exception ex) {
		try {
			if (_em.getTransaction().isActive()) {
				_em.getTransaction().rollback();
			}
		} catch (Exception e) {
			ex.printStackTrace();
		}

	} finally {
		_em.close();
	}

}
}
