<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="header">
	<nav class="navbar navbar-inverse"> <!-- Collect the nav links, forms, and other content for toggling -->
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
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Videa <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/video/mobilevideo/1">Start
								testing</a></li>
					</ul>
				</li>
			</sec:authorize>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Test QoE<span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<!-- <li><a href="${pageContext.request.contextPath}/videa/aspen">aspen</a>
							</li> -->
					<li><a
						href="${pageContext.request.contextPath}/testvidea/questionnaire">Start
							testing</a>
					</li>
					<!-- <li><a
						href="${pageContext.request.contextPath}/videa/controlledBurn">controlled
							burn</a></li> -->
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Info<span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/presentation">Presentation</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/subjectiveqoe">Subjektivní
							QoE </a>
					</li>
					<li><a href="${pageContext.request.contextPath}/objectiveqoe">Objektivní
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
		<div class="col-sm-3 col-md-3">
			<form:form class="navbar-form" role="search" method="post"
				action="${pageContext.request.contextPath}/searchtesters">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Search testers" name="q">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form:form>
		</div>

		<sec:authorize access="isAnonymous()">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/login"><span
						class="glyphicon glyphicon-log-in"> Login</span> </a></li>
			</ul>
		</sec:authorize>

		<sec:authorize var="loggedIn" access="isAuthenticated()">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/logout"><span
						class="glyphicon glyphicon-log-in"> Logout</span> </a>
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