<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>OnlineMart - Login page</title>
        <base href="<c:url value="/" />"/>
        <link href="resources/css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="includes/header.jsp" %>

        <div class="container min-height-4">
            <div class="row">
                <div class="col-md-4">
                    <h5 class="text-center"> Login </h5>
                    
                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Error 001: Login error<br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
</c:if>
      
      
                         <c:if test="${param.error eq 'pending'}">
      <font color="red">
        
        <c:out value="This vendor Account is still pending, please contact administrator"/>.
      </font>
</c:if>
                    
                    <form name='loginForm' action="<c:url value='j_spring_security_check' />" class="form-horizontal form-control"
                          method='POST'>
                                     
                        <table>
                            <tr>
                                <td>Email</td>
                                <td>
                                    <input type="text" name="username" class="form-control"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" name="password"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input type="submit" value="Login" class="btn btn-primary pull-right"/>
                                </td>
                            </tr>
                        </table>

                    </form>
                </div>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
