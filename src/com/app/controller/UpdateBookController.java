package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Books;
import com.app.util.DBUtil;

public class UpdateBookController extends HttpServlet {
	/**
	 * 
	 */
	String id = null;
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

  
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		String message = "";
    		id = request.getParameter("id");
    		String formatLog  = "Add action with [ id  %s]";
    		System.out.println(String.format(formatLog, id));
    		if(id == null || id.equals("")){
    			message = "Error";
    			request.setAttribute("msg", message);
    			request.setAttribute("bean", null);
    			RequestDispatcher rd= request.getRequestDispatcher("//WEB-INF/book/update.jsp");
    			 rd.forward(request, response);
    			return;
    		}
    	
    		DBUtil dbobject = new DBUtil();
    		Books bean;
		
				bean = dbobject.getDetails(Integer.parseInt(id));
		
		
				request.setAttribute("msg", "");
				request.setAttribute("bean", bean);
				RequestDispatcher rd= request.getRequestDispatcher("//WEB-INF/book/update.jsp");
				 rd.forward(request, response);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	 
		
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		confirmUpdate(request,response);
    }
	private void confirmUpdate(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		try{
			 String  id 		= request.getParameter("id");
			 String name 		= request.getParameter("name");
			 String category 	= request.getParameter("category");
			 String publisher 	= request.getParameter("publisher");
			 String price 		= request.getParameter("price");
			 String summary 	= request.getParameter("summary");
			 
			 Books beanUpdate = new Books();
			 beanUpdate.setId(Integer.parseInt(id));
			 beanUpdate.setName(name);
			 beanUpdate.setCategory(category);
			 beanUpdate.setPublisher(publisher);
			 beanUpdate.setPrice(price);
			 beanUpdate.setSummary(summary);
			 
			 DBUtil dbobject = new DBUtil();
			 dbobject.UpateDetails(beanUpdate, beanUpdate.getId());
			 
			 System.out.println("UPDATE THANH CONG >>>>>>>>>>>>>>>>>>");
//			 RequestDispatcher rd= request.getRequestDispatcher("/listbooks");
//			 rd.(request, response);
			response.sendRedirect("../listbooks");
			 
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

