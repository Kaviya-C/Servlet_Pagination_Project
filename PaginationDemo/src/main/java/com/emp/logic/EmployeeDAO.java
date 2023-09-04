package com.emp.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servlet.emp.Employee;

public class EmployeeDAO {
	public static Connection getConnection() {
		Connection con = null;
		try {

			System.out.println("1");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/gqt_jdbc";
			String user = "root";
			String password = "root123";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static List<Employee> getrecords(int start, int total) 
	{

		List<Employee> records = new ArrayList<Employee>();
		try {
			Connection con = getConnection();
			
			System.out.println("2");
			
			PreparedStatement stmt = con.prepareStatement("select * from employee limit " +(start - 1)+ ","+total);

			ResultSet set = stmt.executeQuery();

			while (set.next()) {
				Employee emp = new Employee();
				emp.setEmpId(set.getInt(1));
				emp.setEmpName(set.getString(2));
				emp.setEmpComp(set.getString(3));
				emp.setEmpSal(set.getInt(4));

				records.add(emp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return records;

	}

	

}
