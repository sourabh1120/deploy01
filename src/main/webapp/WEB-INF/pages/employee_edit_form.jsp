<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:blue; text-align:center">Employee edit form</h1>

<script language="javaScript" src="js/validation.js">

</script>
<link rel=stylesheet" type=text/css href="css/style.css" />


<frm:form modelAttribute="emp" onsubmit="return validation(this)">
	<p style="color:red ;text-align:center">
			<frm:errors path="*"/>

<table  border="1" bgcolor="yellow" align="center">
	
	
	<tr>
		<td>Employee no::</td>
		<td><frm:input path="empno" readonly="true"/>	</td>
	</tr>
	
	<tr>
		<td>Employee name::</td>
		<td><frm:input path="ename"/><span id="enameError"/>	</td>
	</tr>
	
	<tr>
		<td>Employee job::</td>
		<td><frm:input path="ejob"/><span id="ejobError"/>	</td>
	</tr>
	
	<tr>
		<td>Employee salary::</td>
		<td><frm:input path="esalary"/><span id="esalaryError"/>	</td>
	</tr>
	
	<tr>
		<td>Department Number::</td>
		<td><frm:select path="deptno">
			<frm:options items="${dnoList}"/><span id="enameError"/>
			</frm:select><span id="deptError"/>
			</td>
	</tr>
	
	<tr>
		<td>Employee department::</td>
		<td><frm:input path="edeptno"/>	</td>
	</tr>
	
	<%-- <tr>
		<td><frm:hidden path="vflag1" /></td>
	</tr> --%>
	<tr>
		<td><input type="submit" value="edit employee"></td>
	</tr>
	
</table>
</frm:form>