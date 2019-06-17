<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>


<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Fleet Tracker</title>
      <!-- Bootstrap -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
     <link rel="shortcut icon" type="image/png" href="\images\favicon.png"/>

      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
   <style>
      .navbar-dark .navbar-nav .nav-link {
      color: white;
      }
	  section{
	    margin-top:60px;
	  }
	  .footer {
 position: absolute;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 60px;
  line-height: 60px; /* Vertically center the text there */
  background-color: #007bff;
}
   </style>
   <body>
      <nav class="navbar navbar-expand-lg navbar-light navbar-dark bg-primary">
         <div class="container">
            <ul class="nav navbar-nav pull-sm-left">
               <li class="nav-item">
                   <img src="\images\logo.png" height="63" width="300">
                  <!--<a class="nav-link" href="#">Fleet Tracker</a>-->
               </li>
            </ul>
            <ul class="nav navbar-nav navbar-logo mx-auto">
               <li class="nav-item">
                  <a class="nav-link" href="#">Vehicles</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="#">Readings</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="#">Alerts</a>
               </li>
            </ul>
         </div>
      </nav>
      <!-- Page Content -->
      <div class="container">
         <div class="row pagination-centered">
            <div class="col-lg-12 text-center">
			<section>

               <h5>Vehicles Registered</h5>

               <div class="col-lg-10 text-center offset-md-1">
                  <table class="table">
                     <thead class="">
                        <tr>
                           <th scope="col">#</th>
                           <th scope="col">Owner</th>
                           <th scope="col">VIN</th>
                           <th scope="col">Make</th>
                           <th scope="col">Model</th>
                           <th scope="col">Year</th>
                           <th scope="col">RPM Redline</th>
                           <th scope="col">Max Fuel</th>
                           <th scope="col">Last Service</th>
                        </tr>
                     </thead>
                     <tbody>
                     <c:forEach items="${requestScope.vehicles}" var="vehicle">
                        <tr>
                           <th scope="row">1</th>
                           <td>${ vehicle.ownerName }</td>
                           <td>${ vehicle.vin }</td>
                           <td>${ vehicle.make }</td>
                           <td>${ vehicle.model }</td>
                           <td>${ vehicle.year  }</td>
                           <td>${ vehicle.redlineRpm }</td>
                           <td>${ vehicle.maxFuelVolume  }</td>
                           <td>${ vehicle.lastServiceDate }</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                  </table>
               </div>
			  </section>

            </div>


        </div>

      </div>

	  <img src="\images\Driving-Car.gif" alt="Smiley face" height="150" width="250">


	  <footer class="footer">
           <div class="row footer-bottom">
            <div class="col-sm-6">
              <p    style="margin-bottom: 0px;">© 2019. Fleet Tracker. All rights reserved.</p>
            </div>
            <div class="col-sm-6">
              <p class="right" style="margin-bottom: 0px";><a>Contact Us : info@fleettracker.com </a>  |  <a>  Location : Detroit , MI</a>.</p>
            </div>
          </div>
      </footer>
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
   </body>
</html>