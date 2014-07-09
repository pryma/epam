<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<td>Bank Name</td>
    	<td>Country Registration</td>
    	<td>Depositor accountId</td>
    	<td>Depositor Name</td>
    	<td>Deposit Type</td>
    	<td>Amount On Deposit</td>
    	<td>Profitability</td>
    	<td>Time Constraints</td>
	</tr>

    <c:forEach var="deposit" items="${depositList}" >
    <tr>
    <td>${deposit.bankName}</td>
    <td>${deposit.countryRegistration}</td>
    <td>${deposit.accountId}</td>
    <td>${deposit.depositorName}</td>
    <td>${deposit.depositType}</td>
    <td>${deposit.amountOnDeposit}</td>
    <td>${deposit.profitability}</td>
    <td>${deposit.timeConstraints}</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
