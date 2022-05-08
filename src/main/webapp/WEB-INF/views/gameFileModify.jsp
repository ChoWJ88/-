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
</head>
<body>
	<h1>${gameList.gName}게임파일수정</h1>

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
		<tr>
			<th>슬라이드 사진</th>
		</tr>
		<tr>
			<td colspan="1"><c:forEach var="gameFile"
					items="${gameFilesList}">
					<c:if test="${gameFile.gfCode == 2}">

						<img
							src="<c:url value="/image/${gameList.gName }/${gameFile.gfSavedfilename }"/>"
							height="300" width="600">
					</c:if>

				</c:forEach></td>

		</tr>
	</table>

</body>
</html>