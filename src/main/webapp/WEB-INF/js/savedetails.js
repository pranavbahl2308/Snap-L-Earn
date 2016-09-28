$(function(){
	$('#savebtn').on('click',function(){
		var $editProfileRequestBean={
				manufacturer:$('#manufacturer').val(),
				modelno:$('#modelno').val(),
				name:$('#name').val(),
				age:$('#age').val(),
				email:$('#age').val(),
				street:$('#street').val(),
				city:$('#city').val(),
				state:$('#state').val(),
				zip:$('#zip').val(),
				password:$('#password').val(),
		};
		
		$.ajax({
			type:'POST',
			url: '/Snap-L-Earn/editProfile',
			data: JSON.stringify(editProfileRequestBean),
			contentType: 'application/json',
			dataType: 'json',
			success:function(data){
				alert('Your Details have been saved');
			}
			
			
		});
		
	});
});