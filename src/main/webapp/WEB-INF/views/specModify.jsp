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
<title>게임 사양 수정</title>
</head>
<body>
	<h1>${gameList.gName} 게임 사양 수정</h1>

	<form:form
		action="${pageContext.request.contextPath }/read/specModify/${gameList.gNum}"
		commandName="modifySpec" method="post" enctype="multipart/form-data">
		<form:input type="hidden" value="${gameList.gNum}" path="gNum" />
		<table border="1">

			<tr>

				<td><font color="blue">최소CPU</font></td>
				<td><form:input path="specMinCpu"
						value="${gameSpecList.specMinCpu}" />
			</tr>
			<tr>
				<td><font color="blue">최소메모리</font></td>
				<td><form:input path="specMinRam"
						value="${gameSpecList.specMinRam}" />
			</tr>
			<tr>
				<td><font color="blue">최소그래픽</font></td>
				<td><form:input path="specMinGpu"
						value="${gameSpecList.specMinGpu}" />
			</tr>
			<tr>
				<td><font color="blue">최소DIRECTX</font></td>
				<td><form:input path="specMinDx"
						value="${gameSpecList.specMinDx}" />
			</tr>
			<tr>
				<td><font color="blue">권장CPU</font></td>
				<td><form:input path="specProCpu"
						value="${gameSpecList.specProCpu}" />
			</tr>
			<tr>
				<td><font color="blue">권장메모리</font></td>
				<td><form:input path="specProRam"
						value="${gameSpecList.specProRam}" />
			</tr>
			<tr>
				<td><font color="blue">권장그래픽</font></td>
				<td><form:input path="specProGpu"
						value="${gameSpecList.specProGpu}" />
			</tr>
			<tr>
				<td><font color="blue">권장DIRECTX</font></td>
				<td><form:input path="specProDx"
						value="${gameSpecList.specProDx}" />
			</tr>
		</table>
		<input type="submit" value="수정 완료 ">&nbsp;&nbsp;&nbsp;
	<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">
	</form:form>



</body>
</html>