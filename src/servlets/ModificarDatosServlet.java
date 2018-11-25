package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.UsuarioController;
import datapackage.Usuario;

/**
 * Servlet implementation class ModificarDatosServlet
 */
@WebServlet("/ModificarDatosServlet")
public class ModificarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession miSesion = request.getSession();
		String nombre= request.getParameter("name");
		String primerApellido= request.getParameter("surname");
		String contrasenya= request.getParameter("pass");
		String correo= (String) miSesion.getAttribute("correo");
		
		System.out.println(nombre+" "+primerApellido+" "+correo+" "+contrasenya);
		Usuario user = new Usuario ();
		user.setNombre(nombre);
		user.setApellidos(primerApellido);
		user.setContrasenya(contrasenya);
		user.setCorreo(correo);
		
		
		miSesion.setAttribute("nombre", user.getNombre());
		miSesion.setAttribute("contrasenya", user.getContrasenya());
		miSesion.setAttribute("apellidos", user.getApellidos());
		miSesion.setAttribute("correo", user.getCorreo());
		
		UsuarioController usuario= new UsuarioController("mydb");
		
		
		usuario.updateUsuario(user);
		
		RequestDispatcher miR = request.getRequestDispatcher("/indexSesionIniciada.jsp");
		miR.forward(request, response);

	
	}

}
