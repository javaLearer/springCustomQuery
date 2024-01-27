<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-// W3C// DTD HTML 4.01  Transitional// EN" "http:// www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start Spring MVC</title>
</head>
<body>
 <h3>List With Iteration :</h3>
   <table>

   <tr>
    <th>  EmpID </th>
   <th>  Name </th>
   <th>  Salary </th>
   <th>  CRR </th>
   </tr>
  <c:forEach var="skill" items="${employeeList}">
    <tr>

              <td>${skill.name}</td>
        <td>${skill.salary}</td>
            <td>${skill.crr}</td>
            </tr>
        </c:forEach>
</table>
 <a href="Input"> Back to Input page </a>
</body>
</html>



