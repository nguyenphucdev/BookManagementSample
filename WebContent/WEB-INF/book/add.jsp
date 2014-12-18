
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpdateBook</title>
    </head>
   				
    <body>
    <h1 >Add New Book</h1>
         <form method="post" action="../book/add">
          <CENTER>
            <TABLE border="0"width="600px">
        
		<TR>
			<TD width="150px">Name:</TD>
			<TD>
                            <INPUT TYPE="text" NAME="name" value=""/>
                        </TD>
                       
                </TR>
		<TR>
			<TD width="150px">Category:</TD>
			<TD>
                            <INPUT TYPE="text" NAME="category" value=""/>
                        </TD>
                       
                </TR>
		<TR>
			<TD width="150px">Publisher</TD>
			<TD>
                            <INPUT TYPE="text" NAME="publisher" value=""/>
                        </TD>
                        
                </TR>
		<TR>
			<TD width="150px">Price:</TD>
			<TD>
                            <INPUT TYPE="text" NAME="price" value=""/>
                        </TD>
                        
                </TR>
         <TR>
			<TD width="150px">Summary:</TD>
			<TD>
                            <INPUT TYPE="text" NAME="summary" value="">
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
