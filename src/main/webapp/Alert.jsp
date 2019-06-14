<%@include file="Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>Fleet Tracker</title>
  <style>
    body {
    padding-top: 10px;
    padding-left: 10px;
    }
  </style>
<link rel="icon" href="images/favicon.ico" type="image/png" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/png" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid">
<br>
<br>
<br>
<h2>List Of Alerts</h2>
  <table class="table table-striped table-bordered table-hover table-condensed"  width="500">
    <tr>
      <td><b>VIN</b></td>
      <td><b>Alert Type</b></td>
      <td><b>Time</b></td>
      <td><b>Priority</b></td>
    </tr>
    <c:forEach items="${requestScope.alerts}" var="alert">
      <tr>
        <td>${ alert.vin }</td>
        <td>${ alert.alertType }</td>
        <td>${ alert.timestamp }</td>
        <td>${ alert.priority }</td>
      </tr>
    </c:forEach>
  </table>

</div>
</body>
</html>
<%@include file="Footer.jsp" %>