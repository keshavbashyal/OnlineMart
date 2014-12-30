<%-- 
    Document   : somepage
    Created on : Dec 30, 2014, 4:17:45 PM
    Author     : KBashyal
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

    <form:form method="post" action="somepage" commandName="guest">
        <table>
            <tr>
                <td>name</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Description</td>
                <!--Notice, this is normal html tag, will not be bound to an object -->
                <td><input name="description" type="text"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="send"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
