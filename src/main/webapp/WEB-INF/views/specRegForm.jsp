<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 사양 등록</title>
</head>
<body>

	<h1>게임 등록 페이지</h1>
	게임이름 : ${gName }
	<form:form action="specReg" commandName="regForm1" method="post"
		enctype="multipart/form-data">
		<form:input type="hidden" value="${gName}" path="gName" />
		<table border="1">

			<tr>

				<td><font color="blue">최소CPU</font></td>
				<td><form:input path="specMinCpu" /></td>
			</tr>
			<tr>
				<td><font color="blue">최소메모리</font></td>
				<td><form:input path="specMinRam" /></td>
			</tr>
			<tr>
				<td><font color="blue">최소그래픽</font></td>
				<td><form:input path="specMinGpu" /></td>
			</tr>
			<tr>
				<td><font color="blue">최소DIRECTX</font></td>
				<td><form:input path="specMinDx" /></td>
			</tr>
			<tr>
				<td><font color="blue">권장CPU</font></td>
				<td><form:input path="specProCpu" /></td>
			</tr>
			<tr>
				<td><font color="blue">권장메모리</font></td>
				<td><form:input path="specProRam" /></td>
			</tr>
			<tr>
				<td><font color="blue">권장그래픽</font></td>
				<td><form:input path="specProGpu" /></td>
			</tr>
			<tr>
				<td><font color="blue">권장DIRECTX</font></td>
				<td><form:input path="specProDx" /></td>
			</tr>
			<tr>
				<td><font color="blue">슬라이드</font></td>
				<td><input type="file" name="slideImgFile" placeholder="파일 선택"
					multiple /><form:errors path="slideImgFile" /></td>
			</tr>


		</table>

		<input type="submit" value="등록완료 ">&nbsp;&nbsp;&nbsp;
		<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">

	</form:form>




</body>
</html>