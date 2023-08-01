<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Registration Form</title>
</head>
<body>
<h1>send nude</h1>
<!-- alo ha -->
<form:form action="result" modelAttribute="student">
  First name: <form:input path="firstName" />
  <br><br>
  Age: <form:input path="age" />
  <br><br>
  <input type="submit" value="Submit" />
</form:form>
</body>
</html>

