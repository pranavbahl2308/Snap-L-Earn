$(function(){

	var $email=$('#email');
	var $password=$('#password');
	
	$('#loginsubmit').on('click', function(){
		console.log('called signup');
		var loginRequestBean={
				email: $email.val(),
				password: $password.val(),
		};
		console.log('afterjson'+loginRequestBean);
		$.ajax({
			type: 'POST',
			url: '/Snap-L-Earn/login',
			data: JSON.stringify(loginRequestBean),
			contentType: 'application/json',
			dataType: 'json',
			success: function(signUpResponse){
				var uid=signUpResponse.userId;
				var status=signUpResponse.status;
				if(status=="SUCCESS"){
				window.location="http://localhost:8080/Snap-L-Earn/UserProfile.jsp";
				}
				else
					{
						$('#msg').text("Please enter valid details.");
					}
					
			},
			error: function(){
				alert("Error");
			},
			failure: function()
			{
				alert("Failure");
			}
		});
	});
});