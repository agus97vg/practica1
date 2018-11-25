package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BotonModificarAlojamientoAdminServlet
 */
@WebServlet("/BotonModificarAlojamientoAdminServlet")
public class BotonModificarAlojamientoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BotonModificarAlojamientoAdminServlet() {
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
		// TODO Auto-generated method stub
		String miAloja = request.getParameter("miBotonAloja");
		int a= Integer.valueOf(miAloja);
		HttpSession miSesion = request.getSession();
		miSesion.setAttribute("editarAlojamientoAdmin", a);

		RequestDispatcher miR = request.getRequestDispatcher("/editarAlojamientoAdmin.jsp");
		miR.forward(request, response);
	}

}
