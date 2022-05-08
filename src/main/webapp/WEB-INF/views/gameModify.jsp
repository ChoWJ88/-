<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 정보 수정</title>
</head>
<body>
	<h1>${gameList.gName} 게임 정보 수정</h1>

	<form:form
		action="${pageContext.request.contextPath }/read/gameModify/${gameList.gNum}"
		commandName="modifyGame" method="post" enctype="multipart/form-data">
			<form:input type="hidden" value="${gameList.gNum}" path="gNum" />
		<table border="1">



			<tr>
				<td><font color="blue">게임 이름</font></td>
				<td><form:input path="gName" value="${gameList.gName}" /></td>
			</tr>
			<tr>
				<td><font color="blue">게임코드</font></td>

				<td><form:input path="gCode" value="${gameList.gCode}" /></td>
			</tr>
			<tr>
				<td><font color="blue">개발사</font></td>

				<td><form:input path="gDev" value="${gameList.gDev}" /></td>
			</tr>
			<tr>
				<td><font color="blue">출시일</font></td>
				<td><fmt:formatDate value="${gameList.gDate }"
						pattern="yyyy-MM-dd" var="date1" /> <form:input type="date"
						path="gDate" value="${date1 }" /></td>
			</tr>
			<tr>
				<td><font color="blue">게임가격</font></td>

				<td><form:input path="gPrice" pattern="[0-9]+"
						value="${gameList.gPrice}" /></td>
			</tr>


			<tr>
				<td><font color="blue">게임 소개</font></td>
				<td colspan="1"><textarea name="gContent" rows="10" cols="45">${gameList.gContent}</textarea></td>
			</tr>
		</table>

		<input type="submit" value="수정 완료 ">&nbsp;&nbsp;&nbsp;
		<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">

	</form:form>

</body>
</html>