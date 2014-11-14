<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<tiles:insertDefinition name="dashboardTemplate">
    <tiles:putAttribute name="body">
 
        <div class="body">
            <h1>Home page ${admin.password}!</h1>
 
            <p>The time on the server is.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
                magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</P>
        </div><br/>
        
        <c:forEach items="${notes}" var="note">
		   <div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
				  <div class="panel-body">
				    <h2>${note.getTitle()}</h2>
						<p>${note.getContent()}</p>
				  </div>
				</div>
			</div>
			</div>
		</c:forEach>
		 
    </tiles:putAttribute>
</tiles:insertDefinition>