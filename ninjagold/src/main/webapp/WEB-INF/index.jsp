<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="container">
		<form action="/submit" method="post">
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
		</form>
		<!-- <h1>What is the code?"</h1>
		<form action="/submit" method="post">
			<input type="text" name="code" />
			<button type="submit">Try Code</button>
		</form> -->
	</div>
</body>
</html>