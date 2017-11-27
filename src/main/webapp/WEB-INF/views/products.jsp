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
<c:forEach items="${products}" var="product">
<div><u>${product.brand}</u> <b>${product.name}</b> <fmt:formatNumber value = "${product.price}" type = "currency"/> <a href="./edit/${product.id}">Edit</a> <a href="./delete/${product.id}">Delete</a>  </div>
</c:forEach>

<hr>

</body>
</html>