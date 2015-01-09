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
        <title>OnlineMart - Vendor - Product Edit Form</title>
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
                        <h5>Vendor &rsaquo; Dashboard &rsaquo; Edit Product</h5>
                        <br>
                        <div class="span9 pull-right">
                            <spring:form id="productAddForm"  method="post" action="vendor/editProduct" commandName="product" enctype="multipart/form-data" class="pull-right">
                                <spring:errors element="div" cssClass="errors" path="*"/>
                                <spring:input type="hidden" path="id"/>
                                <table class="pull-right"> 
                                    <tr>
                                        <td>Category</td>
                                        <td>
                                            <spring:select path="categoryId"  required="true">
                                                <spring:option value="" label="--Select Category"></spring:option>
                                                <c:forEach items="${categories}" var="category">
                                                    <spring:option value="${category.id}" label="${category.categoryName}"></spring:option>
                                                </c:forEach>
                                            </spring:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Name</td>
                                        <td><spring:input path="productName" id="name" cssClass="input-xxlarge" required="true"/></td>
                                        <td><spring:errors path="productName" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td>Description</td>
                                        <td><spring:textarea path="productDescription" id="desc" cssClass="input-xxlarge" maxlength="200"/></td>
                                        <td><spring:errors path="productDescription" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td>Price</td> 
                                        <td><spring:input path="unitPrice" id="price" cssClass="input-xxlarge" required="true"/></td>
                                        <td><spring:errors path="unitPrice" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td>Color</td>
                                        <td>
                                            <spring:select path="color" id="color"  required="true">
                                                <spring:option value="" label="--Select Color"/>
                                                <spring:options items="${enum_color}"/>
                                            </spring:select>
                                        </td>
                                        <td><spring:errors path="color" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td>Size</td>
                                        <td>
                                            <spring:select path="sizes" id="size"  required="true">
                                                <spring:option value="" label="--Select Size"/>
                                                <spring:options items="${enum_size}"/>
                                            </spring:select>
                                        </td>
                                        <td><spring:errors path="sizes" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td>Date</td>
                                        <td><spring:input path="addDate" required="true" disabled="true"/></td>
                                        <td><spring:errors path="addDate" element="div" cssClass="error" /></td>
                                    </tr>
                                    <tr>
                                        <td>Images</td>
                                        <td><input type="file" name="file" /></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td colspan="2">
                                            <input type="submit" value="Save Product" class="btn btn-success"/>
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
                //$("#datepicker").datepicker({dateFormat: 'mm-dd-yy'});
                $("#productAddForm").validate();
            });
        </script>
    </body>
</html>
