
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Management Site</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
    
      <h1>Books Management Site</h1>
        <a href="<%=request.getContextPath()%>/book/add">Add new</a>
        
        <table width="100%"border="1">
        	<tbody>
           	 
           		 <tr>
            		<th>id</th>
               		<th>Name</th>
               		<th>Category</th>
               		<th>publisher</th>
               		<th>price</th>
               		<th>summary</th>
               		<th>Action</th>
               		
           		 </tr>
						<c:forEach items="${requestScope.books}" var="emp">
				<tr>
						<td><a href="<%=request.getContextPath()%>/book/update?id=${emp.id}"><c:out value="${emp.id}"></c:out></a></td>
						<td><c:out value="${emp.name}"></c:out></td>
						<td><c:out value="${emp.category}"></c:out></td>
						<td><c:out value="${emp.publisher}"></c:out></td>
						<td><c:out value="${emp.price}"></c:out></td>
						<td><c:out value="${emp.summary}"></c:out></td>
						<td><a href="<%=request.getContextPath()%>/book/deleted?id=${emp.id}">Deleted</a></td>
				</tr>
				</c:forEach>
		</tbody>
        </table>
    </body>
</html>
