<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<form method="get" action='<c:url value="/showResults"/>'>
    <select name="choosen">
        <option value="kolumna1">kolumna1</option>
        <option value="kolumna2">kolumna2</option>
        <option value="kolumna3">kolumna3</option>
        <option value="kolumna4">kolumna4</option>
    </select>
    <button type="submit">Wybierz</button>
</form>
</body>
</html>
