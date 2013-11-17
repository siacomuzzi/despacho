<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	    	
		    <div class="header masthead"></div>
		
		    <!-- Content -->
		   	<div id="content" class="span12>"></div>
		
		    <!-- Footer -->
		    <div class="footer">
		      	<p class="pull-right">UADE &copy; 2013</p>
		    </div>
		    
	    </div> <!-- /container -->
	
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script type="text/javascript">
	    	if (!window.baseUrl) {
	    		window.baseUrl = 'http://localhost:8080/despacho.backend.api/';
	    	}
	    </script>
	    
	    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.0-min.js" />"></script>
	    <script type="text/javascript" src="<c:url value="/resources/js/underscore-min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/backbone-min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		
		<script type="text/javascript" src="<c:url value="/resources/js/utils.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/models/models.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/views/header.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/views/usuarioList.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/views/configuracionList.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/views/articulosList.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/views/solicitudesList.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/views/home.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
  	</body>
</html>
