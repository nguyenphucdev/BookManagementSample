package book.controller;

import java.util.jar.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import book.model.*;
import book.db.*;
/**
 *
 * @author Phuc
 */
public class Controller extends HttpServlet {
   
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
           DBClass dbobject = new DBClass();
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           //get the values from jsp page
        	 id = Integer.parseInt(request.getParameter("id"));
            name = request.getParameter("name");
            category = request.getParameter("category");
            publisher = request.getParameter("publisher");
            price = request.getParameter("price");
            summary = request.getParameter("summary");
            action = request.getParameter("action");
           if(action.equals("submit"))
           {
          //set values to book.For this call below method
           
            
        
           }
           if(action.equals("edit"))
           {
               
           }
            if(action.equals("update"))
           {
               
            }
            
           
        
                if(action.equals("delete"))
           {
               
           }
                //using DBClass object call insertDetails method and pass bean object
               //dbobject.UpateDetails(book,id);
                List<Books> list = dbobject.getAlldetails();
                request.setAttribute("list", list);
                //forward to insertupdate page using requestdispatcher
                RequestDispatcher rd= request.getRequestDispatcher("view.jsp");
                //display a message to client.store message in request object
               //forwarding to jsp
                rd.forward(request, response);
        } 
        catch(Exception e)
        {
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

}
