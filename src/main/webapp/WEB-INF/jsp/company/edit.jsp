<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>Edit Company</title>

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
	</head>

	<body>

		<%@include file="../includes/nav.jsp" %>

		<div class="container">
			<div>
				<h1>Create Company</h1>

        <form id = "person" action="${pageContext.request.contextPath}/person/edit" method="POST">
		        <br/>
                <label for="companyName">First Name:</label>
                <input type="text" name="companyName" value="${company.companyName}"/>
                <br/>
                <label for="webUri">Website:</label>
                <input type="text" name="webUri" value="${company.webUri}"/>
                <br/>
                <label for="streetAddress">Street Address:</label>
                <input type="text" name="streetAddress" value="${company.streetAddress}"/>
                <br/>
                <label for="city">City:</label>
                <input type="text" name="city" value="${company.city}"/>
                <br/>
                <label for="state">State:</label>
                <input type="text" name="state" value="${company.state}"/>
                <br/>
                <label for="zipCode">Zip Code:</label>
                <input type="text" name="zipCode" value="${company.zipCode}"/>
                <br/>
                <input type="submit" name="Submit" value="Submit"/>
		       </form>
		   </div>
		</div><!-- /.container -->


		<script type="text/javascript">
			$(document).ready(function () {
				$('#company').validate({
					rules: {
						companyName: {
							required: true,
							minlength: 1,
							maxlength: 50
						},
						website: {
							required: true,
							minlength: 1,
							maxlength: 50
						},
						phoneNumber: {
							required: true,
							minlength: 10,
							maxlength: 10,
							digits: true
						},
						streetAddress: {
							required: true,
							minlength: 1,
							maxlength: 50
						},
						city: {
							required: true,
							minlength: 1,
							maxlength: 50
						},
						state: {
							required: true,
							minlength: 2,
							maxlength: 2
						},
						zipCode: {
							required: true,
							minlength: 5,
							maxlength: 5,
							digits: true
						}
					}
				});
			});
		</script>
	</body>
</html>