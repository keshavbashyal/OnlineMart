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
        <title>Message</title>
        <base href="<c:url value="/"/>"/>
        <link rel="stylesheet" href="resources/css/style.css"/>
    </head>
    <body>
        <%@include file="../includes/header.jsp" %>
        <div class="container min-height-4">
            <div class="content">
                <div class="page-header">
                    <h3>${creditcarderror}</h3>
                </div>

                <br/>
                
                </div>
        </div>
        <%@include file="../includes/footer.jsp" %>


    </body>


</html>
