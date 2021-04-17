package com.io.emscmsServlet.service;

import java.sql.ResultSet;
import java.util.List;

import com.io.emscmsServlet.DAO.ClientDAO;
import com.io.emscmsServlet.DTO.Client;
import com.io.emscmsServlet.DTO.ClientEmployeeResponse;
import com.io.emscmsServlet.DTO.Employees;
import com.io.emscmsServlet.commonUtils.CommonUtils;



public class ClientServiceImpl implements ClientService {
	
	private ClientDAO clientDAO;
	private EmployeeService employeeService;

	public ClientServiceImpl(ClientDAO clientDAO) {
		super();
		this.clientDAO = clientDAO;
	}

	@Override
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void addClient(Client client) {
		client.setId(CommonUtils.getUUID());
		clientDAO.addClient(client);

	}

	public void removeClient(String companyName) {
		clientDAO.removeClient(companyName);
	}

	public void updateClient(Client client, String companyName) {
		clientDAO.updateClient(client, companyName);
	}

	public List<Client> showAllClients() {
		return clientDAO.showAllClients();
	}

	public Client getClientByName(String companyName) {
		return clientDAO.getClientByName(companyName);

	}

	@Override
	public ResultSet getEmployeeByClientId(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getClientsByIds(List<Client> listClient) {
		List<Client> client = clientDAO.getClientsByIds(listClient);
		return client;
	}

	@Override
	public void updateEmployeeIds(String employeeId, String clientId) {
		clientDAO.updateEmployeeIds(employeeId, clientId);

	}

	@Override
	public List<Employees> getAllEmployees() {
		return employeeService.getEmployeeList();
	}

	@Override
	public ClientEmployeeResponse getAllAssignableEmployees(String clientName) {
		ClientEmployeeResponse clientEmployeeResponse = clientDAO.getAllAssignableEmployees(clientName);
		return clientEmployeeResponse;
	}

	@Override
	public void addEmployeeToClient(ClientEmployeeResponse clientEmployeeResponse, String employeeName) {
		String employeeId = null;
		for (Employees employees : clientEmployeeResponse.getEmployeeList()) {
			if (employees.getName().equalsIgnoreCase(employeeName)) {
				employeeId = employees.getId();
			}
		}
		ClientEmployeeResponse clientEmployeeResponse2 = clientDAO
				.addEmployeeToClient(clientEmployeeResponse.getClientList().get(0).getId(), employeeId);
		employeeService.updateClientIds(clientEmployeeResponse2.getEmployeeList().get(0).getId(),
				clientEmployeeResponse2.getClientList().get(0).getId());
	}
	
	@Override
	public void addEmployeeToClient(String clientId, String employeeId) {
		clientDAO.addEmployeeToClient(clientId, employeeId);
		employeeService.updateClientIds(employeeId, clientId);
	}

	@Override
	public ClientEmployeeResponse getAllWorkingEmployeesUnderClient(List<Client> clientList, String clientName) {
		Client client1 = new Client();
		for (Client client : clientList) {
			if (client.getCompanyName().equalsIgnoreCase(clientName)) {
				client1 = client;
			}
		}
		ClientEmployeeResponse clientEmployeeResponse = clientDAO.getAllWorkingEmployeesUnderClient(client1);
		List<Employees> employeeList = employeeService
				.getAllEmployeesByListOfIds(clientEmployeeResponse.getEmployeeList());
		ClientEmployeeResponse clientEmployeeResponse2 = new ClientEmployeeResponse();
		clientEmployeeResponse2.setEmployeeList(employeeList);
		clientEmployeeResponse2.setClientList(clientEmployeeResponse.getClientList());
		return clientEmployeeResponse2;
	}

	@Override
	public List<Client> getAllClientsByIds(List<Client> listClient) {
		return clientDAO.getAllClientsByIds(listClient);
	}

	@Override
	public void deleteEmployeeFromClient(String clientId, String employeeId) {
		clientDAO.deleteEmployeeFromClient(clientId, employeeId);
	}
	
	@Override
	public void deleteEmployeeFromClientForClient(String clientId, String employeeId) {
		clientDAO.deleteEmployeeFromClient(clientId, employeeId);
		employeeService.deleteEmployeeFromClientForClient(employeeId,clientId);
	}
	
	@Override
	public void deleteEmployeeFromClient(String clientId, List<Employees> employeeList, String employeeName) {
		String employeeId = null;
		for (Employees employees : employeeList) {
			if (employeeName.equalsIgnoreCase(employees.getName())) {
				employeeId = employees.getId();
			}
		}
		deleteEmployeeFromClient(clientId, employeeId);
		employeeService.deleteClientFromEmployee(employeeId, clientId);
	}
	
	public String getClientIdByName(String clientName) {
		return clientDAO.getClientByName(clientName).getId();
	}

	@Override
	public void removeEmployeeIdFromEmployeeIds(String employeeId) {
		clientDAO.removeEmployeeIdFromEmployeeIds(employeeId);
	}

	@Override
	public void deleteClientIdFromAll(String clientId) {
		clientDAO.deleteClientFromEmployeeIds(clientId);
		employeeService.removeClientIdFromClientIds(clientId);
		
	}
	
	

}
