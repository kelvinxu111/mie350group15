<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Date Picker Javascript -->
<!-- https://jqueryui.com/datepicker/ -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<title>Hello world!</title>
</head>
<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Welcome!</h1>
				<p>This is a project made by students in the MIE350 course at the University of Toronto. <br/>
				If you happen to come across this somehow, please be respectful and do not share this site with your friends, as it is still in progress. Regardless, please enjoy it once it's done!</p>
				<br/>
				<b>This web application is the intellectual property of:</b>
				<ul>
					<li>Jinming Xu
					<li>Marc Sun
					<li>Xinyuan Zhang
					<li>Sicheng Sun
					<li>Shuxian Li
					<li>Zhi Zhu
					<li>Ziwei Xu
				</ul> 
				<br/>
				Below is a table from the database, to prove this webapp can connect to the DB.
				<table border=1 class="sortable">
					<thead>
						<tr>
							<th>Member Id</th>
							<th>Last Name</th>
							<th>First Name</th>
							<!-- th>DOB</th -->
							<th>Email</th>
							<th>Age</th>
							<th>Type</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${members}" var="Member">
							<tr>
								<td align="center"><c:out value="${Member.getMemberid()}" /></td>
								<td align="center"><c:out value="${Member.getLastName()}" /></td>
								<td align="center"><c:out value="${Member.getFirstName()}" /></td>
								<td align="center"><c:out value="${Member.getEmail()}" /></td>
								<td align="center"><c:out value="${Member.getAge()}" /></td>
								<td align="center"><c:out value="${Member.isMod()}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p> Here is the future login feature, but has not been successfully implemented yet, so please don't click it.</p>
				<!--this search below is not yet functional  --> 
				<form action="search">
				First Name<input type="text" fname="firstname">
				Last Name<input type="text" lname="lastname">
				<input type="submit" value="submit">
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>	
				
</form>
</body>

</html>