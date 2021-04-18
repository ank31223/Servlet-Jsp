package com.io.emscmsServlet.singleton;

import java.sql.Connection;

import com.io.emscmsServlet.DAO.ClientDAO;
import com.io.emscmsServlet.DAO.EmployeeDAO;
import com.io.emscmsServlet.service.ClientService;
import com.io.emscmsServlet.service.ClientServiceImpl;
import com.io.emscmsServlet.service.EmployeeService;
import com.io.emscmsServlet.service.EmployeeServiceImpl;

public class ServiceFactory {
	private static ClientService clientService = null;
	private static EmployeeService employeeService = null;

	private ServiceFactory() {
		Connection con = DbConnection.getConnection();
		EmployeeDAO employeeDAO = new EmployeeDAO(con);
		ClientDAO clientDAO = new ClientDAO(con);
		clientService = new ClientServiceImpl(clientDAO);
		employeeService = new EmployeeServiceImpl(employeeDAO, clientService);
		clientService.setEmployeeService(employeeService);

	}

	public static ClientService getClientService() {
		if (clientService == null) {
			new ServiceFactory();
		}
		return clientService;

	}

	public static EmployeeService getEmployeeService() {

		if (employeeService == null) {
			new ServiceFactory();
		}
		return employeeService;

	}

}
