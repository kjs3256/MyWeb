<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<c:if test="${empty authInfo }">
	<div>
		<nav>
			<ul>
				<li><a href="<c:url value='/board/list'/>">게시판</a></li>
				<li><a href="#">관리</a>
					<ul>
						<li><a href="<c:url value='/register/agree'/>">회원 가입</a></li>
						<li><a href="<c:url value='/login'/>">로그인</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
	<h2>환영 합니다.</h2>
	</c:if>
	<c:if test="${!empty authInfo }">
	<div>
		<nav>
			<ul>
				<li><a href="<c:url value='/board/list'/>">게시판</a></li>
				<li><a href="#">관리</a>
					<ul>
						<li><a href="<c:url value='/edit/changePassword'/>">[비밀번호 변경]</a></li>
						<li><a href="<c:url value='/logout'/>">[로그아웃]</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
	<p>${authInfo.nickname }님 환영합니다.</p>
	</c:if>
</body>
</html>