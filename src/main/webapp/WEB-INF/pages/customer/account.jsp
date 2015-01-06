<%-- 
    Document   : Account page
    Created on : Jan 3, 2015, 8:45:46 PM
    Author     : s_paw_000
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
        <div class="container min-height-4">
            <div class="content">
                <div class="row">
                    <div class="span3">
                        <div class="thumbnail">
                            <img src="resources/img/user-male.svg" alt="Customer Image" />
                        </div>
                        <%@include file="customer_left_nav.jsp" %>
                    </div>

                    <div class="span9 pull-right">
                        <div class="page-header">
                            <h3>Customer &rsaquo; Account</h3>
                        </div>
                        <h4>${selected.fname} ${selected.lname}</h4>
                        <h4>${selected.email}</h4>
                        <h4>${selected.phone}</h4>
                        <h4>${selected.address.street}</h4>
                        <h4>${selected.address.city}</h4>
                        <div class="page-header">
                            <h3>Recent Orders</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>

    </body>
</html>