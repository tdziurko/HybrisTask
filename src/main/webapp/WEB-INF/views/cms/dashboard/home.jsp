<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<tiles:insertDefinition name="dashboardTemplate">
    <tiles:putAttribute name="body">
        
        <div class="body hello-index">
            <h1><i class="glyphicon glyphicon-home"></i> It is Your Home Page</h1>
            <p>Create/read/update your notes - read comment and ... </p>
  		</div><br/>
        
        <c:forEach items="${notes}" var="note">
		   <div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
				  <div class="panel-body">
				  	<h2><a href="<c:url value="/cms/note/${note.id}/edit"/>">${note.title}</a> </h2>
						<p>${note.content}</p>
						<div class="push-right"><i class="glyphicon glyphicon-trash tresh" data-remove-url="<c:url value="/cms/note/${note.id}/delete"/>"></i></div>
				  </div>
				</div>
			</div>
			</div>
		</c:forEach>
		 
    </tiles:putAttribute>
</tiles:insertDefinition>