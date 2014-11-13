<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="dashboardTemplate">
    <tiles:putAttribute name="body">
 
	<h2>Horizontal form</h2>
	<form:form action="/HybrisTask/cms/note/create" modelAttribute="note" method="POST"> 
	    <form:errors path="title" cssClass="error" />
	    <form:label path="title">Title</form:label>
	    <form:input path="title"/>
	
	    <form:errors path="content" cssClass="error" />
	    <form:label path="content">Content</form:label>
	    <form:input path="content"/>

	    <input type="submit" value="Submit" />
	</form:form>

    </tiles:putAttribute>
</tiles:insertDefinition>