<%-- 
    Document   : form
    Created on : Dec 31, 2014, 7:10:13 AM
    Author     : Keshav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="<c:url value="/"/>"/>
        <link rel="stylesheet" href="resources/css/styles.css"/>
    </head>
    <body>

        <h1>Vendor Page</h1>
        
        <spring:form method="post" action="vendor/save" commandName="vendor">
            <spring:errors element="div" cssClass="errors" path="*"/>
            <p>
            <spring:input type="hidden" path="id"/>
            <table> 
            <tr>
            <td><label>Vendor Name:</label></td>
            <td><spring:input path="vendorName" /></td>
            <td><spring:errors path="vendorName" element="div" cssClass="error" /></td>
            </tr>
            
            
            <tr>
            <td><label>Join Date:</label></td>
            <td><spring:input path="joinDate" /></td>
            <td><spring:errors path="joinDate" element="div" cssClass="error" /></td>
            </tr>           
             <tr>
            <td><label>Email:</label></td>
            <td><spring:input path="email" /></td>
            <td><spring:errors path="email" element="div" cssClass="error" /></td>
            </tr>
            
            
            <tr>
            <td><label>Password:</label></td>
            <td><spring:input path="password" /></td>
            <td><spring:errors path="password" element="div" cssClass="error" /></td>
            </tr>
            
            
            </table>
            </p>
            <p>
                <input type="submit" value="Submit"/>
            </p>
            
        </spring:form>
    </body>
</html>
