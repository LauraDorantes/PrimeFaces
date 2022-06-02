<%-- 
    Document   : UnoList
    Created on : 12/05/2022, 01:56:02 PM
    Author     : Alumno
--%>

<%@page import="org.gerdoc.service.UnoService"%>
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
            List<Uno>unoList = null;
            unoList = UnoService.getUnoList();
            if( unoList == null || unoList.size() == 0 )
            {
                System.out.println("Error base vacia");
                return;
            }
        %>
        <table>
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
                <td>
                    CAMPO 3
                </td>
                <td>
                    CAMPO 4
                </td>
            </tr>
            <%
            for( Uno uno : unoList)
            {
            %>
            <tr>
                <td>
                    <%=uno.getId()%>
                </td>
                <td>
                    <%=uno.getCampo1()%>
                </td>
                <td>
                    <%=uno.getCampo2()%>
                </td>
                <td>
                    <%=uno.getCampo3()%>
                </td>
                <td>
                    <%=uno.getCampo4()%>
                </td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>
