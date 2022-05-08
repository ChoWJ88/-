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
<title>게임 장르 수정</title>
</head>
<body>
	<h1>${gameList.gName}</h1>

	<form:form
		action="${pageContext.request.contextPath }/read/genreModify/${gameList.gNum}"
		commandName="modifyGenre" method="post" enctype="multipart/form-data">
		<form:input type="hidden" value="${gameList.gNum}" path="gNum" />

		<table border="1">
			<tr>
				<th colspan="2">장르 수정</th>
			</tr>
			<tr>
				<td>기존</td>
				<td>수정선택</td>
			</tr>
			<tr>
				<td><c:forEach var="genre" items="${genreList}">
						<c:if test="${gameList.gNum == genre.gNum }">
							<c:out value="${genre.genName}"></c:out>
						</c:if>
					</c:forEach></td>
				<td>
					<ol>
						<c:forEach var="genre1" items="${genreListAll}">
							<c:set var="checked" value="" />
							<c:forEach var="genreList" items="${genreList }">
						
								<c:choose>
									<c:when test="${genre1.GEN_NUM == genreList.genNum}">
										<c:set var="checked" value="checked" />
									</c:when>
								</c:choose>
							</c:forEach>
							<li><input type=checkbox name="genNum"
								value="${genre1.GEN_NUM}" ${checked }> <c:out
									value="${genre1.GEN_NAME}" /></li>
						</c:forEach>




					</ol>
				</td>
			</tr>
		</table>
		<input type="submit" value="수정 완료 ">&nbsp;&nbsp;&nbsp;
	<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">

	</form:form>


</body>
</html>