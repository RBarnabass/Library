<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <h3>Please enter login and password</h3>
    <p style="color: red;">${errorString}</p>

    <form method="POST" action="${pageContext.request.contextPath}/user">

        <%--<input type="hidden" name="redirectId" value="${param.redirectId}" />--%>
        <table border="0">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" value="${user.login}"/></td>
            </tr>

            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value="${user.password}"/></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                    <a href="${pageContext.request.contextPath}/">Cancel</a>
                </td>
            </tr>
        </table>

    </form>
</div>
