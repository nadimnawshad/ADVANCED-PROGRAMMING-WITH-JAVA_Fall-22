<%--
  Created by IntelliJ IDEA.
  User: NADIM
  Date: 11/4/2022
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tax Result</title>
</head>
<body>

<h1>Payable tax Amount</h1>

<p>Total amount : ${TotalIncome}
    <br>Taxable amount : ${TotalTaxableIncome}
    <br>Total Tax : ${TotalTax}
    <br>Total AllowableInvestment : ${AllowableInvestment}
    <br>Total Investment : ${Investment}
    <br>After Investment Net Tax: ${netTax}</p>


</body>
</html>
