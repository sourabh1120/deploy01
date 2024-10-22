<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br>
<c:choose>
	<c:when test="${!empty empsInfo}">
		<table bgcolor="yellow" border="1" width="1000">
		<tr bgcolor="yellow">
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>EJOB</th>
			<th>ESALARY</th>
			<th>EDEPTNO</th>
			<th>OPERATIONS</th>
		</tr>
		
		<c:forEach var="emp" items="${empsInfo}">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.ejob}</td>
				<td>${emp.esalary}</td>
				<td>${emp.edeptno}</td>
				<td style="text-align:center"><a href="edit?no=${emp.empno}">Edit</a>
				<a href="delete?no=${emp.empno}" onclick="return confirm('are you sure to delete the recoreds')">Delete</a></td>
			</tr>
		</c:forEach>
		
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color:red; text-align:center">Data Not Found</h1> 
	</c:otherwise>

</c:choose>

<h2 style="text-align:center; color:green">${resultMsg}</h2>

<h1 style="color:red;text-align:center">
<a href="./">home<img src="images/home.png" width="50" height="50"/></a>
<a href="register">Add<img src="images/add.jpg" width="50" height="50"/></a>
</h1>









