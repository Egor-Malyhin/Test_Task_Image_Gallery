<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <form action="${pageContext.request.contextPath}/registry" method="post">
            <div class="form-group">
                <label for="nickname">Username:</label>
                <input type="text" id="username" name="username" value="${user.username}" required>
                <c:if test="${not empty usernameError}">
                    <div class="error">${usernameError}</div>
                </c:if>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" value="${user.password}" required>
            </div>
            <button type="submit">Register</button>
        </form>
    </div>
    <div>
         <a href="${pageContext.request.contextPath}/login">Login</a>
    <div>
</body>
</html>
