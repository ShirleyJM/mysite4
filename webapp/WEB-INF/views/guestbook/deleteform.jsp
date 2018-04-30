<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
	<title>Insert title here</title>
</head>
<body>
	<div id="container">
		
	<c:import url="../include/header.jsp"></c:import>
		
		<c:import url="../include/navigation.jsp"></c:import>
		
	
		<div id="wrapper">
			<div id="content">
				<div id="guestbook" class="delete-form">
					
					<form method="Get" action="${pageContext.request.contextPath}/guestbook/delete">
						
						<label>비밀번호</label>
						<input type="password" name="password">
						<input type="hidden" name="no" value="${param.no}">
						<input type="submit" value="확인">
					</form>
					<a href="${pageContext.request.contextPath}/guestbook/list">방명록 리스트</a>
					
				</div>
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
	<c:import url="../include/footer.jsp"></c:import>
		
	</div> <!-- /container -->

</body>
</html>
