<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	    <title>Despacho</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
	    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" />
  	</head>

	<body>

	    <div class="container">
	    	
		    <div class="masthead">
		      	<c:import url="/WEB-INF/views/tags/navbar.jsp"/>
		    </div>
		
		    <c:import url="/WEB-INF/views/tags/banner.jsp"/>
		
		    <!-- Body -->
		    <decorator:body />
		
		    <!-- Footer -->
		    <div class="footer">
		      	<c:import url="/WEB-INF/views/tags/footer.jsp"/>
		    </div>
		    
	    </div> <!-- /container -->
	
	    <!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.0-min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  	</body>
</html>
