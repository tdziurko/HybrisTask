/*
 * All js here.
 */

$( document ).ready(function() {
	
	//TODO - I have no idea how to create more generic solution of adding this
	//csrf token - maybe tomorrow.
	
	$(".tresh").click(function(event){
		var isSure =  confirm('Do you really want to remove this stuff?');
		if(isSure){
			$.ajax({
				type: "POST",
				data: { _csrf : $("#csrf").val() },
				url: event.currentTarget.dataset.removeUrl})
				.done(function( msg ) {
					window.location.href = "/HybrisTask/cms/home";
				});
		}
	});
	
	$('.logout').click(function(){
		console.log("asdasd");
		document.getElementById("logoutForm").submit();
	});

});