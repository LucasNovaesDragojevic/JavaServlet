<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="entrada?acao=AlteraEmpresa" var="alteraEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro empresa</title>
</head>
<body>
	<c:import url="logout.jsp"/>
	<form action="${alteraEmpresa}" method="post">
		<input type="hidden" name="id" value="${empresa.id}">
		Nome: <input name="nome" value="${empresa.nome}">
		Data de abertura: <input name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
		<input type="submit">
	</form>
</body>
</html>