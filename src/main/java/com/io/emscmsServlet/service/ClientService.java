package com.io.emscmsServlet.service;

import java.sql.ResultSet;
import java.util.List;

import com.io.emscmsServlet.DTO.Client;
import com.io.emscmsServlet.DTO.ClientEmployeeResponse;
import com.io.emscmsServlet.DTO.Employees;


public interface ClientService {

	void addClient(Client client);

	void removeClient(String string);

	void updateClient(Client client, String string);

	List<Client> showAllClients();

	Client getClientByName(String companyName);

	ResultSet getEmployeeByClientId(String string);

	void setEmployeeService(EmployeeService employeeService);

	List<Client> getClientsByIds(List<Client> listClient);

	void updateEmployeeIds(String employeeData, String clientData);

	List<Employees> getAllEmployees();

	ClientEmployeeResponse getAllAssignableEmployees(String clientName);

	void addEmployeeToClient(ClientEmployeeResponse clientEmployeeResponse, String employeeName);

	ClientEmployeeResponse getAllWorkingEmployeesUnderClient(List<Client> clientList, String clientName);

	List<Client> getAllClientsByIds(List<Client> listClient);

	void deleteEmployeeFromClient(String clientId, String employeeId);

	void deleteEmployeeFromClient(String clientId, List<Employees> employeeList, String clientName);

	void deleteEmployeeFromClientForClient(String clientId, String employeeId);

	void addEmployeeToClient(String clientId, String employeeId);

}
