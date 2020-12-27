<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <h1 style="color:red;" align="center">All Students</h1>

<c:choose >
    <c:when test="${studentinfo ne null && !empty studentinfo }">
        <table  align="center" border="2" bgcolor="33FFA8">
             <tr style="font-size: 25px;color:red"  >
               <th>   ROLL NO </th>
               <th>   NAME   </th>
               <th>  ADDRESS  </th>
               <th>   MOBILE  </th>
               <th>   AADHAR  </th>
               <th>  FATHER NAME  </th>
               <th> STANDARD  </th>
               <th>  OPERATIONS </th>
              </tr>
              <c:forEach  var="dto"  items="${studentinfo}">
                   <tr >
                      <td>${dto.roll}  </td>
                      <td>${dto.sname}  </td>
                      <td>${dto.sadd}  </td>
                      <td>${dto.mobile}  </td>
                      <td>${dto.aadhar}  </td>
                      <td>${dto.fname}  </td>
                      <td>${dto.std}  </td>
                     <td><a href="editStudent?rollNo=${dto.roll }"><img  src="images/edit1.png" height="60" width="75"> </a>
					&nbsp;<a href="deleteStudent?rollNo=${dto.roll }"><img  src="images/del.png" height="60" width="75"> </a></td>
				</tr>
                   </tr>
              </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
         <h1 align="center" >Records not found</h1>
    </c:otherwise>
</c:choose>

<h1><marquee direction="right" style="color: maroon;" truespeed="truespeed" >${result }</marquee></h1>
 <h1 align="center"><a  href="welcome"><img alt="" src="images/home1.png"width="110" height="100"></a>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  href="addStudent"><img alt="" src="images/add1.png"width="100" height="100"></a>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  href="studentinfo"><img alt="" src="images/ref.png"width="110" height="100"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a class=" text-danger text-center" href="JavaScript:doPrint()"><img alt="PRINT" src="images/print.png" width="100" height="100"></a></h1>
 

 <script language="JavaScript">
      function doPrint(){
    	  frames.focus();
    	  frames.print();
      }
 </script>


