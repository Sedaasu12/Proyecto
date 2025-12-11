package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;



import Beans.clientesBeans;
import Models.clientesModels;






/**
 * Servlet implementation class clientesController
 */
@WebServlet("/clientesController")
public class clientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	clientesModels modelo = new clientesModels();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientesController() {
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
				request.getRequestDispatcher("/clientes/nuevoCliente.jsp").forward(request, response);
				break;
			}
			case "insertar": {
				this.insertar(request, response);
				break;
			}
			case "eliminar": {
				int id = Integer.parseInt(request.getParameter("id_cliente"));
				modelo.eliminarClientes(id);
				this.listar(request, response);
				break;
			}
			
			case "editar": {
				int id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("clientes_llamado", modelo.obtenerClientes(id));
				request.getRequestDispatcher("/clientes/editarCliente.jsp").forward(request, response);
				break;
			}
			
			case "modificar":{				
				this.modificar(request, response);
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + operacion);
			}
		}

		}
		
		  private void listar(HttpServletRequest request, HttpServletResponse response) {
				java.util.logging.Logger.getLogger(clientesController.class.getName()).log(Level.SEVERE, null, "Entro mano");
				try {
					request.setAttribute("listaClientes", modelo.listarClientes());
					request.getRequestDispatcher("/clientes/listaClientes.jsp").forward(request, response);

				} catch (ServletException | IOException e) {
					java.util.logging.Logger.getLogger(clientesController.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		  
		  private void insertar(HttpServletRequest request, HttpServletResponse response) {
				java.util.logging.Logger.getLogger(clientesController.class.getName()).log(Level.SEVERE, null, "Entro mano");
				
				try {
					clientesBeans clientes_ = new clientesBeans();
					clientes_.setNombres(request.getParameter("nombres"));
					clientes_.setApellidos(request.getParameter("apellidos"));
					clientes_.setDni(request.getParameter("dni"));
					clientes_.setFecha_nacimiento(java.sql.Date.valueOf(request.getParameter("fecha_nacimiento")));
					clientes_.setDireccion(request.getParameter("direccion"));
					
					if (modelo.insertarClientes(clientes_) > 0) {
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
		  private void modificar(HttpServletRequest request, HttpServletResponse response) {
				java.util.logging.Logger.getLogger(clientesController.class.getName()).log(Level.SEVERE, null, "Entro mano");
				
				try {
					clientesBeans clientes_ = new clientesBeans();
					clientes_ .setId_clientes(Integer.parseInt(request.getParameter("id_cliente")));
					clientes_ .setNombres(request.getParameter("nombres"));
					clientes_ .setApellidos(request.getParameter("apellidos"));
					clientes_ .setDni(request.getParameter("dni"));
					clientes_.setFecha_nacimiento(java.sql.Date.valueOf(request.getParameter("fecha_nacimiento")));
					clientes_ .setDireccion(request.getParameter("direccion"));
					
					if (modelo.modificarClientes(clientes_) > 0) {
						request.getSession().setAttribute("mensaje", "Registro Exitoso");
					} else {
						request.getSession().setAttribute("mensaje", "Registro Fallido");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				this.listar(request, response);

			}
		    private void obtener(HttpServletRequest request, HttpServletResponse response) {
				try {
					String id = request.getParameter("id_cliente");
					request.setAttribute("clientes", modelo.obtenerClientes(Integer.parseInt(id)));
					request.getRequestDispatcher("/clientes/editarCliente.jsp").forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}

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
