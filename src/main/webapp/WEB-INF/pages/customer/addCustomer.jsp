<%-- 
    Document   : addCustomer
    Created on : Dec 30, 2014, 7:50:19 AM
    Author     : Keshav
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
        <div class="container">
            <div class="content">
                <legend><h3>Customer Registration</h3></legend>
            </div>
            <div class="pull-left">
                <div class="span8 thumbnail">
                    <img src="resources/img/customer.jpg" alt="Customer Image" />
                </div>
            </div>
            <div class="span4 pull-right">
                <spring:form method="post" action="customer/save" modelAttribute="customer">
                    <spring:errors element="div" cssClass="errors" path="*"/>
                    <spring:input type="hidden" path="id"/>

                    <table>
                        <tr>
                            <td><label>First Name </label></td>
                            <td><spring:input path="fname" /></td>
                            <td><spring:errors path="fname" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>Last Name </label></td>
                            <td><spring:input path="lname" /></td>
                            <td><spring:errors path="lname" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>E-mail Address </label></td>
                            <td><spring:input path="email" /></td>
                            <td><spring:errors path="email" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>Password </label></td>
                            <td><form:password path="password" /></td>
                            <td><spring:errors path="password" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>Phone Number </label></td>
                            <td><spring:input path="phone" /></td>
                            <td><spring:errors path="phone" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>Steet Address </label></td>
                            <td><spring:input path="phone" /></td>
                            <td><spring:errors path="phone" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>City </label></td>
                            <td><spring:input path="phone" /></td>
                            <td><spring:errors path="phone" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>State </label></td>
                            <td><spring:input path="phone" /></td>
                            <td><spring:errors path="phone" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td><label>Zip </label></td>
                            <td><spring:input path="phone" /></td>
                            <td><spring:errors path="phone" element="div" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Submit" class="btn btn-primary pull-right"/>
                            </td>
                        </tr>
                    </table>
                </spring:form>
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>

    </body>
</html>
