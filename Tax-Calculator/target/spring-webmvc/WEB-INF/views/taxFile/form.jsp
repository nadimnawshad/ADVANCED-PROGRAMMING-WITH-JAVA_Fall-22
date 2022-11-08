<%--
  Created by IntelliJ IDEA.
  User: NADIM
  Date: 11/4/2022
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        table,
        th,
        td {
            border: 1px solid black;
        }
    </style>
    <title>Income Tax Calculator Bangladesh (Salary)</title>
</head>
<body>
<h1 style="text-align:center; background-color:#343a40; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>
<div class="container-fluid">
    <div class="card">
        <div class="card-body">
            <h6 style="padding: 0.25%;">Tax Details<sup>*</sup></h6>
            <div class="table-responsive">
                <table class="table table-sm table-dark">
                    <thead>
                    <tr>
                        <th>Type</th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><label style="padding: 0.25%;" for="TotalIncome" >Total amount : </label></td>
                        <td><input id="TotalIncome" type="number" value="${TotalIncome}" readonly></td>
                    </tr>
                    <tr>
                        <td><label style="padding: 0.25%;" for="TotalTaxableIncome" >Taxable amount : </label></td>
                        <td><input id="TotalTaxableIncome" type="number" value="${TotalTaxableIncome}" readonly></td>
                    </tr>
                    <tr>
                        <td><label style="padding: 0.25%;" for="TotalTax" >Total Tax : </label></td>
                        <td><input id="TotalTax" type="number" value="${TotalTax}" readonly></td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td><label style="padding: 0.25%;" for="AllowableInvestment" >Total AllowableInvestment : </label></td>
                        <td><input id="AllowableInvestment" type="number" value="${AllowableInvestment}" readonly></td>
                    </tr>
                    <tr>
                        <td><label style="padding: 0.25%;" for="Investment" >Granted Investment : </label></td>
                        <td><input id="Investment" type="number" value="${Investment}" readonly></td>
                    </tr>
                    <tr>
                        <td><label style="padding: 0.25%;" for="netTax" >After Investment Net Tax: </label></td>
                        <td><input id="netTax" type="number" value="${netTax}" readonly></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <hr>
        <div class="card-body">
            <form:form action="submit" modelAttribute="taxForm">
                <label style="padding: 0.25%;" for="tax_payer_category" >Choose Tax Payer Category</label>
                <form:select id="tax_payer_category" path="tax_payer_category" class="btn btn-dark dropdown-toggle" type="button">
                    <form:option value="1">General</form:option>
                    <form:option value="2">Female/Senior Citizen</form:option>
                    <form:option value="3">Disabled</form:option>
                    <form:option value="4">Gazetted Freedom Fighters</form:option>
                </form:select>
                <form:errors path="tax_payer_category"/>
                <br><br>

                <label style="padding: 0.25%;" for="tax_payer_zone" >Choose Zone</label>
                <form:select id="tax_payer_zone" path="tax_payer_zone" class="btn btn-dark dropdown-toggle" type="button">
                    <form:option value="1">Dhaka/Chattagram City</form:option>
                    <form:option value="2">Other City</form:option>
                    <form:option value="3">Rest of the Country</form:option>
                </form:select>
                <form:errors path="tax_payer_zone"/>
                <br><br>
                <h6 style="padding: 0.25%;">Salary Breakdown<sup>*</sup></h6>
                <div class="table-responsive">
                    <table class="table table-sm table-dark">
                        <thead>
                        <tr>
                            <th>Area</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><label style="padding: 0.25%;" for="basic_salary" >*Basic Salary</label></td>
                                <td><form:input id="basic_salary" type="number" path="basic_salary" value ="0"/><form:errors path="basic_salary"/></td>
                            </tr>
                            <tr>
                                <td><label style="padding: 0.25%;" for="house_rent" >House Rent</label></td>
                                <td><form:input id="house_rent" type="number" path="house_rent" value="0"/><form:errors path="house_rent"/></td>
                            </tr>
                            <tr>
                                <td><label style="padding: 0.25%;" for="medical" >*Medical Allowance</label></td>
                                <td><form:input id="medical" type="number" path="medical" value="0" /><form:errors path="medical"/></td>
                            </tr>
                            <tr>
                                <td><label style="padding: 0.25%;" for="conveyance" >Conveyance</label></td>
                                <td><form:input id="conveyance" type="number" path="conveyance" value="0" /><form:errors path="conveyance"/></td>
                            </tr>
                            <tr>
                                <td><label style="padding: 0.25%;" for="commission" >Incentive/OT</label></td>
                                <td><form:input id="commission" path="commission" type="number" value="0" /><form:errors path="commission"/></td>
                            </tr>
                            <tr>
                                <td><label style="padding: 0.25%;" for="bonus" >Festival Bonus</label></td>
                                <td><form:input id="bonus" path="bonus" type="number" value="0" /><form:errors path="bonus"/></td>
                            </tr>
                            <tr>
                                <td><label style="padding: 0.25%;" for="investment" >Investment Amount</label></td>
                                <td><form:input id="investment" path="investment" type="number" value="0" /><form:errors path="investment"/></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="justify-content-center" style="margin-left: 45%;">
                    <input type="submit" value="Submit" class="btn btn-info btn-md"
                           style="padding: 1% 2%; margin: 2%;" data-toggle="modal"/>
                    <input type="reset"  value="Reset" class="btn btn-info btn-md"
                           style="padding: 1% 2%; margin: 2%;"/>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>