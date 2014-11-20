/*
 * All js here.
 */
var asd;
$( document ).ready(function() {
	
	//TODO - I have no idea how to create more generic solution of adding this
	//csrf token.
	
	function writeToDateFiltrSidebar(entry){
		$( "#date-filtr" ).append("<li><a class='element' data-date='"+entry+"' href='#'>{"+entry+"}</a></li>");
	}
	
	function FulfilDateSidebarCallback(available_date){
		available_date.forEach(function(entry) {
			writeToDateFiltrSidebar(entry);
		});	
		
		//bind onClick to all new elements
		$(".element").click(function(event){
			asd = event;
			$.ajax({
				type: "POST",
				data: { _csrf : $("#csrf").val(), "date": event.currentTarget.dataset.date },
				url: "/HybrisTask/notes/filtr/"})
				.done(function(msg) {
					/*
					 * Here I receive all notes from a specific  day,
					 * but I have no idea how i can present it...
					 */
				});	
		});
		
	}
	
	//get available dates, available means that this month contain at least one note
	if($("#date-filtr")){
		var available_date = [];
		$.ajax({
			type: "POST",
			data: { _csrf : $("#csrf").val() },
			url: "/HybrisTask/notes/avaiable-dates/"})
			.done(function(available_date) {
				FulfilDateSidebarCallback(available_date);
			});
	}

	
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