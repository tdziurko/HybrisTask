<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="dashboardTemplate">
    <tiles:putAttribute name="body">
    <div class="container">
		
	    <div id="note" class="blog-post note-form-box" data-note-id="${note.id}">
		  <div class="note-wrapper">
		    <h2 class="blog-post-title">${note.title}</h2>
	        <p class="blog-post-meta">{${note.formatedDate} by <a href="#">${note.user.username}</a>}</p>
			${note.content}
		  </div>
		
		<p> <strong>></strong> Comments </p>
		<div id="comment-container">
			<c:forEach items="${comments}" var="comment">
			    <div class="alert alert-info" role="alert">
					<strong>${comment.email}</strong>
					<p>${comment.content}</p>
				</div>
			</c:forEach>
		</div>
		
		<!-- Comment form -->
		<div id="oh-snap">
		</div>
		<form class="form-horizontal" role="form">
		
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-10">
		      <input type="email" id="email" class="form-control" name="email" placeholder="Email">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">Body</label>
		    <div class="col-sm-10">
		      <textarea class="form-control comment-box" id="content" name="content" rows="3"></textarea>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button id="add_comment" type="button" class="btn btn-default navbar-btn">Add comment</button>
		    </div>
		  </div>
		</form>
		
		
		</div><!-- /.blog-post -->

    </div><!-- /.container -->
    </tiles:putAttribute>
</tiles:insertDefinition>