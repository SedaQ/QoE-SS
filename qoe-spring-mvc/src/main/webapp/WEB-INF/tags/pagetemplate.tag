<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs"
	trimDirectiveWhitespaces="true"%>
<%@ attribute name="title" required="false"%>
<%@ attribute name="subtitle" required="false"%>
<%@ attribute name="head" fragment="true"%>
<%@ attribute name="body" fragment="true" required="true"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="${pageContext.request.locale}">
<!--  head starts -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><c:out value="${title}" />
</title>

<link href="<c:url value="/assets/bootstrap/css/bootstrap.css"/>"
	type="text/css" rel="stylesheet" media="all">
<!-- Custom Theme files -->

<meta name="keywords"
	content="Mentors Responsive Web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web template, 
			Smartphone Compatible Web template, free Webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola Web design" />

<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Julius+Sans+One'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Candal' rel='stylesheet'
	type='text/css'>
<link href='//fonts.googleapis.com/css?family=Roboto+Slab'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!--/fonts-->
<!--//end-animate-->
<jsp:invoke fragment="head" />
</head>
<!-- head ends -->

<body>
	<!--header-->
	<div class="header">
		<nav class="navbar navbar-inverse">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/home">Quality of
						Experience</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="${pageContext.request.contextPath}/home">Home</a>
					</li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Videa <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<!-- <li><a href="${pageContext.request.contextPath}/videa/aspen">aspen</a>
							</li> -->
							<li><a
								href="${pageContext.request.contextPath}/videa/aspenvidea">aspen
									videa</a></li>
							<!-- <li><a
						href="${pageContext.request.contextPath}/videa/controlledBurn">controlled
							burn</a></li> -->
						</ul>
					</li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Test QoE<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<!-- <li><a href="${pageContext.request.contextPath}/videa/aspen">aspen</a>
							</li> -->
							<li><a
								href="${pageContext.request.contextPath}/testvidea/questionnaire">Start
									testing</a></li>
							<!-- <li><a
						href="${pageContext.request.contextPath}/videa/controlledBurn">controlled
							burn</a></li> -->
						</ul>
					</li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Info<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/presentation">Presentation</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/subjectiveqoe">Subjektivní
									QoE </a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/objectiveqoe">Objektivní
									QoE </a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/qoemeasurement">Měření
									subjektivního QoE </a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/resultcorrelation">Korelace
									výsledků</a>
							</li>
							<li><a href="${pageContext.request.contextPath}/fullthesis">DP
									práce </a>
							</li>
						</ul>
					</li>
					<!-- <li><a href="${pageContext.request.contextPath}/presentation">Presentation</a></li> -->
					<li><a href="${pageContext.request.contextPath}/about">About</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/contact">Contact</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/statistics">Statistics</a>
					</li>
				</ul>

				<sec:authorize access="isAnonymous()">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath}/login"><span
								class="glyphicon glyphicon-log-in"> Login</span> </a></li>
					</ul>
				</sec:authorize>

				<sec:authorize var="loggedIn" access="isAuthenticated()">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath}/logout"><span
								class="glyphicon glyphicon-log-in"> Logout</span>
						</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath}/userDetail">

								<c:choose>
									<c:when test="${loggedIn}">
										<%=request.getUserPrincipal().getName()%>
									</c:when>
								</c:choose> </a></li>
					</ul>
				</sec:authorize>

			</div>
		</nav>

	</div>
	<!--//header-->

	<div class="container">
		<!-- page body -->
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<!-- page body -->
				<jsp:invoke fragment="body" />
			</div>
		</div>

	</div>

	<script type="application/x-javascript">
		 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
	<!-- //Custom Theme files -->

	<!-- js -->
	<script src="<c:url value="/assets/bootstrap/js/bootstrap.js"/>"></script>
	<!-- -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value="/assets/js/jquery-1.11.1.min.js"/>"></script>
	<script src="<c:url value="/assets/js/scripts.js"/>"></script>

</body>
</html>