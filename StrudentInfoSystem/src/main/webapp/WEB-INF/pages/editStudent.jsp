<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: green;" align="center">STUDENT UPDATION FORM</h1>

<frm:form action="updateStudent" modelAttribute="student">
	<table bgcolor="cyan" align="center">
		<tr>
			<h1>
				<td><h3>
						Roll NO::
						<frm:input path="roll" readonly="true" />
					</h3></td>
			</h1>
		</tr>
		<tr>
		<tr>
			<h1>
				<td><h3>
						NAME::
						<frm:input path="sname" />
<%-- 						<frm:errors path="ename" /> --%>
					</h3></td>
			</h1>
		</tr>
		<tr>
			<td><h3>
					ADDRESS::
					<frm:input path="sadd" />
<%-- 					<frm:errors path="job"></frm:errors> --%>
				</h3></td>
		</tr>
		<tr>
			<td><h3>
					MOBILE::
					<frm:input path="mobile" />
<%-- 					<frm:errors path="sal"></frm:errors> --%>
				</h3></td>
		</tr>
		<tr>
			<td><h3>
				AADHAR::
					<frm:input path="aadhar" />

				</h3></td>
		</tr>
		<tr>
			<td><h3>
					FATHER NAME::
					<frm:input path="fname" />

				</h3></td>
		</tr>
		<tr>
			<td><h3>
					STD::
					<frm:input path="std" />

				</h3></td>
		</tr>
		<tr>
			<td><input type="submit" value="UPDATE">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a style="color: black " href="studentinfo">BACK</a></td></tr></td>
		   
		</tr>
	</table>





</frm:form>

