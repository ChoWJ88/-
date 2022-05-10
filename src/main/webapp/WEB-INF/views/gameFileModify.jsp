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
<title>게임 파일 수정</title>
<script type="text/javascript">
	function btn_click(str) {
		if (str == "mupdate") {
			form.action = "${pageContext.request.contextPath }/read/mainFileUpdate/${gameList.gNum}";
		} else if (str == "mdelete") {
			form.action = "${pageContext.request.contextPath }/read/mainFileDelete/${gameList.gNum}";
		} else if (str == "dupdate") {
			form.action = "${pageContext.request.contextPath }/read/slideFileUpdate/${gameList.gNum}";
		} else if (str == "ddelete") {
			form.action = "${pageContext.request.contextPath }/read/slideFileDelete/${gameList.gNum}";
		} else {
		

		}
	}
</script>
</head>
<body>
	<h1>${gameList.gName}게임파일수정</h1>

	<form:form
		action="${pageContext.request.contextPath }/read/gameFileModify/${gameList.gNum}"
		commandName="modifyGameFile" method="post" name="form"
		enctype="multipart/form-data">
		<form:input type="hidden" value="${gameList.gNum}" path="gNum" />
		<form:input type="hidden" value="${gameList.gName}" path="gName" />
	
	<!-- 	<c:forEach var="gameFiles" items="${gameFilesList}">
		<form:input type="hidden" value="${gameFiles.gfSavedfilename}" path="gfSavedfilename" />
		</c:forEach> -->
		<table border="1">
			<tr>
				<th>메인 사진</th>
			</tr>
			<tr>

				<td colspan="1"><c:forEach var="gameFile"
						items="${gameFilesList}">
						<c:if test="${gameFile.gfCode == 1}">
					
							<c:if test="${gameList.gNum == gameFile.gNum}">

								<img
									src="<c:url value="/image/${gameList.gName }/${gameFile.gfSavedfilename }"/>"
									width="300">
							</c:if>
						</c:if>
					
					</c:forEach></td>


			</tr>

		</table>

		<td><input type="file" name="imgFile"> <input
			type="submit" value="메인사진 추가" onclick='btn_click("mupdate");'>
			<input type="submit" value="메인사진 삭제" onclick='btn_click("mdelete");'>
			<input type="button" value="게임 목록"
			onclick="location.href='<c:url value="/list"/>'">

			<table border="1">


				<tr>
					<th>슬라이드 사진</th>
				</tr>

				<tr>
					<td colspan="1"><c:forEach var="gameFile" items="${gameFilesList}">
							<c:if test="${gameFile.gfCode == 2}">
								<fieldset>
									<label for="gfNum${gameFile.gfNum }" onclick="if(navigator.appVersion.indexOf('MSIE') != -1){gfNum.click()}">
										<input type="checkbox" name="gfNum" id="gfNum${gameFile.gfNum }" value="${gameFile.gfNum }">
										 <img src="<c:url value="/image/${gameList.gName }/${gameFile.gfSavedfilename }"/>" height="300" width="650">
									</label>
								</fieldset>
							</c:if>
						</c:forEach></td>
				</tr>


			</table> <input type="file" name="slideImgFile" placeholder="슬라이드 파일"
			multiple /> <input type="submit" value="슬라이드사진 추가"
			onclick='btn_click("dupdate");'> <input type="submit"
			value="슬라이드사진 삭제" onclick='btn_click("ddelete");'> <input
			type="button" value="게임 목록"
			onclick="location.href='<c:url value="/list"/>'">
	</form:form>

</body>
</html>