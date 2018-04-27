<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="header">
	<h1>MySite</h1>
	<ul>

		<c:choose>
			<c:when test="${authUser eq null }">
				<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a>
				<li>
				<li><a href="${pageContext.request.contextPath}/user/joinform">회원가입</a>
			</c:when>

			<c:otherwise>
				<li>
				<li><a href="${pageContext.request.contextPath}/user/modifyform">회원정보수정</a>
				<li>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
				<li>
				<li>${authUser.name}님 안녕하세요 ^^2 </li>
			</c:otherwise>
		</c:choose>

	</ul>
</div>