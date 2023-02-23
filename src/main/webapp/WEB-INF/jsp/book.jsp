<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

    <c:forEach items="${books}" var="book">
        <c:if test="${book.year >= 2000}">
            ${book.title} <br>
            ${book.year} <br>
        </c:if>
    </c:forEach>
</body>
</html>
