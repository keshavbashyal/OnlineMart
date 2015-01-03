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
        <div class="container min-height-4">
            <div class="content">
                <div class="page-header">
                    <h3>Customers List</h3>
                </div>
                <table id="tablelist" class="span12 table-bordered table-striped">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
                    <c:forEach items="${allcustomers}" var="customers">
                        <tr>
                            <td>${customers.fname}</td>
                            <td>${customers.lname}</td>
                            <td>${customers.email}</td>
                            <td>${customers.phone}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="span12">
                    <a href="customer/addCustomer" class="btn btn-success pull-right">Add New Customer</a>
                </div>
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>
