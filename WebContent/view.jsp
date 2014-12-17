
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*" %>
<%@page import="book.model.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<%=request.getContextPath()%>/insertupdate.jsp">back</a>
        <table width="100%"border="1">
            <tr>
               <th>id</th>
               <th>Name</th>
               <th>Category</th>
               <th>publisher</th>
               <th>price</th>
               <th>summary</th>
               <th>Action</th>
              
            </tr>
            <%
           
               List<Books> list = (List<Books>)request.getAttribute("list");
               if(list!=null)
                   {
                     for(int i=0 ; i< list.size();i++)
                         {
                           Books book =(Books) list.get(i);

            %>
                <tr>
                    <td><%=book.getId()%></td>
                    <td><%=book.getCategory()%></td>
                    <td><%=book.getPublisher()%></td>
                    <td><%=book.getPrice()%></td>
                     <td><%=book.getSummary()%></td>
                    
                    <td><a href="Controller?action=edit&id=<%=book.getId()%>">update</a>
                        |
                        <a href="Controller?action=delete&id=<%=book.getId()%>">delete</a>
                </tr>
            <%
                         }
                   }
             %>
        </table>
    </body>
</html>
