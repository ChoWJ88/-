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
<title>Insert title here</title>
</head>
<body>
	<form:form
		action="${pageContext.request.contextPath }/read/genreModify/${game.gNum}"
		commandName="modifyGenre" method="post" enctype="multipart/form-data">
		<form:input type="hidden" value="${game.gNum}" path="gNum" />

		<table border="1">
			<tr>
				<th colspan="2">장르 수정</th>
			</tr>
			<tr>
				<td>기존</td>
				<td>수정선택</td>
			</tr>
			<tr>
				<td><c:forEach var="genre" items="${genreOfGameList}">
						<c:if test="${game.gNum == genre.gNum }">
							<c:out value="${genre.genName}"></c:out>
						</c:if>
					</c:forEach></td>
				<td>
					<ol>

						<!-- 전체 장르의 시퀀스와 게임이 갖고 있는 시퀀스를 비교해야함 -->
						<c:forEach var="genre" items="${genreListAll}">
							<!-- map리턴 , 전체 장르 -->
							<c:set var="checked" value="" />
							<c:forEach var="genreOfGame" items="${genreOfGameList }">
								<!-- dtolist리턴, 게임이 갖고 있는 장르 -->
								<c:choose>
									<c:when test="${genre.GEN_NUM == genreOfGame.genNum}">
										<c:set var="checked" value="checked" />
									</c:when>
								</c:choose>
							</c:forEach>
							<li><input type=checkbox name="genNum"
								value="${genre.GEN_NUM}" ${checked } /> <c:out
									value="${genre.GEN_NAME}" /></li>
						</c:forEach>
					</ol>
				</td>
			</tr>
		</table>
		<input type="submit" value="수정 완료 ">&nbsp;&nbsp;&nbsp;
	<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">
			
			
				<input type="radio" name="radio-btn" id="img-${status.count}" checked />
					    <li class="slide-container">
					    <div class="slide">
					      <img src="/image/${gameList.gName }/${gameFile.gfSavedfilename }" />
					        </div>
					    <div class="nav">
					    
					      <label for="img-6" class="prev">&#x2039;</label>
					      
					      <label for="img-${status.count + 1}" class="next">&#x203a;</label>
					    </div>
					    </li>

	</form:form>
</body>
</html>
