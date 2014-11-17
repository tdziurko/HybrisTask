<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="dashboardTemplate">
    <tiles:putAttribute name="body">
    <div class="container">
		
	    <div class="blog-post note-form-box">
		  <div class="note-wrapper">
		    <h2 class="blog-post-title">${note.title}</h2>
	        <p class="blog-post-meta">{${note.formatedDate} by <a href="#">${note.user.username}</a>}</p>
			${note.content}
		  </div>
		
		
		<c:forEach items="${comments}" var="comment">
		    <div class="alert alert-info" role="alert">
				<strong>${comment.email}</strong>
				<p>${comment.content}</p>
			</div>
		</c:forEach>
		

		</div><!-- /.blog-post -->

    </div><!-- /.container -->
    </tiles:putAttribute>
</tiles:insertDefinition>