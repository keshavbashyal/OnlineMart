<%-- 
    Document   : dashboard
    Created on : Jan 3, 2015, 10:45:44 AM
    Author     : PTamang
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>OnlineMart - Vendor - Dashboard</title>
        <base href="<c:url value="/" />"/>
        <link rel="stylesheet" href="resources/css/style.css"/>
    </head>
    <body>
        
        <%@include file="../includes/header.jsp" %>
        
        <div class="container min-height-4">
            <div class="content">
                <div class="row">
                    <div class="span3">
                        <%@include file="vendor_left_nav.jsp" %>
                    </div>
                    
                    <div class="span9">
                        <h3>Vendor &rsaquo; Products</h3>
                    </div>
                </div>
            </div>
        </div>
        
        <%@include file="../includes/footer.jsp" %>
        
    </body>
</html>
