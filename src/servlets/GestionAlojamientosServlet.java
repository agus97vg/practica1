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

import datapackage.Alojamiento;
import datapackage.Usuario;
import jdbc.AdminSelectionUsersController;

/**
 * Servlet implementation class GestionAlojamientosServlet
 */
@WebServlet("/GestionAlojamientosServlet")
public class GestionAlojamientosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAlojamientosServlet() {
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
		// TODO Auto-generated method stub
				ArrayList <Alojamiento> allAlojamiento = new ArrayList <Alojamiento>();
				AdminSelectionUsersController jdbc = new AdminSelectionUsersController();
				
				allAlojamiento=jdbc.alojamientoJDBC();
				System.out.println("El numero de alojamientos registrados en la base de datos es de "+allAlojamiento.size());
				
				
//				for(int i=0; i<allUsers.size();i++) {
//					System.out.println(allUsers.get(i).getNombre());			
//				}

				
				HttpSession mySesion =request.getSession();
				mySesion.setAttribute("arrayAlojamientos", allAlojamiento);
				
				RequestDispatcher miR = request.getRequestDispatcher("/gestionAlojamientos.jsp");
				miR.forward(request, response);
				
	}

}
