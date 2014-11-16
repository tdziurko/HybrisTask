<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="dashboardTemplate">
    <tiles:putAttribute name="body">
    
 	<div class="note-form-box">
	
	<div class="alert alert-info alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	  Here, you can edit existing note.
	</div>
	
		<h2>Update note !</h2>
		<form:form action="/HybrisTask/cms/note/${note.id}/update" modelAttribute="note" method="POST"> 
		   	
		   	<form:input path="id" cssClass="form-control" type="hidden"/>
		   
		    <div class="form-group">
		   		<form:errors path="title" cssClass="error" />
		    	<form:label path="title">Title</form:label>
		    	<form:input path="title" cssClass="form-control"/>
		    </div>
			
			<div class="form-group">
			    <form:errors path="content" cssClass="error" />
			    <form:label path="content">Content</form:label>
			    <form:textarea path="content" cssClass="form-control"/>
		    </div>
	
		    <input type="submit" value="Submit" class="btn btn-primary btn-sm" />
		</form:form>
	
	</div>
	      
    </tiles:putAttribute>
</tiles:insertDefinition>