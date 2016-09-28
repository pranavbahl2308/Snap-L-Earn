<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $('#test').click(function(){
    	var $name = $('#myDiv');
        $.ajax({
        	type:'GET',
        	contentType: "application/json; charset=utf-8",
        	url:'/Snap-L-Earn/fetchPhoto/'+$('#name').val(),
        	success: function(photos){
        		console.log(photos);
        		$.each(photos, function(i,photo){
        			$name.append('<li> photoid:'+photo.photoId+'</li>');
        		});
        	}
        	
        });
    });
});
</script>

</head>
<body>
	<c:url value="/showMessage.html" var="messageUrl" />
	<a href="${messageUrl}">Click to enter</a>
	<input type="text" id="name"/>
	<button type="button" id="test">Request data</button>
	<div id="myDiv"></div>
</body>
</html>