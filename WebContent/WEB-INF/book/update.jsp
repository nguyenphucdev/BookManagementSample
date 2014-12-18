
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpdateBook</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
   				
    <body>
    <h1 style="text-align:center">Update Book</h1>
         <form method="post" action="../book/update">
          <CENTER>
            <TABLE border="0"width="600px">
        <TR>
			<TD width="150px">ID:</TD>
			<TD>
                            <INPUT TYPE="text" readonly="readonly" NAME="id" value="<c:out value="${bean.id}"/>">
                        </TD>
                       
                </TR>
		<TR>
			<TD width="150px">Name:</TD>
			<TD>
                            <INPUT TYPE="text" NAME="name" value="<c:out value="${bean.name}"/>">
                        </TD>
                       
                </TR>
		<TR>
			<TD width="150px">Category:</TD>
			<TD>
                            <INPUT TYPE="text" NAME="category" value="<c:out value="${bean.category}"/>">
                        </TD>
                       
                </TR>
		<TR>
			<TD width="150px">Publisher</TD>
			<TD>
                            <INPUT TYPE="text" NAME="publisher" value="<c:out value="${bean.publisher}"/>">
                        </TD>
                        
                </TR>
		<TR>
			<TD width="150px">Price:</TD>
			<TD>
                            <INPUT TYPE="text" NAME="price" value="<c:out value="${bean.price}"/>">
                        </TD>
                        
                </TR>
         <TR>
			<TD width="150px">Summary:</TD>
			<TD>
                            <INPUT TYPE="text" NAME="summary" value="<c:out value="${bean.summary}"/>">
                        </TD>
                        
                </TR>
		<TR>
			<TD colspan="2" align="center">
                            <INPUT TYPE="submit" value="submit" name="action">
                        </TD>
                        
		</TR>
            </TABLE>
          </CENTER>
        </form>
    </body>
</html>
