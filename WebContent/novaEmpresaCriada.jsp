<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String nomeEmpresa = (String) request.getAttribute("empresa"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Empresa <%= nomeEmpresa %> criada.</h1>
</body>
</html>