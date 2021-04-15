package com.io.emscmsServlet.DTO;

import java.util.List;


public class EmployeeClientResponse {
	
	List<Employees> listEmployee;
	List<Client> listClient;

	public List<Employees> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employees> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

}
