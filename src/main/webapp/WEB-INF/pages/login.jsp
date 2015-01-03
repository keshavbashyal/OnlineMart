<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Login page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
          
<form name='loginForm' action="<c:url value='j_spring_security_check' />"
method='POST'>
             
            <table>
                <tr>
                    <td>Email</td>
                    <td>
                        
                        <input type="text" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit"/>
                    </td>
                </tr>
            </table>
            
        </form>
        
    </body>
</html>
