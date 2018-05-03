<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>


</head>


<!-- 삭제팝업(모달)창 -->
<div class="modal fade" id="del-pop">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">방명록삭제</h4>
			</div>

			<div class="modal-body">
				<label>비밀번호</label> <input type="password" name="modalPassword"
					value="" id="modalPassword"><br> <label>방명록번호</label><input
					type="text" name="modalPassword" value="" id="modalNo"> <br>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-danger" id="btn_del">삭제</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<body>

	<div id="container">

		<c:import url="../include/header.jsp"></c:import>
		<c:import url="../include/navigation.jsp"></c:import>

		<div id="wrapper">
			<div id="content">
				<div id="guestbook">
					<!-- 이름, 비밀번호 가지고 감. -->

					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" /></td>
							<td>비밀번호</td>
							<td><input type="password" name="password" /></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input id="btnAdd" type="button"
								VALUE=" 확인 " /></td>
						</tr>
					</table>
					<!-- <input id="btnModal" type="button" value="삭제창"/>
					 -->

					<ul id="guestbook-list">
						<!-- 박명록 리스트 -->
					</ul>

				</div>
				<!-- /guestbook -->
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<c:import url="../include/footer.jsp"></c:import>

	</div>
	<!-- /container -->

</body>
<script type="text/javascript">
	$(document).ready(function() {
		fetchList();

	});

	$("#btnModal").on("click", function() {
		console.log("모달");
		$("#del-pop").modal();	
	});
	
	$("#btnAdd").on("click", function() {
		console.log("btnAdd");
		var name = $("[name=name]").val();
		var password = $("[name=password]").val();
		var content = $("[name=content]").val();
		console.log(name);
		console.log(password);
		console.log(content);

		//1. list 요청 ajax 
		$.ajax({

			url : "${pageContext.request.contextPath }/api/gb/add",
			type : "post",
			/* contentType : "application/json", */
			data : {
				name : name,
				password : password,
				content : content
			},

			dataType : "json",
			success : function(GuestbookVo) {
				/*성공시 처리해야될 코드 작성*/
				render(GuestbookVo, "up");
				$("[name=name]").val("");
				$("[name=password]").val("");
				$("[name=content]").val("");

			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});

	});

	function fetchList() {
		//1. list 요청 ajax 
		$.ajax({

			url : "${pageContext.request.contextPath }/api/gb/list",
			type : "get",
			/* contentType : "application/json", */
			/* data : {name:"홍길동"}, */

			dataType : "json",
			success : function(list) {
				/*성공시 처리해야될 코드 작성*/
				console.log(list);
				for (var i = 0; i < list.length; i++) {
					render(list[i], "up");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});

	};

	function render(guestbookVo, updown) {
		var str = "";
		str += "<li id='"+guestbookVo.no+"'>";
		str += "<table>";
		str += "     <tr>";
		str += "            <td>[" + guestbookVo.no + "]</td>";
		str += "            <td>" + guestbookVo.name + "</td>";
		str += "            <td>" + guestbookVo.reg_date + "</td>";
		str += "            <td><input type='button' class='ModalNo' id='"+guestbookVo.no+"' value='삭제'></input></td>";
		str += "		</tr>";
		str += "		<tr>";
		str += "      <td colspan=4>";
		str += "    " + guestbookVo.content + "<br>";
		str += "          </td> "
		str += "       </tr>"
		str += "  </table>";
		str += "	 <br>";
		str += "</li>";

		if (updown == "up") {
			$("#guestbook-list").prepend(str);
		} else if (updown == "down") {
			$("#guestbook-list").append(str);
		} else {
			console.log("error");
		}

	}
	
	$("ul").on("click","input", function(){
		$("#del-pop").modal();	
		//값을 뿌려주기
		var dom= $(this);	
		var ModalNo= dom.attr("id")
		console.log(ModalNo);
	  	$("#modalNo").val(ModalNo);

	});
	
	
	$("#btn_del").on("click",function(){
		
		
		var password =$("#modalPassword").val();
		var no =$("#modalNo").val();
		
		//비밀번호와 게시글번호를 가지고
		
		
		//1. list 요청 ajax 
	$.ajax({
		//DB에 가는 방법과 정보를 셋팅해준다
		url : "${pageContext.request.contextPath }/api/gb/delete2",
		type : "post",
		/* contentType : "application/json", */
		data : {
			no : no,
			password : password
		},
		//컨트롤러,서비스,다오를 거쳐
		//db에 간다
		//이건 자동이다
		
		dataType : "json",
		success : function(del) {
			/*성공시 처리해야될 코드 작성*/
			//뭔가를 가지고 와야해
			
		//값을 가지고 오면 해당하는 번호의 게시물을 삭제한다
		//삭제방법은 .remove();
				
		$("[id="+del+"]").remove();
		
		$("#modalPassword").val("");
	},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	
	})
	//창 닫기
	$("#del-pop").modal("hide");
	}); 
		
		
		
		$("#write-form").on("submit",function(){
			event.preventDefault();
			var name= $("[name='name']").val();
			var password= $("[name='password']").val();
			var content= $("[name='content']").val();
			
	
			
			//1. list 요청 ajax 
			$.ajax({
				//DB에 가는 방법과 정보를 셋팅해준다
				url : "${pageContext.request.contextPath }/api/gb/add",
				type : "post",
				contentType : "application/json", 
				dataType: "json",
				success : function(resultVo) {
					if(resultVo.result=="success"){
						render(resultVo.data,"up");
						
						$("#write-form input").val("");
						$("#write-form textArea").val("");
					} else{
						console.log(resultVo.failMsg);
					}
					/*성공시 처리해야될 코드 작성*/
					//뭔가를 가지고 와야해
					
				//값을 가지고 오면 해당하는 번호의 게시물을 삭제한다
				//삭제방법은 .remove();
				$("#GuestbookVo.no").remove();
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
		});
	
	});

	
	
	
	
	
	
</script>

</html>