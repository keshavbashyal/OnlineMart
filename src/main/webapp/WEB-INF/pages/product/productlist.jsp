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
        <link rel="stylesheet" href="resources/css/style.css"/>
    </head>
    <body>
        <%@include file="../includes/header.jsp" %>
        <div class="container min-height-4">
            <div class="content">
                <div class="page-header">
                    <h3>Product List</h3>
                </div>

                

                <table id="tablelist" class="span12 table-bordered table-striped">
                    <tr class="">
                        <th>ID</th>
                        <th>Product Name</th>
                        <th>Product Description</th>
                        <th>Unit Price</th>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.productName}</td>
                            <td>${product.productDescription}</td>
                            <td>${product.unitPrice}</td>
                            
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>
