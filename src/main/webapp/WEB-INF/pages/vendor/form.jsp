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
                    <legend><h3>Vendor Registration Form</h3></legend>
                    <div class="pull-left">
                        <div class="span7 thumbnail">
                            <img src="resources/img/vendor.jpg" alt="Vendor Image" />
                        </div>
                    </div>
                    <div class="span4 pull-right">
                        <spring:form method="post" action="vendor/save" commandName="vendor" cssClass="pull-right">
                            <spring:errors element="div" cssClass="errors" path="*"/>
                            <spring:input type="hidden" path="id"/>
                            <table> 
                                <tr>
                                    <td><spring:input path="vendorName" id="name"/></td>
                                    <td><spring:errors path="vendorName" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><spring:input path="email" id="email"/></td>
                                    <td><spring:errors path="email" element="div" cssClass="error" /></td>
                                </tr>
                                
                              
                                <tr>
                                    <td><spring:password path="password" id="pass"/></td>
                                    <td><spring:errors path="password" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td><spring:password path="repassword" id="repass"/></td>
                                    <td><spring:errors path="password" element="div" cssClass="error" /></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="reset" onclick="" value="Reset" class="btn btn-success" />
                                        <input type="submit" value="Sign Up" class="btn btn-primary"/>
                                    </td>
                                </tr>
                            </table>
                        </spring:form>
                    </div>
                </fieldset>
            </div>
        </div>
        <%@include file="../includes/footer.jsp" %>
        <script>
            $("#name").attr('placeholder', 'First Name');
            $("#email").attr('placeholder', 'Email');
            $("#pass").attr('placeholder', 'Password');
            $("#repass").attr('placeholder', 'Retype Password');
        </script>
    </body>
</html>
