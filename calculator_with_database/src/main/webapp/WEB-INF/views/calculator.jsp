
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form method="post" action="calculator/v2">
    <label for="firstvalue">First Value:</label>
    <input type="number" name="firstvalue" id="firstvalue"/><br><br>
    <label for="operator">operator:</label>
    <input type="text" name="operator" id="operator"/><br><br>
    <label for="secondvalue">Second Value:</label>
    <input type="number" name="secondvalue" id="secondvalue"/><br><br>

    <input type="submit" value="Calculate">

    <p>Result : <% out.println(request.getAttribute("result")); %>
</form>

</body>
</html>