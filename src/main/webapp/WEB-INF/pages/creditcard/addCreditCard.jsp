<%-- 
    Document   : addCreditCard
    Created on : Jan 6, 2015, 1:33:59 PM
    Author     : psubedi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Customer Registration</title>
        <meta charset="utf-8">
        <title>OnlineMart - Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <base href="<c:url value="/" />"/>
        <link href="resources/css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="../includes/header.jsp" %>
        <div class="container">
            <div class="content">
                <legend><h3>Add Credit Card for ${selected.fname}</h3></legend>
            </div>
            <div class="span12 userbox min-height-3">
               
            </div>

        </div>

        <%@include file="../includes/footer.jsp" %>
    </body>
</html>