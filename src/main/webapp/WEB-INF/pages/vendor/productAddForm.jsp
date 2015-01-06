<%-- 
    Document   : dashboard
    Created on : Jan 3, 2015, 10:45:44 AM
    Author     : PTamang
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>OnlineMart - Vendor - Product Add Form</title>
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
                        <h5>Vendor &rsaquo; Dashboard &rsaquo; Add Product</h5>
                        <br>
                        <div class="span9 pull-right">
                            <spring:form method="post" action="vendor/addProduct" commandName="product" enctype="multipart/form-data" class="pull-right">
                                <spring:errors element="div" cssClass="errors" path="*"/>
                                <spring:input type="hidden" path="id"/>
                                <table> 
                                    <tr>
                                        <td><spring:input path="productName" id="name" cssClass="input-xxlarge" /></td>
                                        <td><spring:errors path="productName" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td><spring:textarea path="productDescription" id="desc" cssClass="input-xxlarge"/></td>
                                        <td><spring:errors path="productDescription" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td><spring:input path="unitPrice" id="price" cssClass="input-xxlarge" /></td>
                                        <td><spring:errors path="unitPrice" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <spring:select path="color" id="color">
                                                <spring:option value="" label="--Select Color"/>
                                                <spring:options items="${enum_color}"/>
                                            </spring:select>
                                        </td>
                                        <td><spring:errors path="color" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <spring:select path="sizes" id="size">
                                                <spring:option value="" label="--Select Size"/>
                                                <spring:options items="${enum_size}"/>
                                            </spring:select>
                                        </td>
                                        <td><spring:errors path="sizes" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td><spring:input path="addDate" id="datepicker"/></td>
                                        <td><spring:errors path="addDate" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <input type="reset" value="Reset" class="btn btn-danger" />
                                            <input type="submit" value="Add Product" class="btn btn-success"/>
                                        </td>
                                    </tr>
                                </table>
                            </spring:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../includes/footer.jsp" %>
        <script>
            $("#name").attr('placeholder', 'Product Name');
            $("#desc").attr('placeholder', 'Product Description');
            $("#price").attr('placeholder', 'Product Unit Price');
            $("#size").attr('placeholder', 'Product Size');
            $("#color").attr('placeholder', 'Product Color');
            $("#datepicker").attr('placeholder', 'Select Date');
        </script>
        <link rel="stylesheet" href="resources/css/jquery-ui.css">
        <script src="resources/js/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({dateFormat: 'mm-dd-yy' });
            });
        </script>
    </body>
</html>
