<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2><spring:message code="member.info"/></h2>
	<form:form action="welcome" commandName="formData">
		<p>
			<label><spring:message code="id"/><br>
			<form:input path="id"/>
			<form:errors path="id"/>
			</label>
		</p>
		<p>
			<label><spring:message code="nickname"/><br>
			<form:input path="nickname"/>
			<form:errors path="nickname"/>
			</label>
		</p>
		<p>
			<label><spring:message code="password"/><br>
			<form:password path="password"/>
			<form:errors path="password"/>
			</label>
		</p>
		<p>
			<label><spring:message code="password.confirm"/><br>
			<form:password path="confirmPassword"/>
			<form:errors path="confirmPassword"/>
			</label>
		</p>
		<input type="submit" value="<spring:message code="register.btn"/>">
	</form:form>
</body>
</html>