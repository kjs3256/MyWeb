<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${boardVO.title }&nbsp;내용</title>
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
	<div>
		<div style="padding:50px; margin:50px;">
			<h2>${boardVO.title }</h2>
			<small>작성자 : ${boardVO.nickname } | 작성일 : ${sdf.format(boardVO.regdate) } | 조회 : ${boardVO.cnt } </small>
			<hr/>
			<div style="padding:20px; margin:20px;">
				${boardVO.content }
			</div>
		</div>
	</div>
	<div style="padding:20px; margin:20px;">
	<c:if test="${authInfo.nickname.equals(boardVO.nickname) }">
		<a href="<c:url value='/board/edit/${boardVO.seq }'/>">수정</a>
		<a href="<c:url value='/board/delete/${boardVO.seq }'/>">삭제</a>
	</c:if>
		<a href="<c:url value='/board/list'/>">목록</a>
	</div>
</body>
</html>