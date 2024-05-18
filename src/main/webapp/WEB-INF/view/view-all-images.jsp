<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>All Images</title>
   </head>
   <body>
      <h2>Images</h2>
      <div id="imageContainer">
         <c:set var="counter" value="1"/>
         <c:forEach items="${images}" var="image">
            <div>
               ${counter} - ${image.name} - ${image.user.username} - <img src="data:image/jpeg;base64,${image.imageData}" alt="${image.name}" style="width:100px;height:100px;">
               <sec:authorize access="hasRole('ROLE_ADMIN')">
                  <form action="/image-gallery/all-images?id=${image.id}" method="post">
                     <input type="submit" value="Delete">
                  </form>
               </sec:authorize>
            </div>
            <c:set var="counter" value="${counter + 1}"/>
         </c:forEach>
      </div>
      <div class="pagination">
         <c:if test="${currentPage > 1}">
            <a href="all-images?page=${currentPage - 1}">Previous</a>
         </c:if>
         Page ${currentPage} of ${totalPages}
         <c:if test="${currentPage < totalPages}">
            <a href="all-images?page=${currentPage + 1}">Next</a>
         </c:if>
         <span>Pages:</span>
         <c:forEach begin="1" end="${totalPages}" var="pageNumber">
            <c:choose>
               <c:when test="${pageNumber == currentPage}">
                  <span>${pageNumber}</span>
               </c:when>
               <c:otherwise>
                  <a href="all-images?page=${pageNumber}">${pageNumber}</a>
               </c:otherwise>
            </c:choose>
            <c:if test="${pageNumber < totalPages}"> </c:if>
         </c:forEach>
      </div>
      <div>
         <a href="${pageContext.request.contextPath}/upload">Upload</a>
         <a href="${pageContext.request.contextPath}/my-images">My Images</a>
      </div>
   </body>
</html>
