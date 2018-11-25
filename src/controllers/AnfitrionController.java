package controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import datapackage.Anfitrione;
import datapackage.Usuario;

public class AnfitrionController {
	
	private String _unidadPersistencia;
	private EntityManager _em;
	
	public AnfitrionController(String unidadPersistencia) {

		this._unidadPersistencia = unidadPersistencia;
	}
	
	private void proxyCreateEntityManager() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(_unidadPersistencia);

		this._em = factory.createEntityManager();

	}
	
	
	public Anfitrione buscarPorMail (String correo) {
		
		Anfitrione anfitrion=null;
		proxyCreateEntityManager();
		
		try {
			anfitrion=_em.find(Anfitrione.class, correo);
				
			
		}finally {
			
			_em.close();
		}
		
		return anfitrion;
		
	}
	
	
	public void createAnfitrion(Anfitrione anfitrion)  {

		try {
			proxyCreateEntityManager();
			_em.getTransaction().begin();
			_em.persist(anfitrion);
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
