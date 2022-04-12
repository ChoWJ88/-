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
				<td><form:input path="specMinCpu" />
			</tr>
			<tr>
				<td><font color="blue">최소메모리</font></td>
				<td><form:input path="specMinRam" />
			</tr>
			<tr>
				<td><font color="blue">최소그래픽</font></td>
				<td><form:input path="specMinGpu" />
			</tr>
			<tr>
				<td><font color="blue">최소DIRECTX</font></td>
				<td><form:input path="specMinDx" />
			</tr>
			<tr>
				<td><font color="blue">권장CPU</font></td>
				<td><form:input path="specProCpu" />
			</tr>
			<tr>
				<td><font color="blue">권장메모리</font></td>
				<td><form:input path="specProRam" />
			</tr>
			<tr>
				<td><font color="blue">권장그래픽</font></td>
				<td><form:input path="specProGpu" />
			</tr>
			<tr>
				<td><font color="blue">권장DIRECTX</font></td>
				<td><form:input path="specProDx" />
			</tr>
			<tr>
				<td><font color="blue">슬라이드</font></td>
				<td><input type="file" name="slideImgFile" placeholder="파일 선택" multiple />
			</tr>
			

		</table>

		<input type="submit" value="등록완료 ">&nbsp;&nbsp;&nbsp;
		<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">

	</form:form>



<!-- 	<h1>Multi File Upload (다중 파일 업로드)</h1> -->

<%-- 	<form action="multi_fileUpload" method="post" --%>
<%-- 		enctype="multipart/form-data"> --%>

<!-- 		<!-- multiple 속성추가 --> 

<!-- 		<input type="file" name="uploadfiles" placeholder="파일 선택" multiple /> -->
<!-- 		<br /> <input type="submit" value="upload"> -->

<%-- 	</form> --%>

</body>
</html>