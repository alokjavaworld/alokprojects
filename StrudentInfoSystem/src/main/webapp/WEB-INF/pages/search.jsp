<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 <h1 style="color:red" align="center">All Students</h1>

<c:choose >
    <c:when test="${searchResult ne null && !empty searchResult }">
        <table  align="center" border="2" bgcolor="pink">
             <tr  style="color: red">
               <th>   ROLL NO </th>
               <th>   NAME   </th>
               <th>  ADDRESS  </th>
               <th>   MOBILE  </th>
               <th>   AADHAR  </th>
               <th>  FATHER NAME  </th>
               <th> STANDARD  </th>
              </tr>
              <c:forEach  var="dto"  items="${searchResult}">
                   <tr >
                      <td>${dto.roll}  </td>
                      <td>${dto.sname}  </td>
                      <td>${dto.sadd}  </td>
                      <td>${dto.mobile}  </td>
                      <td>${dto.aadhar}  </td>
                      <td>${dto.fname}  </td>
                      <td>${dto.std}  </td>
                   </tr>
              </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
         <h1 align="center" >Records not found</h1>
    </c:otherwise>
</c:choose>
