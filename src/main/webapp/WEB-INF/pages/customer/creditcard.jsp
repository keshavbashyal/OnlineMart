<%-- 
    Document   : creditcard
    Created on : Jan 6, 2015, 4:33:17 PM
    Author     : psubedi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Customer Registration</title>
        <meta charset="utf-8">
        <title>OnlineMart - Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <base href="<c:url value="/" />"/>
        <link href="resources/css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="../includes/header.jsp" %>
        <div class="container min-height-4">
            <div class="content">
                <div class="row">
                    <div class="span3">
                        <div class="thumbnail">
                            <img src="resources/img/user-male.svg" alt="Customer Image" />
                        </div>
                        <%@include file="customer_left_nav.jsp" %>
                    </div>

                    <div class="span9 pull-right">
                        <div class="page-header">
                            <h3>Customer &rsaquo; Account &rsaquo; Add Credit Card</h3>
                        </div>
                        <spring:form method="post" action="customer/save" modelAttribute="customer" >
                            <spring:errors element="div" cssClass="errors" path="*"/>
                            <spring:input type="hidden" path="id"/>

                            <table>
                                <tr>
                                    <td><label>Card Number </label></td>
                                    <td><spring:input path="cardNo" /></td>
                                    <td><spring:errors path="cardNo" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Expiry Date : Year </label></td>
                                    <td><spring:input path="expYear" /></td>
                                    <td><spring:errors path="expYear" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Expiry Date : Month </label></td>
                                    <td><spring:input path="expMonth" /></td>
                                    <td><spring:errors path="expMonth" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>CCV Code </label></td>
                                    <td><spring:input path="ccv" /></td>
                                    <td><spring:errors path="ccv" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><label>Credit Card Type </label></td>
                                    <td><spring:input path="type" /></td>
                                    <td><spring:errors path="type" element="div" cssClass="error" /></td>
                                </tr>

                            </table>
                        </spring:form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>
