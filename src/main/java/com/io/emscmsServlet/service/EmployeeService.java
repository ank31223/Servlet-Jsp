package com.io.emscmsServlet.service;

import java.util.List;

import com.io.emscmsServlet.DTO.Client;
import com.io.emscmsServlet.DTO.EmployeeClientResponse;
import com.io.emscmsServlet.DTO.Employees;


public interface EmployeeService {
	
	void addEmployee(Employees employee);

	void removeEmployee(String x);

	Employees getEmployeeById(String nextInt);

	List<Employees> getEmployeeList();

	void updateEmployee(Employees emp, String name, String gender, int age, int contactNo, String email, String designation, int salary);

	EmployeeClientResponse showAllAssignableClients(String employeeName);

	void addClientToEmployee(String employeeData, String clientData);

	void updateClientIds(String employees, String client);

	List<Employees> getAllEmployeesByListOfIds(List<Employees> employeeList);

	EmployeeClientResponse getAllClientsUnderEmployee(List<Employees> employeList, String employeeName);

	void deleteClientFromEmployee(String id, List<Client> listClient, String clientName);

	void deleteClientFromEmployee(String employeeId, String clientId);

	void deleteEmployeeFromClientForClient(String employeeId, String clientId);
	
	String getEmployeeIdByName(String employeeName);
	
	void deleteEmployeeIdFromAll(String employeeId);

	void removeClientIdFromClientIds(String clientId);


}
