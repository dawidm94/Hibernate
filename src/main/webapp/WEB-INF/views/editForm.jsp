<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../edit2" method="post">
	Name: <input type="text" name="name" value="${product.name}">
	Price: <input type="text" name="price" value="${product.price}">
	<input type="hidden" name="id" value="${product.id}">
	<select name="brandId">
		<c:forEach items="${brands}" var="brand">
			<option value="${brand.id}">${brand}</option>
		</c:forEach>
	</select>
	<input type="submit">
</form>
</body>
</html>