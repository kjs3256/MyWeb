<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새글 쓰기</title>
</head>
<body>
<div style="margin-top:30px;">
	<form:form commandName="boardVO" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="title">제목</form:label></th>
				<td><form:input path="title"/>
				<form:errors path="title"/></td>
			</tr>
			<tr>
				<th><form:label path="content">내용</form:label></th>
				<td><form:textarea placeholder="내용" name="content" maxlength="2048" style= "resize:none; height:350px;" path="content"/>
				<form:errors path="content"/></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록">
			<a href="<c:url value='/board/list'/>">목록</a>
		</div>
	</form:form>
</div>
</body>
</html>