<%-- 
    Document   : edit
    Created on : Apr 22, 2011, 3:04:46 PM
    Author     : FMilens
--%>

<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Person</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
    </head>
    <body>
        <h1>Edit Person</h1>

        <form id = "person" action="${pageContext.request.contextPath}/person/edit" method="POST">
            <input type="hidden" name="personId" value="${person.personId}"/>
            <br/>
            <label for="firstName">First Name:</label>
            <input type="text" name="firstName" value="${person.firstName}"/>
            <br/>
            <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" value="${person.lastName}"/>
            <br/>
            <label for="emailAddress">Email Address:</label>
            <input type="text" name="emailAddress" value="${person.emailAddress}"/>
            <br/>
            <label for="streetAddress">Street Address:</label>
            <input type="text" name="streetAddress" value="${person.streetAddress}"/>
            <br/>
            <label for="city">City:</label>
            <input type="text" name="city" value="${person.city}"/>
            <br/>
            <label for="state">State:</label>
            <input type="text" name="state" value="${person.state}"/>
            <br/>
            <label for="zipCode">Zip Code:</label>
            <input type="text" name="zipCode" value="${person.zipCode}"/>
            <br/>
            <input type="submit" name="Submit" value="Submit"/>
        </form>
    </body>

    <script type="text/javascript">
         $(function() {
        	 $.validator.addMethod("customemail",
        			    function(value, element) {
        			        return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value);
        			    },
        			    "Invalid email format"
        			);
          $("#person").validate({
            rules: {
              firstName: {
                required: true,
                minlength: 1,
                maxlength: 50
              },
              lastName: {
                required: true,
                minlength: 1,
                maxlength: 50
              },
              emailAddress: {
                required: true,
                minlength: 1,
                maxlength: 50
              },
              phoneNumber: {
                  required: true,
                  minlength: 10,
                  maxlength: 10,
                  digits: true
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
</html>
