<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2><spring:message code="term"/></h2>
	<h1>약관 내용</h1>
	<p>제 1 장 환영합니다!</p>
	<p>제 1 조 목적 및 정의</p>
	<p>진수가 제공하는 서비스를 이용해 주셔서 감사합니다. 진수는 여러분이 진수가 제공하는 다양한 인터넷 서비스 의미하며</p>
	<p>·············중략</p>
	<p>여러분은 본 약관에 동의함으로써 통합서비스에 가입하여 통합서비스를 이용할 이용조건 및 절차 등 </p>
	<p>기본적인 사항을 규정하고 있으므로 조금만 시간을 내서 주의 깊게 읽어주시기 바랍니다.</p>
	<form action="regist" method="post">
		<label>
			<input type="checkbox" name="agree" value="true">
			<spring:message code="term.agree"/>
		</label>
		<input type="submit" value="<spring:message code="next.btn"/>">
	</form>
</body>
</html>