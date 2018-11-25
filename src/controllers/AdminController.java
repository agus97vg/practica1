package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import datapackage.Administradores;




/*https://docs.oracle.com/javaee/6/tutorial/doc/bnbrg.html
Listado de Querys a utilizar*/


public class AdminController {

	private String _unidadPersistencia;
	private EntityManager _em;
	//private List<Usuario> _listaUsuarios = null;
	
	public AdminController(String unidadPersistencia) {

		this._unidadPersistencia = unidadPersistencia;
	}
	
	private void proxyCreateEntityManager() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(_unidadPersistencia);

		this._em = factory.createEntityManager();

	}

	
	
	public Administradores buscarPorMail (String correo) {
		
		Administradores admin =null;
		proxyCreateEntityManager();
		
		try {
			admin=_em.find(Administradores.class, correo);
				
			
		}finally {
			
			_em.close();
		}
		
		return admin;
		
	}


	
	
}
