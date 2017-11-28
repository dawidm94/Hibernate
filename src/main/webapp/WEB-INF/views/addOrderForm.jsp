<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="order">
	Client: <form:select path="client" items="${clients}" itemValue="id" itemLabel="lastName"/>
	Product: <form:select path="product" items="${products}" itemValue="id" itemLabel="name"/>
	Amount: <form:input path="amount"/>
	<input type="submit">
</form:form>
</body>
</html>