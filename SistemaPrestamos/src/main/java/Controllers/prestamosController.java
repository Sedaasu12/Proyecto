package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import Beans.prestamosBeans;
import Models.prestamosModels;

/**
 * Servlet implementation class prestamosController
 */
@WebServlet("/prestamosController")
public class prestamosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	prestamosModels modelo = new prestamosModels();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prestamosController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String operacion = request.getParameter("op");
			if (operacion == null) {
				this.listar(request, response);
			}

			switch (operacion) {
			
			case "listar": {
				this.listar(request, response);
				break;
			}
			case "nuevo": {
				request.getRequestDispatcher("/prestamos/nuevoPrestamo.jsp").forward(request, response);
				break;
			}
			case "insertar": {
				this.insertar(request, response);
				break;
			}
			 case "eliminar":
		            eliminar(request, response);
		            break;
		            
			 default:
					throw new IllegalArgumentException("Unexpected value: " + operacion);
				}
			}
			
			
		
    }
	
	  private void listar(HttpServletRequest request, HttpServletResponse response) {
			java.util.logging.Logger.getLogger(prestamosController.class.getName()).log(Level.SEVERE, null, "Entro mano");
			try {
				request.setAttribute("listaPrestamos", modelo.listarPrestamos());
				request.getRequestDispatcher("/prestamos/listaPrestamos.jsp").forward(request, response);

			} catch (ServletException | IOException e) {
				java.util.logging.Logger.getLogger(clientesController.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	  
	  
	  private void eliminar(HttpServletRequest request, HttpServletResponse response) {
	        try {
	            response.setContentType("text/html; charset=UTF-8");
	            int id = Integer.parseInt(request.getParameter("id_prestamo"));

	            int resultado = modelo.eliminarPrestamo(id);
	            String mensaje = resultado > 0 ? "Prestamo eliminado exitosamente" : "Error al eliminar libro";
	            request.getSession().setAttribute("mensaje", mensaje);

	        } catch (Exception e) {
	            Logger.getLogger(prestamosController.class.getName()).log(Level.SEVERE, null, e);
	            request.getSession().setAttribute("mensaje", "Error: " + e.getMessage());
	        }
	        listar(request, response);
	    }
	  
	  private void insertar(HttpServletRequest request, HttpServletResponse response) {
			java.util.logging.Logger.getLogger(prestamosController.class.getName()).log(Level.SEVERE, null, "Entro mano");
			
			try {
				prestamosBeans prestamos_ = new prestamosBeans();
				prestamos_.setFechaPrestamo(java.sql.Date.valueOf(request.getParameter("fecha_prestamo")));
				prestamos_.setMonto(Double.parseDouble(request.getParameter("monto")));
				prestamos_.setInteres(Double.parseDouble(request.getParameter("interes")));
				prestamos_.setNumeroCuotas(Integer.parseInt(request.getParameter("numero_cuotas")));
				prestamos_.setIdCliente(Integer.parseInt(request.getParameter("id_cliente")));
				
				if (modelo.insertarPrestamos(prestamos_) > 0) {
					System.out.println("peppe");
					request.getSession().setAttribute("mensaje", "Registro Exitoso");
				} else {
					System.out.println("noeppepe");
					request.getSession().setAttribute("mensaje", "Registro Fallido");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			this.listar(request, response);

		}
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
