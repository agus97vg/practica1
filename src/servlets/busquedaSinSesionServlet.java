package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controllers.AlojamientoController;
import datapackage.Alojamiento;



/**
 * Servlet implementation class busquedaSinSesionServlet
 */
@WebServlet("/busquedaSinSesionServlet")
public class busquedaSinSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public busquedaSinSesionServlet() {
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
		String ciudad=request.getParameter("ciudad");
		String fechaInicio=request.getParameter("fechaIni");
	    String fechaFin=request.getParameter("fechaFin");
	    String precioNoche=request.getParameter("preci");
		String tipo=request.getParameter("tipo");
		System.out.println("EL TIPO ES: "+ tipo);
		String adultos=request.getParameter("adultos");
		String ninyos=request.getParameter("ninyos");
		System.out.println("Los niños son  "+request.getParameter("ninyos"));
		System.out.println("El precio es  "+request.getParameter("preci"));

		
		String[] fechaIni= fechaInicio.split("/"); 
	    String[] fechaFi= fechaFin.split("/");
	    
	    fechaInicio= fechaIni[2]+"-"+fechaIni[0]+"-"+fechaIni[1];
	    fechaFin= fechaFi[2]+"-"+fechaFi[0]+"-"+fechaFi[1];
		
	    Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		Date date2=null;
	    try {
			 date2=new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//Busqueda busqueda= new Busqueda(ciudad, fechaInicio, fechaFin, precioNoche, tipo, adultos, ninyos);
	    
	    
	    System.out.println("LA FECHA ES LA SIGUIENTE "+ date1);
		
		Alojamiento aloja = new Alojamiento();
		aloja.setCiudad(ciudad);
		aloja.setFecha_inicio(date1);
		aloja.setFecha_fin(date2);
		//System.out.println("El precio por noche es "+precioNoche);
		aloja.setPrecio(Integer.valueOf(precioNoche));
		aloja.setTipo(tipo);
		System.out.println(adultos);
		System.out.println(ninyos);
		aloja.setNumero_huespedes(Integer.valueOf(adultos)+Integer.valueOf(ninyos));
		
		
		
		
		AlojamientoController aloj =new AlojamientoController("mydb");
		
		List <Alojamiento> busqueda = aloj.Busqueda(aloja);
		
		System.out.println("SE HAN OBTENIDO UN TOTAL DE "+busqueda.size());
		
		
		HttpSession miSesion = request.getSession();
		
		miSesion.setAttribute("fechaInicioReserva", fechaInicio);
		miSesion.setAttribute("fechaFinReserva", fechaFin);
		if(miSesion.getAttribute("correo")==null) {
			
			miSesion=request.getSession(true);
			miSesion.setAttribute("listaAlojamientos",busqueda);
			miSesion.setAttribute("tamanyoLista", busqueda.size());
			RequestDispatcher miR = request.getRequestDispatcher("/resultados.jsp");
			miR.forward(request, response);
		}else {
			miSesion.setAttribute("listaAlojamientos",busqueda);
			miSesion.setAttribute("tamanyoLista", busqueda.size());
			RequestDispatcher miR = request.getRequestDispatcher("/resultadosIniciadaSesion.jsp");
			miR.forward(request, response);
		}
		
	
		
		
	}

	
	
	
}
