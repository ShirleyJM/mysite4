<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
	<title>Insert title here</title>
</head>
<body>

	<div id="container">
		
	<c:import url="../include/header.jsp"></c:import>
		
		<c:import url="../include/navigation.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content">
				<div id="user">
	
					<form id="join-form" name="joinForm" method="get" action="${pageContext.request.contextPath}/user/modify">

						<input type="hidden" name="no" value="${authUser.no}">
						<label class="block-label" for="name">이름</label>
						<input id="name" name="name" type="text" value="${modifyuser.name}" />
	
						<label class="block-label" for="email">이메일</label>
						<strong></strong>
						
						<label class="block-label">패스워드</label>
						<input name="password" type="password" value="${modifyuser.password}" />
						
						<fieldset>
							<legend>성별</legend>
							
							<label>여</label> <input type="radio" name="gender" value="female" ${modifyuser.gender eq 'female'?'checked':''}>
							<label>남</label> <input type="radio" name="gender" value="male" ${modifyuser.gender eq 'male'?'checked':''}>
							
						</fieldset>
						
						<input type="submit" value="수정완료">
						
					</form>
				</div><!-- /user -->
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
		<c:import url="../include/footer.jsp"></c:import>
		
		
	</div> <!-- /container -->

</body>
</html>
