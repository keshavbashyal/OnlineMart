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
                        <div class="thumbnail">
                            <img src="resources/img/vendor.jpg" alt="Vendor Avatar" height="50"/>
                        </div>
                        <br/>
                        <div class="">
                            <%@include file="vendor_left_nav.jsp" %>
                        </div>
                    </div>

                    <div class="span9 pull-right">
                        <div class="${errType}">${msg}</div>
                        <div class="span3 pull-right">
                            <a href="<c:url value="vendor/productaddfrm" />" class="btn btn-success pull-right">Add Product</a>
                        </div>
                        <h5>Vendor &rsaquo; Dashboard</h5>
                        <table id="tablelist" class="span9 table-bordered table-striped pull-right">
                            <tr class="">
                                <th>#</th>
                                <th>Product Name</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Color</th>
                                <th>Added Date</th>
                                <th>Options</th>
                            </tr>
                            <c:forEach items="${products}" var="product">
                                <tr>
                                    <td>${product.id}</td>
                                    <td>${product.productName}</td>
                                    <td>${product.productDescription}</td>
                                    <td>${product.unitPrice}</td>
                                    <td>${product.color}</td>
                                    <td>${product.addDate}</td>
                                    <td>
                                        <a href="vendor/editProduct/${product.id}" class="btn btn-primary btn-mini">Edit</a>
                                        <a href="vendor/deleteProduct/${product.id}" onclick="return confirm(' Delete Product? ')" class="btn btn-danger btn-mini">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../includes/footer.jsp" %>

    </body>
</html>
