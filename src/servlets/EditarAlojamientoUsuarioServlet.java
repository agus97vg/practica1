package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import controllers.AlojamientoController;
import datapackage.Alojamiento;

/**
 * Servlet implementation class EditarAlojamientoUsuarioServlet
 */
@WebServlet("/EditarAlojamientoUsuarioServlet")
public class EditarAlojamientoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAlojamientoUsuarioServlet() {
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
		
		
		
		String ciudad= request.getParameter("ciudad");
		String breveDescripcion= request.getParameter("bDescripcion");
		String descripcion= request.getParameter("descripcion");
		String tipo= request.getParameter("tipo");
		String numero= request.getParameter("numero");
		String numeroCamas= request.getParameter("numeroCamas");
	
		String precioPorNoche= request.getParameter("precio");
		
		System.out.println("EL VALOR DE TIPO QUE LLEGA ES "+ tipo);
		
		HttpSession miSesion= request.getSession();
		List <Alojamiento> alojad =(List <Alojamiento>) miSesion.getAttribute("listaMisAlojamientos");
		int index=(int) miSesion.getAttribute("editarAlojamientoAdmin");
		
		Alojamiento aloja= alojad.get(index); 
	    
	   
	    AlojamientoController aloj =new AlojamientoController("mydb");
	
	    aloja.setCiudad(ciudad);
	    aloja.setDescripcion_breve(breveDescripcion);
	    aloja.setDecripcion_larga(descripcion);
	    aloja.setTipo(tipo);
	    aloja.setNumero_camas(Integer.valueOf(numeroCamas));
	    aloja.setNumero_huespedes(Integer.valueOf(numero));
	    
	    aloja.setPrecio(Integer.valueOf(precioPorNoche));
	   
	    aloja.setANFITRIONES_USUARIOS_Correo(aloja.getId().getANFITRIONES_USUARIOS_Correo());
	    System.out.println("El anfitrion es "+ aloja.getId().getANFITRIONES_USUARIOS_Correo());
	    System.out.println("El nombre del alojamiento es"+ aloja.getId().getNombre());
	    aloj.updateAlojamiento(aloja);
	    response.sendRedirect("indexSesionIniciada.jsp");
	    
	}

}
