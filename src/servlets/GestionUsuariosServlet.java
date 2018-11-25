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

import datapackage.Usuario;
import jdbc.AdminSelectionUsersController;

/**
 * Servlet implementation class GestionUsuariosServlet
 */
@WebServlet("/GestionUsuariosServlet")
public class GestionUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsuariosServlet() {
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
		ArrayList <Usuario> allUsers = new ArrayList <Usuario>();
		AdminSelectionUsersController jdbc = new AdminSelectionUsersController();
		
		allUsers=jdbc.usersJDBC();
		System.out.println("El numero de usuarios registrados en la base de datos es de "+allUsers.size());
		
				
		HttpSession mySesion =request.getSession();
		
		mySesion.setAttribute("arrayUsers", allUsers);
		
		RequestDispatcher miR = request.getRequestDispatcher("/gestionUsuarios.jsp");
		miR.forward(request, response);
		
		
		
	}

}
