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


                <ul class="product">
                    
                    <c:forEach items="${products}" var="product">
                    <li>
                        <a href="<c:url value="/product/${product.id}/productdetail"/>">
                            <img src="resources/img/sample/women1.jpg" alt="" />	
                            <div class="producttitlebox"></div>
                            <div class="producttitle">${product.productName}</div>
                            <div class="brandtitle">By: Brand Name</div>
                            <div class="pricetag"></div>
                            <div class="saleprice">${product.unitPrice}</div>
                            <div class="oldprice">${product.unitPrice}</div>
                        </a>
                    </li>
                    
                    </c:forEach>
                </ul>
      
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>
