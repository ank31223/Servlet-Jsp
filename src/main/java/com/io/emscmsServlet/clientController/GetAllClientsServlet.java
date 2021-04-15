package com.io.emscmsServlet.clientController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

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


public class GetAllClientsServlet  extends HttpServlet{
	
      public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
        Connection con=DbConnection.getConnection();
  		EmployeeDAO employeeDAO=new EmployeeDAO(con);
  		ClientDAO clientDAO=new ClientDAO(con);
  		ClientService clientService=new ClientServiceImpl(clientDAO);
  		EmployeeService employeeService=new EmployeeServiceImpl(employeeDAO,clientService);
  		clientService.setEmployeeService(employeeService);
  		
  		
  		PrintWriter out=res.getWriter();
  		
  		out.println(employeeService.getEmployeeList());
    	  
    	  
      }

}
