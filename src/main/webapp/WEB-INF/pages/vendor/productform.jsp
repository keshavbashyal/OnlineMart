<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="<c:url value="/"/>"/>
        <link rel="stylesheet" href="resources/css/style.css"/>
    </head>
    <body>
        <%@include file="../includes/header.jsp" %>
        <div class="container">
            <div class="content">
                <fieldset>
                    <legend><h3>Product Registration Form</h3></legend>
                    <div class="pull-left">
                        <div class="span7 thumbnail">
                            <img src="resources/img/vendor.jpg" alt="Vendor Image" />
                        </div>
                    </div>
                    <div class="span4 pull-right">
                        <spring:form method="post" action="product/save" commandName="product">
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
                                    <td><label>Sizes</label></td>
                                    <td><spring:input path="sizes" /></td>
                                    <td><spring:errors path="sizes" element="div" cssClass="error" /></td>
                                </tr>
                                 <tr>
                                    <td><label>Colors</label></td>
                                    <td><spring:password path="color" /></td>
                                    <td><spring:errors path="color" element="div" cssClass="error" /></td>
                                </tr>
                                 <tr>
                                    <td><label>Date</label></td>
                                    <td><spring:input path="addDate" /></td>
                                    <td><spring:errors path="addDate" element="div" cssClass="error" /></td>
                                </tr>
                                 <tr>
                                    <td><label>Images</label></td>
                                    <td><spring:input path="image" /></td>
                                    <td><spring:errors path="image" element="div" cssClass="error" /></td>
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
                </fieldset>
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>