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

        <div class="container">
            <div class="content">
                <div class="span12 userbox min-height-3">
                    <div class="span6 pull-left">
                        <div class="page-header">
                            <h3> Customer Information </h3>
                        </div>
                        <div class="span3 pull-right">
                            <h3>${customer.fname} ${customer.lname}</h3>
                            <h3>${customer.email}</h3>
                            <h3>${customer.phone}</h3>
                        </div>
                        <div class="pull-left">
                            <div class="span3 thumbnail thumbnail-noborder">
                                <img src="resources/img/user-male.svg" alt="Customer Image" />
                            </div>
                        </div>
                    </div>
                    <div class="span3 pull-right">
                        <div class="page-header">
                            <h3> Add Information </h3>
                        </div>
                        <a href="#">Update Profile</a><br/>
                        <a href="#">Add Credit Card</a><br/>
                        <a href="#">Update Address</a><br/>
                        <a href="#">Customer Support</a><br/>
                    </div>
                </div>
                <div class="span12 userbox min-height-4">
                    <div class="page-header">
                        <h3> Recent Purchases </h3>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../includes/footer.jsp" %>

    </body>
</html>