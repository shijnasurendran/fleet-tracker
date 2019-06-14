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

  <h2>List Of Vehicles Registered</h2>
  <table class="table table-striped table-bordered table-hover table-condensed">
  <thead>
  <tr>
  <th>Owner</th>
  <th>VIN</th>
  <th>Make</th>
  <th>Model</th>
  <th>Year</th>
  <th>RPM Redline</th>
  <th>Maximum Fuel Capacity</th>
  <th>Last Service</th>
  </tr>
  </thead>
  <tfoot>
  <c:forEach items="${requestScope.vehicles}" var="vehicle">
  <tr>
  <td>${ vehicle.ownerName }</td>
  <td>${ vehicle.vin }</td>
  <td>${ vehicle.make }</td>
  <td>${ vehicle.model }</td>
  <td>${ vehicle.year }</td>
  <td>${ vehicle.redlineRpm }</td>
  <td>${ vehicle.maxFuelVolume }</td>
  <td>${ vehicle.lastServiceDate }</td>
  </tr>
  </tfoot>
  </c:forEach>
  </table>

</div>
</body>
</html>
<%@include file="Footer.jsp" %>