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
<title>게임 리스트</title>

</head>
<body>

	<h1>게임 리스트</h1>

	<table border="1">
		<tr>
			<th>등록 번호</th>
			<th>게임 사진</th>
			<th>게임 이름</th>
			<th>장르</th>
			<th>개발사</th>
			<th>출시일</th>
			<th>가격</th>
		</tr>

		<c:if test="${!empty gameList }">

			<c:forEach var="game" items="${gameList }">

				<tr>
					<td>${ game.gNum}</td>

					<td><c:forEach var="gameFile" items="${gameFilesList}">

							<c:if test="${gameFile.gfCode == 1}">
								<c:if test="${game.gNum == gameFile.gNum}">

									<img
										src="<c:url value="/image/${game.gName }/${gameFile.gfSavedfilename }"/>"
										width="160">
								</c:if>
							</c:if>
						</c:forEach></td>
					<td><a href="<c:url value="/read/${game.gNum }"/>">${game.gName }</a></td>

					<td><c:forEach var="genre" items="${genreList}">
							<c:if test="${game.gNum == genre.gNum }">
								<c:out value="${genre.genName}"></c:out>
							</c:if>
						</c:forEach></td>

					<td>${game.gDev}</td>
					<td><fmt:formatDate value="${game.gDate }"
							pattern="yyyy.MM.dd" /></td>
					<td>${game.gPrice }원</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty gameList}">
			<tr>
				<td colspan="7">정보없음</td>
			</tr>
		</c:if>
	</table>
	<input type="button" value="게임 정보 추가"
		onclick="location.href='<c:url value="/gameReg"/>'">
	
	<input type="button" value="게임 장르 추가"
		onclick="location.href='<c:url value="/addGenre"/>'">
	
	<input type="button" value="게임 목록"
		onclick="location.href='<c:url value="/list"/>'">



</body>
</html>