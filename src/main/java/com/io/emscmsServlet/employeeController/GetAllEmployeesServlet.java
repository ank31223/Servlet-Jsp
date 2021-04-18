package com.io.emscmsServlet.employeeController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.io.emscmsServlet.DTO.EmployeeClientResponse;
import com.io.emscmsServlet.DTO.Employees;
import com.io.emscmsServlet.service.EmployeeService;
import com.io.emscmsServlet.singleton.ServiceFactory;

/**
 * Servlet implementation class GetAllEmployeesServlet
 */
public class GetAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	public GetAllEmployeesServlet() {
		super();
		this.employeeService = ServiceFactory.getEmployeeService();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/getAllEmployees":
			viewAllEmployees(request, response);
			break;
		case "/deleteEmployee":
			deleteEmployee(request, response);
			break;
		case "/edit":
			editServlet(request, response);
			break;
		case "/updateEmployee":
			updateEmployee(request, response);
			break;
		case "/addEmployee":
			addEmployee(request, response);
			break;
		case "/viewClientsUnderEmployee":
			viewClientsUnderEmployee(request, response);
			break;
		case "/removeEmployeeClient":
			removeEmployeeClient(request, response);
			break;
		case "/addClientToEmployee":
			addClientToEmployee(request, response);
			break;
		default:
			break;
		}

	}

	private void viewAllEmployees(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		out.print("ANKIT");
		request.setAttribute("employeeList", employeeService.getEmployeeList());
		RequestDispatcher rd = request.getRequestDispatcher("Views/employeeViews/employeeDetails.jsp");
		rd.forward(request, response);

	}

	private void editServlet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		PrintWriter out = res.getWriter();
		req.setAttribute("name", name);
		RequestDispatcher rd = req.getRequestDispatcher("Views/employeeViews/UpdateEmployeeForm.jsp");
		rd.forward(req, res);
	}

	private void updateEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String eName = req.getParameter("Name");
		String eGender = req.getParameter("Gender");
		int eAge = Integer.parseInt(req.getParameter("Age"));
		int eContactNo = Integer.parseInt(req.getParameter("ContactNo"));
		String eEmail = req.getParameter("Email");
		String eDesignation = req.getParameter("Designation");
		int eSalary = Integer.parseInt(req.getParameter("Salary"));

		Employees emp = employeeService.getEmployeeById(uname);
		System.out.println(emp);
		employeeService.updateEmployee(emp, eName, eGender, eAge, eContactNo, eEmail, eDesignation, eSalary);
		res.sendRedirect("/servletProject/getAllEmployees");

	}

	private void deleteEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String eName = req.getParameter("name");
		employeeService.removeEmployee(eName);
		String employeeId = employeeService.getEmployeeIdByName(eName);
		employeeService.deleteEmployeeIdFromAll(employeeId);
		employeeService.removeEmployee(eName);
		res.sendRedirect("/servletProject/getAllEmployees");

	}

	private void addEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String eName = req.getParameter("Name");
		String eGender = req.getParameter("Gender");
		int eAge = Integer.parseInt(req.getParameter("Age"));
		int eContactNo = Integer.parseInt(req.getParameter("ContactNo"));
		String eEmail = req.getParameter("Email");
		String eDesignation = req.getParameter("Designation");
		int eSalary = Integer.parseInt(req.getParameter("Salary"));
		int eStatus = Integer.parseInt(req.getParameter("Status"));

		Employees employees = new Employees();
		employees.setName(eName);
		employees.setGender(eGender);
		employees.setAge(eAge);
		employees.setContactNo(eContactNo);
		employees.setEmail(eEmail);
		employees.setDesignation(eDesignation);
		employees.setSalary(eSalary);
		employees.setStatus(eStatus);

		employeeService.addEmployee(employees);

		res.sendRedirect("/servletProject/getAllEmployees");
	}

	private void viewClientsUnderEmployee(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String eName = req.getParameter("name");
		List<Employees> empList = employeeService.getEmployeeList();
		EmployeeClientResponse ecr = employeeService.getAllClientsUnderEmployee(empList, eName);
		EmployeeClientResponse ecr1 = employeeService.showAllAssignableClients(eName);
		req.setAttribute("ecr", ecr);
		req.setAttribute("ecr1", ecr1);
		RequestDispatcher rd = req.getRequestDispatcher("Views/employeeViews/employeeClients.jsp");
		rd.forward(req, res);
	}

	private void removeEmployeeClient(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String employeeId = req.getParameter("employeeId");
		String clientId = req.getParameter("clientId");
		String employeeName = req.getParameter("employeeName");

		employeeService.deleteClientFromEmployee(employeeId, clientId);
		res.sendRedirect("/servletProject/viewClientsUnderEmployee?name=" + employeeName);
	}

	private void addClientToEmployee(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String employeeId = req.getParameter("employeeId");
		String clientId = req.getParameter("clientId");
		String employeeName = req.getParameter("employeeName");
		employeeService.addClientToEmployee(employeeId, clientId);
		res.sendRedirect("/servletProject/viewClientsUnderEmployee?name=" + employeeName);
	}

}
