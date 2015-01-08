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
