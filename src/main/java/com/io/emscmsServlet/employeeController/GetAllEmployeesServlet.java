package com.io.emscmsServlet.employeeController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.io.emscmsServlet.DAO.ClientDAO;
import com.io.emscmsServlet.DAO.EmployeeDAO;
import com.io.emscmsServlet.service.ClientService;
import com.io.emscmsServlet.service.ClientServiceImpl;
import com.io.emscmsServlet.service.EmployeeService;
import com.io.emscmsServlet.service.EmployeeServiceImpl;
import com.io.emscmsServlet.singleton.DbConnection;

/**
 * Servlet implementation class GetAllEmployeesServlet
 */
public class GetAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAllEmployeesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = DbConnection.getConnection();
		EmployeeDAO employeeDAO = new EmployeeDAO(con);
		ClientDAO clientDAO = new ClientDAO(con);
		ClientService clientService = new ClientServiceImpl(clientDAO);
		EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO, clientService);
		clientService.setEmployeeService(employeeService);
		PrintWriter out=response.getWriter();
		out.print("ANKIT");
		System.out.println("ANKIT");
		request.setAttribute("employeeList", employeeService.getEmployeeList());
		RequestDispatcher rd=request.getRequestDispatcher("Views/employeeViews/employeeDetails.jsp");
		rd.forward(request, response);
	}
	
	
	
	
	
	

}
