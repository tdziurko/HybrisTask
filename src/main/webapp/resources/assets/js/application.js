/*
 * All js here.
 */

$( document ).ready(function() {
	
	//TODO - I have no idea how to create more generic solution of adding this
	//csrf token.
	
	$(".tresh").click(function(event){
		var isSure =  confirm('Do you really want to remove this stuff?');
		if(isSure){
			$.ajax({
				type: "POST",
				data: { _csrf : $("#csrf").val() },
				url: event.currentTarget.dataset.removeUrl})
				.done(function( msg ) {
					window.location.href = "/HybrisTask/cms/home"; // TODO for hard coded url
				});
		}
	});
	
	$("#add_comment").click(function(event){
		
		var id = $("#note").data("note-id");
		var email = $("#email").val();
		var content = $("#content").val();
		var host = window.location.host;
		
		$.ajax({
			type: "POST",
			data: { _csrf : $("#csrf").val(), "email":email, "content": content },
			url: "/HybrisTask/cms/note/"+id+"/comment/create"})
			.done(function( msg ) {
				//build a comment skeleton
				var comment = "<div class='alert alert-info' role='alert'>"
								+ "<strong>"+email+"</strong>"
								+ "<p>"+content+"</p>"
							+ "</div>";
				
				$("#content").val(""); //clear content of comment that was sent
				
				$("#comment-container").append(comment);
			}).fail(function() {
				//build an error skeleton
				var error_msg = "<div class='alert alert-danger' role='alert'>"
					+ "<button type='button' class='close' data-dismiss='alert'>x</button>"
					+ "<strong>Oh snap! </strong>"
					+ "<p>Change something and try submitting again.</p>"
				+ "</div>";
				$("#oh-snap").append(error_msg);
			});
		
	});
	
	$('.logout').click(function(){
		document.getElementById("logoutForm").submit();
	});

});