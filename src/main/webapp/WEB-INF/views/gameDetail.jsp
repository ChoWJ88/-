<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 디테일</title>

</head>
<body>
	<h1>${gameList.gName}</h1>
	<table border="1">

		<form:input type="hidden" value="${gameList.gNum}" path="gNum" />
		

		<tr>
			<td colspan="3"><c:forEach var="gameFile"
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

			<td colspan="3">${gameList.gContent}</td>
		</tr>

		<tr>
			<td><b>출시일</b></td>
			<td colspan="2"><fmt:formatDate value="${gameList.gDate }"
					pattern="yyyy.MM.dd" /></td>
		</tr>
		<tr>
			<td><b>개발사</b></td>
			<td colspan="2">${gameList.gDev}</td>
		</tr>

		<tr>
			<td><b>평점</b></td>
			<td colspan="2">${gameList.gAvg}</td>

		</tr>
		<tr>
			<td><b>가격</b></td>
			<td colspan="2">${gameList.gPrice }원</td>

		</tr>
		<tr>
			<td><b>게임 장르</b></td>
			<td colspan="2"><c:forEach var="genre" items="${genreList}">
					<c:if test="${gameList.gNum == genre.gNum }">
						<c:out value="${genre.genName}"></c:out>
					</c:if>
				</c:forEach></td>
		</tr>
		<tr>
			<th colspan="3">사양</th>
		</tr>
		<tr>
			<th>*</th>
			<th>최소사양</th>
			<th>권장사양</th>
		</tr>
		<tr>
			<td><b>CPU</b></td>
			<td>${gameSpecList.specMinCpu}</td>
			<td>${gameSpecList.specProCpu}</td>
		</tr>
		<tr>
			<td><b>RAM</b></td>
			<td>${gameSpecList.specMinRam}</td>
			<td>${gameSpecList.specProRam}</td>
		</tr>

		<tr>
			<td><b>GPU</b></td>
			<td>${gameSpecList.specMinGpu}</td>
			<td>${gameSpecList.specProGpu}</td>
		</tr>

		<tr>
			<td><b>DIRECT-X</b></td>
			<td>${gameSpecList.specMinDx}</td>
			<td>${gameSpecList.specProDx}</td>
		</tr>
		<tr>
			<td>사진</td>
			<td colspan="2"><c:forEach var="gameFile"
					items="${gameFilesList}" varStatus="status">
					<c:if test="${gameFile.gfCode == 2}">

						<img
							src="<c:url value="/image/${gameList.gName }/${gameFile.gfSavedfilename }"/>"
							height="300" width="600">
					</c:if>



				</c:forEach></td>
		</tr>



	</table>

	<input type="button" value="게임 목록"
		onclick="location.href='<c:url value="/list"/>'">

	<input type="button" value="게임 정보 수정"
		onclick="location.href='<c:url value="gameModify/${gameList.gNum}"/>'">

	<input type="button" value="게임 장르 수정"
		onclick="location.href='<c:url value="genreModify/${gameList.gNum}"/>'">

	<input type="button" value="게임 사진 수정"
		onclick="location.href='<c:url value="gameFileModify/${gameList.gNum}"/>'">

	<input type="button" value="게임 사양 수정"
		onclick="location.href='<c:url value="specModify/${gameList.gNum}"/>'">

	<input type="button" value="게임 삭제"
		onclick="location.href='<c:url value="deleteGame/${gameList.gNum}/${gameList.gName }"/>'">
</body>
</html>