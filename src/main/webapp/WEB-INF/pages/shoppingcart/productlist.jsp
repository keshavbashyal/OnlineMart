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
                         <th></th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach items="${shoppingCart.productShoppingCart}" var="productShoppingCart">
                        <tr>
                            <td>${productShoppingCart.id}</td>
                            
                            <td>${productShoppingCart.getProduct().productName}</td>
                            <td>${productShoppingCart.getProduct().productDescription}</td>
                            <td>${productShoppingCart.getProduct().unitPrice}</td>
                            <td>${productShoppingCart.quantity}</td>
                            
                            <td>
                                <a href="vendor/product/edit/${product.id}" class="btn btn-primary btn-mini">Edit</a>
                                <a href="vendor/product/delete/${product.id}" onclick="return confirm(' Delete Record ')" class="btn btn-danger btn-mini">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                    <a href="<c:url value="/shoppingcart/checkout/" />"  class="btn btn-danger btn-large"><i class="icon-shopping-cart icon-white"></i>  Check out</a>
                                
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>
