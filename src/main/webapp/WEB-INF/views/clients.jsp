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
<a href="<c:url value="/clients/add"/>">Add</a>
<hr>
<c:forEach items="${clients}" var="client">
<div><b>${client.firstName} ${client.lastName}</b> <a href="<c:url value="/clients/edit/${client.id}"/>">Edit</a> <a href="<c:url value="/clients/delete/${client.id}"/>">Delete</a>  </div>
</c:forEach>

<hr>

</body>
</html>