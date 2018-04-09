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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/LeerNoticias")
public class LeerNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LeerNoticias() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/securitydb", "root", "");
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("select * from news");
//			PrintWriter writerA = response.getWriter();
			System.out.println("intenta leer el GET");
			String resultado="";
			resultado +="<table class=\"striped\">";
			resultado += "<thead><tr><th>ID</th><th>Titulo</th><th>Descripción</th></tr></thead><tbody>";
			while (rs.next()){
				
				resultado += "<tr>";
				resultado += "<td>" + rs.getInt(1) + "</td>";
				resultado += "<td>" + rs.getString(2) + "</td>";
				resultado += "<td>" + rs.getString(3) + "</td>";
				resultado += "</tr>";
		
			}
			
			resultado += "</tbody></table>";
			
			request.getSession().setAttribute("servletMsg", resultado);
			response.sendRedirect("noticias.jsp"); //tmb para volver al servlet pero no se queda en consulta
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	}


