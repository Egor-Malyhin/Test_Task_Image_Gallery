<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style><%@include file="/WEB-INF/view/css/style.css"%></style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
            <c:if test="${not empty param.error}">
                <div class="error">Invalid username or password.</div>
            </c:if>
        </form>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/registry">Register</a>
    <div>
</body>
</html>