<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Picture</title>
    <style><%@include file="/WEB-INF/view/css/style.css"%></style>
    <script type="text/javascript">
        function encodeImageFileAsURL() {
            var fileInput = document.getElementById('file');
            var file = fileInput.files[0];
            var reader = new FileReader();
            reader.onloadend = function() {
                document.getElementById('imageBase').value = reader.result.split(',')[1];
            }
            reader.readAsDataURL(file);
        }
    </script>
</head>
<body>
    <h1>Upload a Picture</h1>
    <form:form modelAttribute="image" action="/image-gallery/upload" method="post">
        <div>
            <form:label path="name">Picture Name:</form:label>
            <form:input path="name" id="name" value="${image.name}" required="true"/>
        </div>
        <div>
            <label for="file">Choose a file:</label>
            <input type="file" id="file" accept="image/*" required onchange="encodeImageFileAsURL()">
        </div>
        <div>
            <form:hidden path="imageData" id="imageBase" value="${image.imageData}"/>
        </div>
        <div>
            <button type="submit">Upload</button>
        </div>
    </form:form>
    <div>
         <a href="${pageContext.request.contextPath}/all-images">All Images</a>
         <a href="${pageContext.request.contextPath}/my-images">My Images</a>
         <form action="${pageContext.request.contextPath}/logout" method="post">
              <button type="submit">Logout</button>
         </form>
    </div>
</body>
</html>