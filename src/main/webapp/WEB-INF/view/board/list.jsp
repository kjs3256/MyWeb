<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body>
	<a href="<c:url value='/main'/>">메인</a>
	<c:if test="${authInfo == null}">
		<a href="<c:url value='/login'/>">로그인</a>
		<a href="<c:url value='/register/agree'/>">회원가입</a>
	</c:if>
	<c:if test="${authInfo != null}">
		<a href="<c:url value='/logout'/>">로그아웃</a>
	</c:if>
	<div style="padding:50px; margin:50px;">
		<table border="1">
			<tr>
				<th>NO</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="board" items="${boardList}" varStatus="loop">
				<tr>
					<td>${board.seq }</td>
					<td><a href="<c:url value='/board/read/${board.seq }'/>">
						${board.title }</a></td>
					<td>${board.nickname }</td>
					<td>${sdf.format(board.regdate) }</td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="<c:url value='/board/write'/>">새글</a>
</body>
</html>