<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
			import="cd.java.springfun.ninjagold.Place, java.util.ArrayList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, shrink-to-fit=no">
	<title><c:out value="${title}" /></title>
    <link rel="stylesheet" href="webjars/bootstrap/4.6.0/css/bootstrap.min.css" />
	<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
</head>
<body>
	<main class="container">
		<h1 class="mb-4 pb-2 text-center"><c:out value="${title}" /></h1>
		<p class="lead">Your Gold: <c:out value="${ninjaGold}" /></p>
		<div class="card-deck mb-4">
			<c:forEach var="i" begin="0" end="${places.size()-1}">
				<div class="card card-body bg-light border-dark text-center">
					<h5 class="card-title"><c:out value="${places.get(i).getName()}" /></h5>
					<p class="card-text">(earns <c:out value="${places.get(i).getMinGold()}" /> - <c:out value="${places.get(i).getMaxGold()}" /> gold)</p>
					<form action="/submit" method="post">
						<input type="hidden" name="place" value="<c:out value="${places.get(i).getName()}" />">
							<button type="submit" class="btn btn-warning">Find Gold!</button>
					</form>
				</div>
			</c:forEach>
		</div>
		<p class="mb-0">Activities:</p>
		<div style="height: 340px; overflow-y: scroll;" class="mb-3 border border-dark">
			<c:forEach var="activity" items="${activities}">
				<p style="line-height: 1;" class="m-0 p-1 text-<c:out value="${activity.getColor()}" />"><c:out value="${activity.getMessage()}" /></p>
			</c:forEach>
		</div>
		<div class="m-2 p-2 row justify-content-end">
			<a class="btn btn-info" href="/reset">Reset</a>
		</div>
		<!-- <form action="/submit" method="post">
			<div class="header">
				<p class="error"><c:out value="${error}" /></p>
			</div>
			<div class="main">
				<div class="row">
					<label for="nameInput">Your Name:</label>
					<input id="nameInput" type="text" name="name">
				</div>
				<div class="row">
					<label for="locationSelect">Dojo Location:</label>
					<select id="locationSelect" name="location">
						<option value="Bellevue" selected>Bellevue</option>
						<option value="San Jose">San Jose</option>
						<option value="Dallas">Dallas</option>
					</select>
				</div>
				<div class="row">
					<label for="languageSelect">Favorite Language:</label>
					<select id="languageSelect" name="language">
						<option value="C#" selected>C#</option>
						<option value="Java">Java</option>
						<option value="Python">Python</option>
					</select>
				</div>
			</div>
			<div class="lower">
				<div class="div1">
					<label for="commentArea">Comment (optional):</label>
				</div>
				<div class="div2">
					<textarea id="commentArea" name="comment" rows="4"></textarea>
				</div>
			</div>
			<div class="footer">
				<button type="submit">Submit</button>
			</div>
		</form> -->
		<!-- <h1>What is the code?"</h1>
		<form action="/submit" method="post">
			<input type="text" name="code" />
			<button type="submit">Try Code</button>
		</form> -->
	</main>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <!-- <script src="webjars/bower/jquery/3.5.1/jquery.min.js"></script> -->
    <script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>