package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Books;
import com.app.util.DBUtil;

public class AddBookController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("//WEB-INF/book/add.jsp");
		 rd.forward(request, response);
    } 




	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
        try{
			 String name 		= request.getParameter("name");
			 String category 	= request.getParameter("category");
			 String publisher 	= request.getParameter("publisher");
			 String price 		= request.getParameter("price");
			 String summary 	= request.getParameter("summary");
			 
			 Books beanAdd = new Books();
			 beanAdd.setName(name);
			 beanAdd.setCategory(category);
			 beanAdd.setPublisher(publisher);
			 beanAdd.setPrice(price);
			 beanAdd.setSummary(summary);
			 
			 DBUtil dbobject = new DBUtil();
			 dbobject.insertDetails(beanAdd);
			 
			 System.out.println("Add Success >>>>>>>>>>>>>>>>>>");

			response.sendRedirect("../listbooks");
			 
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}
