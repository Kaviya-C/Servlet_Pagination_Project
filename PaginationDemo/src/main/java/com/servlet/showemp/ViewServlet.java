package com.servlet.showemp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.logic.EmployeeDAO;
import com.servlet.emp.Employee;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2>This is the Employee Details</h2>");
		
		String pageNo=request.getParameter("page");
		
		int page= Integer.parseInt(pageNo);
		
		int total=5;
		
		
		if(page==1) {}
		else
		{
			page=page-1;
			page=page*total+1;
		}
		
		
		List<Employee> list =EmployeeDAO.getrecords(page, total);
		
		out.print("<h3>PageNo: "+page+"</h2>");
		
		out.print(
		"<table border='3' cellpadding='4' width='100%'>"
		+ "<tr>"
		+ "<th>Emlployee ID</th>"
		+ "<th>Employee Name</th>"
		+ "<th>Employee Company</th>"
		+ "<th>Employee Salary</th>"
		+"</tr>"
		
		);
		
		for(Employee e: list)
		{
			out.println(
					
					"<tr>"
					+ "<td>"+e.getEmpId()+"</td>"
					+ "<td>"+e.getEmpName()+"</td>"
					+ "<td>"+e.getEmpComp()+"</td>"
					+ "<td>"+e.getEmpSal()+"</td>"
					
					);
		}
			out.print("</table>");
			
			out.println("<h2>");
			
          out.print("<a href = 'viewServlet?page=1'>1</a><br>");
          
          out.print("<a href = 'viewServlet?page=2'>2</a><br>");

          out.print("<a href = 'viewServlet?page=3'>3</a>");

             out.println("</h2>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
