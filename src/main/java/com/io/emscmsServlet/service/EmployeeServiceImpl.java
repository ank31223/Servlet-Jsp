package com.io.emscmsServlet.service;

import java.util.List;

import com.io.emscmsServlet.DAO.EmployeeDAO;
import com.io.emscmsServlet.DTO.Client;
import com.io.emscmsServlet.DTO.EmployeeClientResponse;
import com.io.emscmsServlet.DTO.Employees;



public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	private ClientService clientService;

	public EmployeeServiceImpl(EmployeeDAO employeeDAO, ClientService clientService) {
		this.employeeDAO = employeeDAO;
		this.clientService = clientService;
	}

	public void addEmployee(Employees employee) {
		employeeDAO.saveEmployee(employee);
	}

	public void removeEmployee(String x) {
		employeeDAO.removeEmployee(x);
	}

	public Employees getEmployeeById(String nextInt) {
		return employeeDAO.getEmployeeById(nextInt);
	}

	public List<Employees> getEmployeeList() {
		return employeeDAO.getEmployeeList();
	}

	@Override
	public void updateEmployee(Employees emp, String name, String gender, int age, int contactNo, String email,
			String designation, int salary) {
		employeeDAO.updateEmployee(emp, name, gender, age, contactNo, email, designation, salary);
	}

	@Override
	public EmployeeClientResponse showAllAssignableClients(String employeeName) {

		EmployeeClientResponse employeeClientResponse = employeeDAO.getAllNotAssignableClients(employeeName);
		List<Client> clients = clientService.getClientsByIds(employeeClientResponse.getListClient());
		EmployeeClientResponse employeeClientResponse2 = new EmployeeClientResponse();
		employeeClientResponse2.setListEmployee(employeeClientResponse.getListEmployee());
		employeeClientResponse2.setListClient(clients);
		return employeeClientResponse2;

	}

	@Override
	public void addClientToEmployee(String employeeId, String clientId) {
		employeeDAO.addClientToEmployee(employeeId, clientId);
		clientService.updateEmployeeIds(employeeId, clientId);

	}

	@Override
	public void updateClientIds(String employeesId, String clientId) {
		employeeDAO.addClientToEmployee(employeesId, clientId);
	}

	@Override
	public List<Employees> getAllEmployeesByListOfIds(List<Employees> employeeList) {

		return employeeDAO.getAllEmployeesByListOfIds(employeeList);
	}

	@Override
	public EmployeeClientResponse getAllClientsUnderEmployee(List<Employees> employeList, String employeeName) {
		Employees employees1 = new Employees();
		for (Employees employees : employeList) {
			if (employees.getName().equalsIgnoreCase(employeeName)) {
				employees1 = employees;
			}
		}
		EmployeeClientResponse employeeClientResponse = employeeDAO.getAllClientsIdforEmployee(employees1);
		List<Client> clientList = clientService.getAllClientsByIds(employeeClientResponse.getListClient());
		EmployeeClientResponse employeeClientResponse2 = new EmployeeClientResponse();
		employeeClientResponse2.setListEmployee(employeeClientResponse.getListEmployee());
		employeeClientResponse2.setListClient(clientList);
		return employeeClientResponse2;
	}

	@Override
	public void deleteClientFromEmployee(String employeeId, List<Client> listClient, String clientName) {
		String clientId = null;
		for (Client client : listClient) {
			if (client.getCompanyName().equalsIgnoreCase(clientName)) {
				clientId = client.getId();
				break;
			}
		}
		System.out.println(employeeId + " " + clientId);
		employeeDAO.deleteClientFromEmployee(employeeId, clientId);
		clientService.deleteEmployeeFromClient(clientId, employeeId);
	}

	@Override
	public void deleteClientFromEmployee(String employeeId, String clientId) {
		employeeDAO.deleteClientFromEmployee(employeeId, clientId);
		clientService.deleteEmployeeFromClient(clientId, employeeId);

	}

	@Override
	public void deleteEmployeeFromClientForClient(String employeeId, String clientId) {
		employeeDAO.deleteClientFromEmployee(employeeId, clientId);
		
	}


}
