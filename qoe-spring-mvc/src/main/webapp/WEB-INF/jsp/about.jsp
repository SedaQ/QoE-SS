<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Quality of Experience About</title>
<%@ include file="common/head.jsp"%>
</head>
<body>
	<!--header-->
	<jsp:include page="common/header.jsp" />
	<!--//header-->

	<!-- Page Content -->
	<div class="container">

		<!-- Introduction Row -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					About Us <small></small>
				</h1>
				<p>Lorem ipsum dolor sit amget, consectetur adipisicing elit.
					Sint, explicabo dolores ipsam aliquam inventore corrupti eveniet
					quisquam quod totam laudantium repudiandae obcaecati ea consectetur
					debitis velit facere nisi expedita vel?</p>
			</div>
		</div>

		<!-- Team Members Row -->
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Our Team</h2>
			</div>
			<div class="col-lg-4 col-sm-6 text-center">
				<img class="img-circle img-responsive img-center"
					src="http://placehold.it/200x200" alt="">
				<h3>Pavel Šeda <small>Student</small></h3>
				
				<p>Student working on his diploma thesis</p>
			</div>
			<div class="col-lg-4 col-sm-6 text-center">
				<img class="img-circle img-responsive img-center"
					src="http://placehold.it/200x200" alt="">
				<h3>Dominik Kováč <small>Teacher - Supervisor</small></h3>
				<p>Teacher which leads Pavel Šeda diploma thesis, giving advices etc.</p>
			</div>
		</div>
		<hr>
	</div>

</body>
</html>