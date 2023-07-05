<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 5/7/2023
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Basic Calculator</title>
</head>

<body>
<h1>Calculator</h1>
<form method="post" action="/calculator">
    <input type="text" id="firstNumber" name="firstNumber" placeholder="input number" value="${firstNumber}" oninput="checkNumber(this)" >
    <input type="text" id="secondNumber" name="secondNumber" placeholder="input number" value="${secondNumber}" oninput="checkNumber(this)"></br>
    <input type="submit" name="calculation" value="Addition(+)">
    <input type="submit" name="calculation" value="Subtraction(-)">
    <input type="submit" name="calculation"  value="Multiplication(X)">
    <input type="submit" name="calculation"   value="Division(/)"></br>
    <c:if test="${not empty result}">
        Result ${calculation} : ${result}
    </c:if>
</form>
<script>
    function checkNumber(input) {
        if (isNaN(input.value)) {
            input.value = "";
            alert("Vui lòng chỉ nhập số!");
        }
    }
</script>
</body>
</html>
