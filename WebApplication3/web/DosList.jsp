<%-- 
    Document   : UnoList
    Created on : 12/05/2022, 01:56:02 PM
    Author     : Alumno
--%>

<%@page import="org.gerdoc.service.DosService"%>
<%@page import="org.gerdoc.dao.Dos"%>
<%@page import="org.gerdoc.dao.Uno"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.service.MySqlConnection1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            List<Dos>dosList = null;
            dosList = DosService.getDosList();
            if( dosList == null || dosList.size() == 0 )
            {
                System.out.println("Error base vacia");
                return;
            }
        %>
        <table BORDER="1">
            <tr>
                <td>
                    ID
                </td>
                <td>
                    CAMPO 1
                </td>
                <td>
                    CAMPO 2
                </td>
            </tr>
            <%
            for( Dos dos : dosList)
            {
            %>
            <tr>
                <td>
                    <%=dos.getId()%>
                </td>
                <td>
                    <%=dos.getCampo1()%>
                </td>
                <td>
                    <%=dos.getCampo2()%>
                </td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>
