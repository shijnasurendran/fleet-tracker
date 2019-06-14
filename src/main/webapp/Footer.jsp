<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<html>
<head>
   <title>Fleet Tracker</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta name="description" content="">
   <meta name="author" content="">
   <!-- CSS Files -->

</head>
<body>
<footer>
<table Style="bottom: 0; right:0; height: 5%; width: 100%";/>
    <tr>
        <td><img src="images/Driving-Car.gif" alt="Smiley face" height="150" width="250"></td>
        <td align="right">Copyright: Fleet Tracker 2019 &nbsp&nbsp&nbsp</td>
    </tr>
</table>
</footer>
</body>
</html>