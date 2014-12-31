<%-- 
    Document   : list
    Created on : Dec 31, 2014, 7:12:00 AM
    Author     : Keshav
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Vendor</title>
        <base href="<c:url value="/"/>"/>
    </head>
    <body>
        <h1>Vendors!</h1>
        
        <table id="tablelist">
            <tr><th>ID</th><th>Name</th><th>Email</th><th>Edit</th><th>Delete</th></tr>
        <c:forEach items="${vendors}" var="vendor">
                <tr><td>${vendor.id}</td><td>${vendor.vendorName}</td><td>${vendor.email}</td><td><a href="vendor/edit/${vendor.id}">Edit</a></td><td><a href="vendor/delete/${vendor.id}">Delete</a></td></tr>
        </c:forEach>
        </table>
        
        <a href="vendor/form">Add New Vendor</a>
    </body>
</html>
