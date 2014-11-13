<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
	<!-- Latest compiled and minified JavaScript -->
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link href="<c:url value="/resources/css/application.css" />" rel="stylesheet">
    <title>Default tiles template</title>
</head>
<body>
   <!-- Begin page content -->
    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item active" href="<c:url value="/cms/home"/>">Dashboard</a>
          <a class="blog-nav-item" href="<c:url value="/cms/note/new" />">New note</a>
          <a class="blog-nav-item" href="<c:url value="/cms/comments"/>">Comments</a>
          <a class="blog-nav-item" href="<c:url value="/cms/account"/>">My account</a>
        </nav>
      </div>
    </div>

    <div class="container content">
		<tiles:insertAttribute name="body" />
    </div><!-- /.container -->
</body>
</html>

