<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${!empty listData}">
		<table>
			<tr>
				<th>No</th>
				<th>name</th>
				<th>player-type</th>
				<th>country</th>
				<th>salary</th>
				<th>Grade</th>
			</tr>
			<c:forEach var="listPlayer" items="${listData}">
				<tr>
					<td><c:out value="${listPlayer.PID }"/></td>
					<td><c:out value="${listPlayer.NAME }" /></td>
					<td><c:out value="${listPlayer.PLAYER_TYPE }" /></td>
					<td><c:out value="${listPlayer.COUNTRY }" /></td>
					<td><c:out value="${listPlayer.SALARY }"/></td>
					<td><c:out value="${listPlayer.GRADE }"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>no player found</c:otherwise>
</c:choose>
