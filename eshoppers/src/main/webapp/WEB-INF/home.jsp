<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lokman.shoppingcart.dto.ProductDTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All products</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><c:out value="${product.name}"></c:out></td>
					<td><c:out value="${product.description}"></c:out></td>
					<td><c:out value="${product.price}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>