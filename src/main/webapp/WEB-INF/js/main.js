$(function(){

	var $name=$('#name');
	var $email=$('#email');
	var $age=$('#age');
	var $password=$('#password');
	var $street=$('#street');
	var $city=$('#city');
	var $zip=$('#zip');
	var $state=$('#state');
	var $manufacturer=$('#manufacturer');
	var $modelno=$('#modelno');
	
	$('#signup').on('click', function(){
		console.log('called signup');
		var newperson={
				manufacturer: $manufacturer.val(),
				modelno: $modelno.val(),
				name: $name.val(),
				email: $email.val(),
				age: $age.val(),
				password: $password.val(),
				street: $street.val(),
				city: $city.val(),
				zip: $zip.val(),
				state: $state.val(),
				
				
		
		};
		console.log('afterjson'+newperson);
		$.ajax({
			type: 'POST',
			url: '/Snap-L-Earn/Newsignup',
			data: JSON.stringify(newperson),
			contentType: 'application/json',
			dataType: 'json',
			success: function(photos){
				alert("Details have been saved");
				window.location="http://localhost:8080/Snap-L-Earn/index.jsp";
//			},
//			error: function(){
//				alert("Error");
//			},
//			failure: function()
//			{
//				alert("Failure");
//			}
			}
	});
});
});