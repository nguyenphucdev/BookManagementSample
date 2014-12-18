package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Books;
import com.app.util.DBUtil;
/**
 *
 * @author Phuc
 */
public class ListBooksController extends HttpServlet {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
		//declare values to get form values from jsp page
			int id;
           String name;
           String category;
           String publisher;
           String price;
           String summary;
           String action;


           Books book = new Books();
           DBUtil dbobject = new DBUtil();
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Books> list  = null;
        try {
                   //using DBClass object call insertDetails method and pass bean object
                  list = dbobject.getAlldetails();
                  request.setAttribute("books", list);
                  RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/book/listbooks.jsp");
                  rd.forward(request, response);

        }catch(Exception e)
        {
        	System.out.println(e.toString());
        	e.printStackTrace();
            out.println(e);
        }
        finally {
            out.close();
        }
    }
  
   
  
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

  
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
	public String getServletInfo() {
        return "Short description";
    }
    
    //this method is used to setvalues to bean
    public void setValuesToBook()
    {
        book.setId(id);
        book.setName(name);
        book.setPublisher(publisher);
        book.setCategory(category);
        book.setPrice(price);
        book.setSummary(summary);
        
    }

}
