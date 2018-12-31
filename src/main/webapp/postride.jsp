<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="Avto Prevoz" content="">
    <meta name="JazzInc" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="rideForm" class="form-signin">
        <h2 class="form-signin-heading">Post a Ride!</h2>

        <spring:bind path="start">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="start" class="form-control" placeholder="Start"
                            autofocus="true"></form:input>
                <form:errors path="start"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="destination">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="destination" class="form-control" placeholder="Destination"></form:input>
                <form:errors path="destination"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="time">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="time" class="form-control"
                            placeholder="When"></form:input>
                <form:errors path="time"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="seats">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="seats" class="form-control" placeholder="Number of available seats"></form:input>
                        <form:errors path="seats"></form:errors>
                    </div>
                </spring:bind>

         <spring:bind path="price">
                     <div class="form-group ${status.error ? 'has-error' : ''}">
                         <form:input type="text" path="price" class="form-control" placeholder="Price"></form:input>
                         <form:errors path="price"></form:errors>
                     </div>
                 </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
