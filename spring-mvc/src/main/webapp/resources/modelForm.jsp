<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Registration Form</title>
  <style>
    .error {
      color:red
    }
  </style>
</head>
<body>
<h1>send nude</h1>
<!-- alo ha -->
<h2>Normal form</h2>
<form:form action="result" modelAttribute="student">
  First name: <form:input path="firstName" />
  <br><br>
  Age: <form:input path="age" />
  <br><br>
  <input type="submit" value="Submit" />
</form:form>

<h2 class="error">Form with validator</h2>
<form:form action="resultWithValidate" modelAttribute="student">
  First name: <form:input path="firstName" /> <form:errors path="firstName" cssClass="error" />
  <br><br>
  Age: <form:input path="age" /> <form:errors path="age" cssClass="error" />
  <br><br>
  <input type="submit" value="Submit" />
</form:form>


</body>
</html>

