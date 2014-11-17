<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="dashboardTemplate">
    <tiles:putAttribute name="body">
    <div class="container">

      <div class="blog-header">
        <h1 class="blog-title">I Want to Join Your Team !</h1>
        <p class="lead blog-description">All Users' notes -sorted from newest </p>
      </div>

      <div class="row">

        <div class="col-sm-8 blog-main">

  		

	        <c:forEach items="${notes}" var="note">
		        <div class="blog-post">
				  <div class="note-wrapper">
				    <h2 class="blog-post-title"><a href="<c:url value="/notes/${note.id}"/>">${note.title}</a></h2>
			        <p class="blog-post-meta">{${note.formatedDate} by <a href="#">${note.user.username}</a>}</p>
					${note.content}
				  </div>
				</div><!-- /.blog-post -->
			</c:forEach>		

        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2014</a></li>
              <li><a href="#">February 2014</a></li>
              <li><a href="#">January 2014</a></li>
              <li><a href="#">December 2013</a></li>
              <li><a href="#">November 2013</a></li>
              <li><a href="#">October 2013</a></li>
              <li><a href="#">September 2013</a></li>
              <li><a href="#">August 2013</a></li>
              <li><a href="#">July 2013</a></li>
              <li><a href="#">June 2013</a></li>
              <li><a href="#">May 2013</a></li>
              <li><a href="#">April 2013</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </div><!-- /.container -->
    </tiles:putAttribute>
</tiles:insertDefinition>
