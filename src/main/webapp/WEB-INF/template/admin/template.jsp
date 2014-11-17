<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,400,700,300" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
	<!-- Latest compiled and minified JavaScript -->
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link href="<c:url value="/resources/css/application.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/application.js" />"></script>
    <title>Hybris Task !</title>
</head>
<body>

  <div class="hidden">	
	  <!-- hidden form, that will be submit by js[application.js] -->	 
	  <c:url value="/j_spring_security_logout" var="logoutUrl" />
	  <form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" id="csrf" name="${_csrf.parameterName}"
		 		value="${_csrf.token}" />
	  </form>
  </div>
	
   <!-- Begin page content -->
    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
           <a class="blog-nav-item" href="<c:url value="/home"/>">Home</a>
           <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
	        	<a class="blog-nav-item pull-right" href="<c:url value="/login" />"><i class=" glyphicon glyphicon-log-in"></i></a>
	    	</sec:authorize>
	    	<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
	    	    <a class="blog-nav-item" href="<c:url value="/cms/home"/>">Dashboard</a>
          		<a class="blog-nav-item" href="<c:url value="/cms/note/new" />">New note</a>
	       		<a class="blog-nav-item pull-right logout" href=""><i class="glyphicon glyphicon-log-out"></i></a>
	    	</sec:authorize>
        </nav>
      </div>
      
    
    </div>
		
    <div class="container content">
		<tiles:insertAttribute name="body" />
    </div><!-- /.container -->
    
    
    <footer class="blog-footer">
      <p>Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        Rest of work is done by <a href="http://dzawowo.blogspot.com/">me</a>
      </p>
    </footer>
</body>
</html>

