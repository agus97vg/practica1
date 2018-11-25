package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.UsuarioController;
import datapackage.Usuario;

/**
 * Servlet implementation class EliminarCuentaServlet
 */
@WebServlet("/EliminarCuentaServlet")
public class EliminarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Usuario user = new Usuario ();
		user.setNombre((String)request.getSession().getAttribute("nombre"));
		user.setApellidos((String) request.getSession().getAttribute("apellidos"));
		user.setCorreo((String) request.getSession().getAttribute("correo"));
		user.setContrasenya((String) request.getSession().getAttribute("contrasenya"));
		
		HttpSession miSesion = request.getSession();
		miSesion .setAttribute("nombre", "");
		miSesion.setAttribute("contrasenya","");
		miSesion.setAttribute("apellidos", "");
		miSesion.setAttribute("correo", "");
		miSesion.invalidate();
		
		
		UsuarioController usuario= new UsuarioController("mydb");
		
		usuario.deleteUsuario(user);
		
		response.sendRedirect("index.jsp");

	
	}


	

}
