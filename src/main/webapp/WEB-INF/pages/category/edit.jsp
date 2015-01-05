<%-- 
    Document   : list
    Created on : Jan 3, 2015, 11:16:47 AM
    Author     : psubedi
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <base href="<c:url value="/" />"/>
        <link rel="stylesheet" href="resources/css/style.css"/>
        <title>All Customers</title>
    </head>
    <body>
        <%@include file="../includes/header.jsp" %>
        <div class="container">
            <div class="content">
                <div class="page-header">
                    <h3>Edit ${selected.fname} ${selected.lname} </h3>
                    <spring:form method="post" action="customer/save" modelAttribute="selected">
                    <spring:errors element="div" cssClass="errors" path="*"/>
                    <spring:input type="hidden" path="id"/>

                    <table>
                        <tr>
                            <td><label>First Name </label></td>
                            <td><spring:input path="fname" /></td>
                            <td><spring:errors path="fname" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>Last Name </label></td>
                            <td><spring:input path="lname" /></td>
                            <td><spring:errors path="lname" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>E-mail Address </label></td>
                            <td><spring:input path="email" /></td>
                            <td><spring:errors path="email" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>Password </label></td>
                            <td><spring:input path="password" /></td>
                            <td><spring:errors path="password" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>Phone Number </label></td>
                            <td><spring:input path="phone" /></td>
                            <td><spring:errors path="phone" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Submit" class="btn btn-primary pull-right"/>
                            </td>
                        </tr>
                    </table>
                </spring:form>
                </div>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>
