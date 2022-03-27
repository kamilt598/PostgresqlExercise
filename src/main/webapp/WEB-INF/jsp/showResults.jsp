<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<table style="border: 1px solid black">
    <c:forEach items="${indexes}" var="index">
        <tr style="border: 1px solid black">
            <td style="border: 1px solid black">${index}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
