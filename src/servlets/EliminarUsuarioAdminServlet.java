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
 * Servlet implementation class EliminarUsuarioAdminServlet
 */
@WebServlet("/EliminarUsuarioAdminServlet")
public class EliminarUsuarioAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuarioAdminServlet() {
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
		HttpSession miSesion= request.getSession();
		
		
		ArrayList <Usuario> myUser =(ArrayList <Usuario>) miSesion.getAttribute("arrayUsers");
		String miUsuario = request.getParameter("miBotonEliminar");
		int index= Integer.valueOf(miUsuario);
							
		Usuario antiguoUsuario= myUser.get(index); 
		String admin= (String) miSesion.getAttribute("correo");
		if(antiguoUsuario.getCorreo().equals(admin)) {
			
			UsuarioController controlador = new UsuarioController("mydb");
			controlador.deleteUsuario(antiguoUsuario);
			miSesion.invalidate();
			
			response.sendRedirect("index.jsp");	
		}else {
			myUser.remove(index);
			miSesion.setAttribute("arrayUsers", myUser);
			
			UsuarioController controlador = new UsuarioController("mydb");
			controlador.deleteUsuario(antiguoUsuario);
			RequestDispatcher miR = request.getRequestDispatcher("/gestionUsuarios.jsp");
			miR.forward(request, response);
			
		}
		
		
		
	}

}
