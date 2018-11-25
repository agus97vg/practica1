package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import datapackage.Alojamiento;
import datapackage.AlojamientoPK;
import datapackage.Usuario;
import info.InformacionProperties;


public class AdminSelectionUsersController {

	
	public ArrayList<Usuario> usersJDBC() {

		InitialContext miInitialContext;
		DataSource miDS;
		Statement myStatement = null;
		Connection conexion = null;
		ArrayList<Usuario> arrayUsers = new ArrayList <Usuario>();
		try {

			miInitialContext = new InitialContext();

			miDS = (DataSource) miInitialContext.lookup(InformacionProperties.getStrDataSource());

			conexion = miDS.getConnection();

			myStatement = conexion.createStatement();

			
			String sql = "select * from USUARIOS";

			ResultSet result = myStatement.executeQuery(sql);
			
			
			Usuario user;
			
			while(result.next()) {
				
				user=new Usuario();
				user.setNombre(result.getString("Nombre"));
				user.setApellidos(result.getString("Apellidos"));
				user.setCorreo(result.getString("Correo"));
				user.setContrasenya(result.getString("Contrasenya"));
				arrayUsers.add(user);
			}


		} catch (NamingException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();

		} catch (SQLWarning sqlWarning) {
			while (sqlWarning != null) {
				System.out.println("Error: " + sqlWarning.getErrorCode());
				System.out.println("Descripcion: " + sqlWarning.getMessage());
				System.out.println("SQLstate: " + sqlWarning.getSQLState());
				sqlWarning = sqlWarning.getNextWarning();
			}
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());
				sqlException = sqlException.getNextException();
			}
		} finally{
			

			try {
				myStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return arrayUsers;
	}
	
	
	
	public ArrayList<Alojamiento> alojamientoJDBC() {

		InitialContext miInitialContext;
		DataSource miDS;
		Statement myStatement = null;
		Connection conexion = null;
		ArrayList<Alojamiento> arrayAlojamiento = new ArrayList <Alojamiento>();
		try {

			miInitialContext = new InitialContext();

			miDS = (DataSource) miInitialContext.lookup(InformacionProperties.getStrDataSource());

			conexion = miDS.getConnection();

			myStatement = conexion.createStatement();

			
			String sql = "select * from ALOJAMIENTOS";

			ResultSet result = myStatement.executeQuery(sql);
			
			
			Alojamiento aloja;
			AlojamientoPK primaryKey;
			
			while(result.next()) {
				
				aloja=new Alojamiento();
				primaryKey= new AlojamientoPK();
				primaryKey.setNombre(result.getString("Nombre"));
			    primaryKey.setANFITRIONES_USUARIOS_Correo(result.getString("ANFITRIONES_USUARIOS_Correo"));
			    
			    
			    
			    
			    aloja.setId(primaryKey);
			    aloja.setCiudad(result.getString("Ciudad"));
			    aloja.setDescripcion_breve(result.getString("Descripcion_breve"));
			    aloja.setDecripcion_larga(result.getString("Decripcion_larga"));
			    aloja.setTipo(result.getString("Tipo"));
			    aloja.setNumero_camas(result.getInt("Numero_camas"));
			    aloja.setNumero_huespedes(result.getInt("Numero_huespedes"));
			    aloja.setFecha_inicio(result.getDate("Fecha_inicio"));
			    aloja.setFecha_fin(result.getDate("Fecha_fin"));
			    aloja.setPrecio(result.getInt("Precio"));
			    aloja.setFoto(result.getBytes("Foto"));
				arrayAlojamiento.add(aloja);
			}


		} catch (NamingException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();

		} catch (SQLWarning sqlWarning) {
			while (sqlWarning != null) {
				System.out.println("Error: " + sqlWarning.getErrorCode());
				System.out.println("Descripci�n: " + sqlWarning.getMessage());
				System.out.println("SQLstate: " + sqlWarning.getSQLState());
				sqlWarning = sqlWarning.getNextWarning();
			}
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripci�n: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());
				sqlException = sqlException.getNextException();
			}
		} finally{
			

			try {
				myStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return arrayAlojamiento;
	}
}
