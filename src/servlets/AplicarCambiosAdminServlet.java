package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class AplicarCambiosAdminServlet
 */
@WebServlet("/AplicarCambiosAdminServlet")
public class AplicarCambiosAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AplicarCambiosAdminServlet() {
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
		
		String nombre = request.getParameter("name");
		String apellidos = request.getParameter("surname");
		String contrasenya= request.getParameter("pass");
		
		
		HttpSession miSesion= request.getSession();
		
		ArrayList <Usuario> myUser =(ArrayList <Usuario>) miSesion.getAttribute("arrayUsers");
		int index=(int) miSesion.getAttribute("editarUserAdmin");
							
		Usuario antiguoUsuario= myUser.get(index);
		
		antiguoUsuario.setApellidos(apellidos);
		antiguoUsuario.setContrasenya(contrasenya);
		antiguoUsuario.setNombre(nombre);
		
		UsuarioController controlador = new UsuarioController("mydb");
		
		controlador.updateUsuario(antiguoUsuario);
		RequestDispatcher miR = request.getRequestDispatcher("/gestionUsuarios.jsp");
		miR.forward(request, response);
		
	}

}
