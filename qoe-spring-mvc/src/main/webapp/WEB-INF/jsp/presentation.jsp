<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>QoE Presentation</title>
<link rel="stylesheet"
	href="<c:url value="assets/reveal/css/reveal.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/reveal/css/theme/default.css"/>" id="theme">
<script src="<c:url value="/assets/reveal/lib/js/html5shiv.js"/>"></script>

<link href="<c:url value="/assets/bootstrap/css/bootstrap.css"/>"
	type="text/css" rel="stylesheet" media="all">
<!--fonts-->
</head>


<body>
	<!--header-->
	<jsp:include page="common/header.jsp" />
	<!--//header-->

	<!-- Wrap the entire slide show in a div using the "reveal" class. -->
	<div class="reveal">
		<div class="slides">
			<!-- ALL SLIDES GO HERE -->
			<!-- Each section element contains an individual slide -->
			<section>
				<h1>QoE</h1>
				<p>Jde o diplomovou práci, která se zabývá kvalitou zážitku u
					streamovaných videí z kvality zážitku</p>
			</section>

			<section id="show-a-link">
				<h1>Členové teamu</h1>
				<p>Student: Bc. Pavel Šeda</p>
				<p>Vedoucí práce: Ing. Dominik Kováč
				<p>
			</section>

			<section>
				<h1>Princip QoE</h1>
				<ul class="slide-menu-items">
					<li>tst</li>
					<li>tst</li>
					<li>tst</li>
				</ul>
				<p>$$x = {-b \pm \sqrt{b^2-4ac} \over 2a}.$$</p>
				<p>
					Visit internal slide<a href="#/show-a-link"> 2</a>
				<p></p>
			</section>

		</div>
	</div>

	<script src="<c:url value="/assets/reveal/lib/js/head.min.js"/>"></script>
	<script src="<c:url value="/assets/reveal/js/reveal.min.js"/>"></script>


	<script>
		// Required, even if empty.
		Reveal.initialize({

			dependencies : [
			// MathJax
			{
				src : 'assets/reveal/plugin/math/math.js',
				async : true
			} ]
		});
	</script>

</body>
</html>
