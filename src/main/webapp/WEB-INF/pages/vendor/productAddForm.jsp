<%-- 
    Document   : dashboard
    Created on : Jan 3, 2015, 10:45:44 AM
    Author     : PTamang
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
                        <h3>Vendor Account</h3>
                        <hr/>
                        <div class="thumbnail">
                            <img src="resources/img/vendor.jpg" alt="Vendor Avatar" height="50"/>
                        </div>
                        <br/>
                        <div class="">
                            <%@include file="vendor_left_nav.jsp" %>
                        </div>
                    </div>

                    <div class="span9">
                        <h5>Vendor &rsaquo; Products &rsaquo; Add Product</h5>
                        <div class="span6 pull-right">
                            <spring:form method="post" action="vendor/product/save" commandName="product" cssClass="pull-right">
                                <spring:errors element="div" cssClass="errors" path="*"/>
                                <spring:input type="hidden" path="id"/>
                                <table> 
                                <tr>
                                    <td><label>Product Name</label></td>
                                    <td><spring:input path="productName" /></td>
                                    <td><spring:errors path="productName" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Product Description</label></td>
                                    <td><spring:input path="productDescription" /></td>
                                    <td><spring:errors path="productDescription" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Unit Price</label></td>
                                    <td><spring:input path="unitPrice" /></td>
                                    <td><spring:errors path="unitPrice" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Images</label></td>
                              
                                    <td> <input type="file" name="file" path="imagename" size="50" />
                                         <td><spring:errors path="imagename" element="div" cssClass="error" /></td>
                                    <br />
                                
                                    </td>
                                </tr>


                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="Submit" class="btn btn-primary pull-right"/>
                                        <input type="button" value="Cancel" class="btn btn-success pull-right" />
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
            $("#date").attr('placeholder', 'Product Add Date');
        </script>
    </body>
</html>
