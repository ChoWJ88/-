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
<title>장르 삭제</title>
</head>
<body>
	<h3>장르 삭제페이지</h3>

	<form:form action="delGenre" commandName="delGenre" method="post"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td><c:forEach var="genre" items="${genreList}">
						<li><input type=checkbox name="genNum" value="${genre.GEN_NUM}">
							 <c:out value="${genre.GEN_NAME}" /></li>

					</c:forEach></td>
			</tr>
		</table>
		<input type="submit" value="장르 삭제 ">&nbsp;&nbsp;&nbsp;
		
		<input type="button" value="장르 추가페이지로"
			onclick="location.href='<c:url value="addGenre"/>'">&nbsp;&nbsp;&nbsp;

		<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">
	</form:form>
</body>
</html>