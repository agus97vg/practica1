package controllers;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import datapackage.Alojamiento;
import datapackage.Anfitrione;
import datapackage.Reserva;
import datapackage.Usuario;




public class AlojamientoController {
	

	private String _unidadPersistencia;
	private EntityManager _em;
	private List <Alojamiento> listaPisos;
	private List <Alojamiento> listaMisAlojamientos;
	public AlojamientoController(String unidadPersistencia) {
		super();

		this._unidadPersistencia = unidadPersistencia;
	}
	
	
	private void proxyCreateEntityManager() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(_unidadPersistencia);

		this._em = factory.createEntityManager();

	}
	

	
	
	
	public List<Alojamiento> Busqueda (Alojamiento busqueda){
		
		try {
			proxyCreateEntityManager();
			Query query = _em.createNamedQuery("Alojamiento.findBusqueda",Alojamiento.class);
			
				query.setParameter("_varCiudad", busqueda.getCiudad());
				query.setParameter("_varFechaInicio", busqueda.getFecha_inicio());
				query.setParameter("_varFechaFin", busqueda.getFecha_fin());
				query.setParameter("_varHuespedes", busqueda.getNumero_huespedes());
				query.setParameter("_varTipo",busqueda.getTipo());
				query.setParameter("_varPrecio", busqueda.getPrecio());
				System.out.println(query.getResultList().size());
				listaPisos = query.getResultList();
		} finally {
			_em.close();
		}
	
		
		
		
		return listaPisos;
		
	}
	
	
public List<Alojamiento> BusquedaMisAlojamientos (String correo){
		
		try {
			proxyCreateEntityManager();
			Query query = _em.createNamedQuery("Alojamiento.findCorreo",Reserva.class);
			
				query.setParameter("_varCorreo", correo);
		
								
				listaMisAlojamientos = query.getResultList();
		} finally {
			_em.close();
		}
	
		return listaMisAlojamientos;
		
}
	
	
	
	
	public void createAlojamiento(Alojamiento alojamiento)  {

		try {
			proxyCreateEntityManager();
			_em.getTransaction().begin();
			_em.persist(alojamiento);
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
		
//		
//		Query query = _em.createNativeQuery("INSERT INTO Alojamiento (NOMBRE, ANFITRIONES_USUARIOS_Correo, Descripcion_breve, Descripcion_larga, Precio, Tipo, Fecha_inicio, Fecha_fin, Numero_camas, Numero_huespedes, Foto, Ciudad) " +
//	            " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
//	        query.setParameter(1, alojamiento.getId().getNombre());
//	        query.setParameter(2, alojamiento.getANFITRIONES_USUARIOS_Correo());
//	        query.setParameter(3, alojamiento.getDescripcion_breve());
//	        query.setParameter(4, alojamiento.getDecripcion_larga());
//	        query.setParameter(5, alojamiento.getPrecio());
//	        query.setParameter(6, alojamiento.getTipo());
//	        query.setParameter(7, alojamiento.getFecha_inicio());
//	        query.setParameter(8, alojamiento.getFecha_fin());
//	        query.setParameter(9, alojamiento.getNumero_camas());
//	        query.setParameter(10, alojamiento.getNumero_huespedes());
//	        query.setParameter(11, alojamiento.getFoto());
//	        query.setParameter(12, alojamiento.getCiudad());
//	        query.executeUpdate();

	}

	public void deleteAlojamiento(Alojamiento alojamiento)  {

		try {
			proxyCreateEntityManager();
			_em.getTransaction().begin();
			alojamiento = _em.merge(alojamiento);
			_em.remove(alojamiento);
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

	public void updateAlojamiento (Alojamiento alojamiento)  {

		try {
			proxyCreateEntityManager();
			_em.getTransaction().begin();
			alojamiento = _em.merge(alojamiento);
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
