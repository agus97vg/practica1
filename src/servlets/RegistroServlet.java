package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UsuarioController;
import datapackage.Usuario;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nombre= request.getParameter("name");
		String primerApellido= request.getParameter("surname");
		String correo= request.getParameter("mail");
		String contrasenya= request.getParameter("pass");
	

		//PrintWriter out = response.getWriter();
		
		System.out.println(nombre);
		System.out.println(primerApellido);
		System.out.println(correo);
		
		Usuario user = new Usuario ();
		user.setNombre(nombre);
		user.setApellidos(primerApellido);
		user.setCorreo(correo);
		user.setContrasenya(contrasenya);
		
		
		UsuarioController usuario= new UsuarioController("mydb");
		
		Usuario usuarioBuscado= usuario.buscarPorMail(correo);
		
		
		
		if(usuarioBuscado==null){
			usuario.createUsuario(user);	
			response.sendRedirect("index.jsp");	
			
			//Examinar el request dispatcher
			
		}else {
			System.out.println("El nombre del usuario encontrado es "+ usuarioBuscado.getNombre());
			System.out.println("El usuario ya existe, inicie sesion");
			//Examinar el request dispatcher
			
			

			response.sendRedirect("index.jsp");
			
		}
		
	}

	

}
