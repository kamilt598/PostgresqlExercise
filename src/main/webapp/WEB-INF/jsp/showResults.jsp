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
    <h1>Rekordy powtarzające się</h1>
    <c:forEach items="${duplicateIndexes}" var="duplicate">
        <tr style="border: 1px solid black">
            <td style="border: 1px solid black">${duplicate}</td>
        </tr>
    </c:forEach>
</table>
<br>
<h1>Rekordy unikalne</h1>
<table style="border: 1px solid black">
    <c:forEach items="${uniqueIndexes}" var="unique">
        <tr style="border: 1px solid black">
            <td style="border: 1px solid black">${unique}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
