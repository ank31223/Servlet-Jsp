package com.io.emscmsServlet.clientController;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.io.emscmsServlet.DAO.ClientDAO;
import com.io.emscmsServlet.DAO.EmployeeDAO;
import com.io.emscmsServlet.DTO.Client;
import com.io.emscmsServlet.DTO.ClientEmployeeResponse;
import com.io.emscmsServlet.DTO.Employees;
import com.io.emscmsServlet.service.ClientService;
import com.io.emscmsServlet.service.ClientServiceImpl;
import com.io.emscmsServlet.service.EmployeeService;
import com.io.emscmsServlet.service.EmployeeServiceImpl;
import com.io.emscmsServlet.singleton.DbConnection;

/**
 * Servlet implementation class GetAllClientsServlet
 */
public class GetAllClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientService clientService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllClientsServlet() {
		super();
		Connection con = DbConnection.getConnection();
		EmployeeDAO employeeDAO = new EmployeeDAO(con);
		ClientDAO clientDAO = new ClientDAO(con);
		ClientService clientService = new ClientServiceImpl(clientDAO);
		EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO, clientService);
		clientService.setEmployeeService(employeeService);
		this.clientService = clientService;

	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {

		case "/getAllClients":
			viewAllClients(request, response);
			break;
		case "/deleteClient":
			deleteClient(request, response);
			break;
		case "/editClient":
			editClient(request, response);
			break;
		case "/updateClient":
			updateClient(request, response);
			break;
		case "/addClient":
			addClient(request, response);
			break;
		case "/viewEmployeesUnderClient":
			viewEmployeesUnderClient(request, response);
			break;
		case "/removeClientEmployee":
			removeClientEmployee(request, response);
			break;
		case "/addEmployeeToClient":
			addEmployeeToClient(request, response);
			break;
		default:
			break;

		}

	}

	private void viewAllClients(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setAttribute("clientList", clientService.showAllClients());
		RequestDispatcher rd = req.getRequestDispatcher("Views/clientViews/clientDetails.jsp");
		rd.forward(req, res);
	}

	private void deleteClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String clientName=req.getParameter("clientName");
		clientService.removeClient(clientName);
		res.sendRedirect("/servletProject/getAllClients");
		
	}

	private void editClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String clientName=req.getParameter("clientName");
		req.setAttribute("clientName", clientName);
		RequestDispatcher rd=req.getRequestDispatcher("Views/clientViews/updateClientForm.jsp");
		rd.forward(req, res);
	}

	private void updateClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cname=req.getParameter("cname");
		String clientName=req.getParameter("clientName");
		String clientAddress=req.getParameter("clientAddress");
		Client client=new Client();
		client.setCompanyName(clientName);
		client.setCompanyAddress(clientAddress);
		clientService.updateClient(client, cname);
		System.out.println(cname);
		res.sendRedirect("/servletProject/getAllClients");
		
	}

	private void addClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String clientName = req.getParameter("clientName");
		String clientAddress = req.getParameter("clientAddress");

		Client client=new Client();
		client.setCompanyName(clientName);
		client.setCompanyAddress(clientAddress);
		clientService.addClient(client);

		res.sendRedirect("/servletProject/getAllClients");
		
		
	}

	private void viewEmployeesUnderClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String clientName=req.getParameter("clientName");
		List<Client> clientList=clientService.showAllClients();
		ClientEmployeeResponse cer=clientService.getAllWorkingEmployeesUnderClient(clientList, clientName);
		ClientEmployeeResponse cer1=clientService.getAllAssignableEmployees(clientName);
		req.setAttribute("cer", cer);
		req.setAttribute("cer1", cer1);
		RequestDispatcher rd=req.getRequestDispatcher("Views/clientViews/clientEmployees.jsp");
		rd.forward(req, res);
		
	}

	private void removeClientEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String clientName=req.getParameter("clientName");
		String clientId=req.getParameter("clientId");
		String employeeId=req.getParameter("employeeId");
		clientService.deleteEmployeeFromClientForClient(clientId, employeeId);
		res.sendRedirect("/servletProject/viewEmployeesUnderClient?clientName="+clientName);
	}

	private void addEmployeeToClient(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String clientId=req.getParameter("clientId");
		String employeeId=req.getParameter("employeeId");
		String clientName=req.getParameter("clientName");
		
		clientService.addEmployeeToClient(clientId, employeeId);
		res.sendRedirect("/servletProject/viewEmployeesUnderClient?clientName="+clientName);
		
		
	}

}
