<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>게임등록</title>
<script type="text/javascript">
$(function() {
    $("#test").click(function(){
    	var param = {};
    	param.gName = $("#gName").val();
    	param.gCode = $("#gCode").val();
    	console.log(param)
    	$.ajax({
            type : "post",            // HTTP method type(GET, POST) 형식이다.
            url : "/test1",      	// 컨트롤러에서 대기중인 URL 주소이다.
            data : param,            // Json 형식의 데이터이다.
            dataType: "json",
            success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                if(res.code == "0001"){
                	alert("중복된 이름입니다.")
                	$("#gName").val("");
                }else{
                	alert("등록을 계속 진행하세요.")
                }
            },
            error:function(request, error) {
    			// error 발생 이유를 알려준다.
    			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    		}
        });
    })
});
	function setTumbnail() {
		let fileInfo = document.getElementById("imgFile").files[0];
		let reader = new FileReader();

		reader.onload = function() {
			document.getElementById("thumbnailImg").src = reader.result;
		}
		if (fileInfo) {
			reader.readAsDataURL(fileInfo);
		}
	}

</script>

</head>
<body>
	<h1>게임 등록 페이지</h1>

	<form:form action="gameReg" commandName="regForm" method="post"
		enctype="multipart/form-data">
		<table border="1">

			<tr>
				<td rowspan="6"><img src="" id="thumbnailImg" width="180"></td>
				<td><font color="blue">게임 이름</font></td>
				<td><form:input path="gName" id="gName"/>
					<input type="button" id="test" value="test">
					<form:errors path="gName" /></td>
			</tr>
			<tr>
				<td><font color="blue">게임코드</font></td>
				<td><form:input path="gCode" id="gCode"/>
				<form:errors path="gCode" /></td>
			</tr>
			<tr>
				<td><font color="blue">개발사</font></td>
				<td><form:input path="gDev" />
				<form:errors path="gDev" /></td>
			</tr>
			<tr>
				<td><font color="blue">출시일</font></td>
				<td><form:input type="date" path="gDate" /></td>
			</tr>
			<tr>
				<td><font color="blue">게임가격</font></td>
				<td><form:input path="gPrice" pattern="[0-9]+"
						placeholder="숫자만 입력" /></td>
			</tr>

			<tr>
				<td><font color="blue">게임 이미지</font></td>
				<td><input type="file" id="imgFile" name="imgFile"
					value="${regForm.imgFile }" onChange="setTumbnail()">
					<form:errors path="imgFile" /></td>
			<tr>
				<th colspan=3>장르 선택</th>
			</tr>
			<tr>
				<td colspan=3>
					<ol>
						<c:forEach var="genre" items="${genreList}">
							<li><input type=checkbox name="genNum" value="${genre.GEN_NUM}">
							<c:out value="${genre.GEN_NAME}" /></li>

						</c:forEach>
					</ol>
					<form:errors path="genNum" />
				</td>
			</tr>

			<tr>
				<td><font color="blue">게임 소개</font></td>
				<td colspan="2"><textarea name="gContent" rows="10" cols="45">${regForm.gContent}</textarea></td>
			</tr>
		</table>

		<input type="submit" value="다음페이지 ">&nbsp;&nbsp;&nbsp;
		<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">

	</form:form>



</body>
</html>