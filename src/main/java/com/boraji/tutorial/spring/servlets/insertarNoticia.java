package com.boraji.tutorial.spring.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



@WebServlet("/insertarNoticia")
public class insertarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public insertarNoticia() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		doGet(request, response);
		
		String title= request.getParameter("title");
		String description = request.getParameter("description");
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/securitydb", "root", "");
			PreparedStatement st= conn.prepareStatement("INSERT INTO news (title, description) values (?, ?)") ;
			
			System.out.println("entra en el servlet");
			st.setString(1, title);
			st.setString(2, description);
			
			
			st.executeUpdate();
			
			PrintWriter writerA = response.getWriter();
			writerA.println("Se ha añadido la noticia");
			
			writerA.println("<a href=leer.jsp>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


