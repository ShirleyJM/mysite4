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
		
		<div id="navigation">
			<ul>
				<li><a href="">황일영</a></li>
				<li><a href="">방명록</a></li>
				<li><a href="">게시판</a></li>
			</ul>
		</div> <!-- /navigation -->
		
		<div id="wrapper">
			<div id="content">
				<div id="guestbook" class="delete-form">
					
					<form method="" action="">
						
						<label>비밀번호</label>
						<input type="password" name="password">
						<input type="submit" value="확인">
					</form>
					<a href="">방명록 리스트</a>
					
				</div>
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
	<c:import url="../include/footer.jsp"></c:import>
		
	</div> <!-- /container -->

</body>
</html>
