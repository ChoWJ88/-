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
<title>장르 추가 삭제</title>
</head>
<body>
	<h3>장르 추가페이지</h3>
	<form:form action="addGenre" commandName="addGenre" method="post"
		enctype="multipart/form-data">
		<table border="1">

			<tr>
				<td colspan="2"><c:forEach var="genre" items="${genreList}">
						<li><c:out value="${genre.GEN_NAME}"></c:out></li>
					</c:forEach></td>
			</tr>

			<tr>
				<td>추가할 장르</td>
				<td><form:input path="genName" />
					<form:errors path="genName" /></td>
			</tr>



		</table>
		<input type="submit" value="장르 추가 ">&nbsp;&nbsp;&nbsp;
		
		<input type="button" value="장르 삭제페이지로"
			onclick="location.href='<c:url value="delGenre"/>'">&nbsp;&nbsp;&nbsp;

		<input type="button" value="메인으로"
			onclick="location.href='<c:url value="/list"/>'">

	</form:form>







	<!-- <ol id='newgenres'></ol>
	<input type='text' id='addValue' name="newgenre" placeholder="기타(직접입력)" />
	<input type='button' value='추가' onclick='addList()' />
	<input type='button' value='삭제' onclick='removeItem()' />
	<script type="text/javascript">
		function addList() {

			// 1. 추가할 값을 input창에서 읽어온다
			const addValue = document.getElementById('addValue').value;

			// 2. 추가할 li element 생성
			// 2-1. 추가할 li element 생성
			const li = document.createElement("li");

			// 2-2. li에 id 속성 추가 
			li.setAttribute('id', addValue);

			// 2-3. li에 text node 추가 
			const textNode = document.createTextNode(addValue);
			li.appendChild(textNode);

			// 3. 생성된 li를 ul에 추가
			document.getElementById('newgenres').appendChild(li);
		}

		function removeItem() {

			// 1. <ul> element 선택
			const ul = document.getElementById('newgenres');

			// 2. <li> 목록 선택
			const items = ul.getElementsByTagName('li');

			// 3. <li> 목록 중 첫번째 item 삭제
			if (items.length > 0) {
				items[0].remove();
			}

		}
	</script>  -->
</body>
</html>