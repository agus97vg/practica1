package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.AdminController;
import controllers.UsuarioController;
import datapackage.Administradores;
import datapackage.Usuario;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
	
		System.out.println("Inicio del método post del servlet");
		
		String correo= request.getParameter("loginEmail");
		String contrasenya =request.getParameter("loginPassword");
		//PrintWriter imprimir =response.getWriter();
		
		AdminController _adminController =new AdminController ("mydb");
		Administradores admin =  _adminController.buscarPorMail(correo);
		
		UsuarioController _usuarioController =new UsuarioController("mydb");
		Usuario user =  _usuarioController.buscarPorMail(correo);
		
		PrintWriter out = response.getWriter();
		
		
		
		
		
		
		
		if(user==null) {
			
			
			System.out.println("El usuario no existe");
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('El usuario no existe');");
			out.println("</script>");
			
			response.sendRedirect("index.jsp");
			
				
		}
		
		if(admin!=null) {
			
			
			if(user.getContrasenya().equals(contrasenya)) {
				
				HttpSession miSesion = request.getSession(true);
			
				miSesion.setAttribute("nombre", user.getNombre());
				miSesion.setAttribute("contrasenya", user.getContrasenya());
				miSesion.setAttribute("apellidos", user.getApellidos());
				miSesion.setAttribute("correo", user.getCorreo());
				
				
				System.out.println("El Usuario es administrador y ha iniciado sesion");
				
			
				RequestDispatcher miR = request.getRequestDispatcher("/indexAdmin.jsp");
				miR.forward(request, response);
				
				
			}else if(!user.getContrasenya().equals(contrasenya)) {
				
				System.out.println("Las contraseñas no coinciden");
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Las contraseñas no coinciden');");
				out.println("</script>");
				
				response.sendRedirect("index.jsp");
				
				
			}
			
			
			
			
		}else if(user!=null) {
			
			
			
			if(user.getContrasenya().equals(contrasenya)) {
				
				System.out.println("El Usuario ha iniciado sesion");
				
				
				
				HttpSession miSesion = request.getSession(true);
				miSesion.setAttribute("nombre", user.getNombre());
				miSesion.setAttribute("contrasenya", user.getContrasenya());
				miSesion.setAttribute("apellidos", user.getApellidos());
				miSesion.setAttribute("correo", user.getCorreo());
				
			
				RequestDispatcher miR = request.getRequestDispatcher("/indexSesionIniciada.jsp");
				miR.forward(request, response);
			}else if(!user.getContrasenya().equals(contrasenya)) {
				
				
				System.out.println("Las contraseñas no coinciden");
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Las contraseñas no coinciden');");
				out.println("</script>");
				
				response.sendRedirect("index.jsp");
				
				
			}
			
			
		}
		
		
		
		
		
		
		
		
	}

}
