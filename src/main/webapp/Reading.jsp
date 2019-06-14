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
<div class="container-fluid"">
<br>
<br>
<br>
  <h2>List Of Readings Collected</h2>
  <table class="table table-striped table-bordered table-hover table-condensed" width="500">
    <tr>
      <td><b>VIN</b></td>
      <td><b>Latitude</b></td>
      <td><b>Longitude</b></td>
      <td><b>Speed</b></td>
      <td><b>Fuel Volume</b></td>
      <td><b>Engine HP</b></td>
      <td><b>Engine RPM</b></td>
      <td><b>Time</b></td>
      <td><b>Engine Light ON</b></td>
      <td><b>Coolant Low</b></td>
      <td><b>Cruise Control On</b></td>
      <td><b>Front Left Tire Pressure</b></td>
      <td><b>Front Right Tire Pressure</b></td>
      <td><b>Rear Left Tire Pressure</b></td>
      <td><b>Rear Right Tire Pressure</b></td>


    </tr>
    <c:forEach items="${requestScope.reading}" var="reading">
      <tr>

        <td>${ reading.vin }</td>
        <td>${ reading.latitude }</td>
        <td>${ reading.longitude }</td>
        <td>${ reading.speed }</td>
        <td>${ reading.fuelVolume }</td>
        <td>${ reading.engineHp }</td>
        <td>${ reading.engineRpm }</td>
        <td>${ reading.timestamp }</td>
        <td>${ reading.checkEngineLightOn }</td>
        <td>${ reading.engineCoolantLow }</td>
        <td>${ reading.cruiseControlOn }</td>
        <td>${ reading.tires.frontLeft }</td>
        <td>${ reading.tires.frontRight }</td>
        <td>${ reading.tires.rearLeft }</td>
        <td>${ reading.tires.rearRight }</td>
      </tr>
    </c:forEach>
  </table>

</div>
</body>
</html>
<%@include file="Footer.jsp" %>