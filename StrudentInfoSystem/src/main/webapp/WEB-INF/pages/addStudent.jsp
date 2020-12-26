<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:  green;" align="center">STUDENT REGISTRATION </h1>

<frm:form modelAttribute="student">
	<table bgcolor="cyan" align="center" >
		<tr>
		<h1><td><h3>Student Name:: <frm:input path="sname" /></h3></td></h1>
		</tr>
         <tr>
			<td><h3>Address:: <frm:input path="sadd" /></h3></td>
		</tr>
          <tr>
			<td><h3>MObile:: <frm:input path="mobile" /> </h3></td>
		</tr>
		 <tr>
			<td><h3>Aadhar: <frm:input path="aadhar" /> </h3></td>
		</tr>
		 <tr>
			<td><h3>Father name:: <frm:input path="fname" /> </h3></td>
		</tr>
		 <tr>
			<td><h3>STD:: <frm:input path="std" /> </h3></td>
		</tr>
	
		<tr><td><input type="submit" value="SUBMIT">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a style="color: black " href="studentinfo">BACK</a></td></tr>
		<tr><td>
	</table>
</frm:form>
              
