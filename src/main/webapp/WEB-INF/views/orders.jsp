<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./add">Add</a>
<hr>
<c:forEach items="${orders}" var="order">
<div><b>Client: ${order.client.lastName}</b>, product: ${order.product.name} <a href="./edit/${order.id}">Edit</a> <a href="./delete/${order.id}">Delete</a>  </div>
</c:forEach>

<hr>

</body>
</html>