<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임등록</title>
<script type="text/javascript">
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
				<td><form:input path="gName" />
			</tr>
			<tr>
				<td><font color="blue">게임코드</font></td>
				<td><form:input path="gCode" />
			</tr>
			<tr>
				<td><font color="blue">개발사</font></td>
				<td><form:input path="gDev" />
			</tr>
			<tr>
				<td><font color="blue">출시일</font></td>
				<td><form:input type="date" path="gDate" />
			</tr>
			<tr>
				<td><font color="blue">게임가격</font></td>
				<td><form:input path="gPrice" pattern="[0-9]+"
						placeholder="숫자만 입력" />
			</tr>

			<tr>
				<td><font color="blue">게임 이미지</font></td>
				<td><input type="file" id="imgFile" name="imgFile"
					value="${regForm.imgFile }" onChange="setTumbnail()">
			<tr>
				<th colspan=3>장르 선택</th>
			</tr>
			<tr>
				<td colspan=3>
					<ol>
						<c:forEach var="genre" items="${genreList}">
							<li><input type=checkbox name="genKey" value="${genre.GEN_KEY}">
							<c:out value="${genre.GEN_NAME}" /></li>

						</c:forEach>
					</ol>
				</td>
			</tr>

			<tr>
				<td><font color="blue">게임 소개</font></td>
				<td colspan="2"><textarea name="gContent" rows="10" cols="45">${regForm.gContent}</textarea>
			</tr>
		</table>

		<input type="submit" value="다음페이지 ">&nbsp;&nbsp;&nbsp;
		<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">

	</form:form>



</body>
</html>