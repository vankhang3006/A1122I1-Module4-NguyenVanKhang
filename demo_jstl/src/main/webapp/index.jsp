<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 5/31/2023
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
  <style>
.product-discount{
  height: 150px;
  width: 400px;
}
  </style>
</head>
<body>
<center>
  <h1>Simple Calculator</h1>
  <div class="product-discount">
    <form method="post" action="/calculate">
      <fieldset>
        <legend>Calculator</legend>
        <table>
          <tr>
            <td style="text-align:left"><label for="First operand">First operand:</label></td>
            <td><input style="width: 130px;" type="text" id="First operand" name="operand" ></td>
          </tr>
          <tr>
            <td style="text-align:left"><label for="Operator">Operator:</label></td>
            <td>
              <select style="padding-left: 5px" id="Operator" name="Operator">
                <option value="">--- Choose ---</option>
                <option value="Add">Addition</option>
                <option value="Sub">Subtraction</option>
                <option value="Mul">Multiplication</option>
                <option value="Div">Division</option>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:left"><label for="Second operand">Second operand:</label></td>
            <td><input style="width: 130px;" type="text" id="Second operand" name="operand"></td>
          </tr>
          <tr>
            <td></td>
            <td><input type="submit" name="calculate" value="Calculate"/></td>
          </tr>
        </table>

      </fieldset>
    </form>
  </div>
</center>

</body>
</html>
