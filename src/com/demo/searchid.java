package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.pool.OracleDataSource;


 
/**
 * Servlet implementation class searchid
 */
@WebServlet("/searchid")
//@WebServlet(description = "my first web", urlPatterns = {"/searchid" })
public class searchid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//capture the values entered by the user
		
	   String studid = request.getParameter("searchid");
	 
	  /*  //displaying the values
		//out.println("student_id,student_name,stud_gender,stud_sub   "+"=="+studid+"");
		//out.println("<table><table Border =1><tr><td>"+ studid+" </td> <td> "+studname+"</td></tr><tr><td>"+studgender+"</td><td>"+stunsub+" </td></tr></table>");
		Connection con;
		PreparedStatement prp;
		OracleDataSource ods;
		ResultSet rs = null;
		 
		//String name = null,gender = null,sub = null,id=null;
			String qry="select * from student where sid=?";
		try {
			//create an object for ODS
			ods=new OracleDataSource();
			//injecting the appropriate values
			ods.setUser("system");
			ods.setPassword("test");
			ods.setPortNumber(1521);
			ods.setDriverType("thin");
			ods.setServerName("localhost");
			ods.setDatabaseName("xe");
			con=ods.getConnection(); //get the connection
			prp=con.prepareStatement(qry);
			//setting the IN parameters
			prp.setString(1,studid);
			  
			 
			prp.executeQuery();  //executing query
				
		  	rs.getString(1);
			 	rs.getString(2);
		     rs.getString(3);
		    	rs.getString(4);
			 
			      
			    out.println("sucess");
			     System.out.println("The ACTIVE Vendor Details : ");
					System.out.println("============================================");
					out.println("<table><table Border =1><tr><td>"+ id+" </td> <td> "+name+"</td></tr><tr><td>"+gender+"</td><td>"+sub+" </td></tr></table>");
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}  
			    */ 
			  
		 
	   Connection con;
		//String qry="select*from student";
	//	String qry2="select eid,ename,bsal from student where sid=?";
	   String qry2="select * from student where sid=?"; 
		PreparedStatement prp;
		ResultSet rs;
		OracleDataSource ods;
		try {
			ods=new OracleDataSource();
			ods.setUser("system");
			ods.setPassword("test");
			ods.setDriverType("thin");
			ods.setPortNumber(1521);
			ods.setDatabaseName("xe");
			ods.setServerName("localhost");
			
			con=ods.getConnection();
			
			//prp=con.prepareStatement(qry);
			//rs=prp.executeQuery(); //select a query method accrding to query
			prp=con.prepareStatement(qry2);
			
			//looping through the result set
			//set IN parameters
			 prp.setString(1, studid);
			rs=prp.executeQuery();
			while(rs.next())
				
		   // out.println("row no-id and name "+rs.getRow()+" "+rs.getString(1)+" "+rs.getString("sname")+"  "+rs.getString("sgender")+"  "+rs.getString("sub"));
			out.println("<table><table Border =1><tr><td>id</td><td>name</td><td>gender</td><td>sub</td></tr><tr><td>"+rs.getString(1) +" </td> <td> "+rs.getString("sname")+"</td><td>"+rs.getString("sgender")+"</td><td>"+rs.getString("sub")+" </td> </tr></table>");
			
			//if(rs.next())
				out.println("name is "+rs.getString(1));
			//else
			//	out.println("row is not selected");
		}
		catch (Exception e){
			 	e.printStackTrace();
			
		}
		

	}

		
		
		 

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
