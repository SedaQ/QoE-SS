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
				href="${pageContext.request.contextPath}/home">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Videa <span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<!-- <li><a href="${pageContext.request.contextPath}/videa/aspen">aspen</a>
					</li> -->
					<li><a href="${pageContext.request.contextPath}/videa/aspenvidea">aspen videa</a>
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
							QoE </a></li>
					<li><a href="${pageContext.request.contextPath}/objectiveqoe">Objektivní
							QoE </a></li>
					<li><a
						href="${pageContext.request.contextPath}/qoemeasurement">Měření
							subjektivního QoE </a></li>
					<li><a
						href="${pageContext.request.contextPath}/resultcorrelation">Korelace
							výsledků</a></li>
					<li><a href="${pageContext.request.contextPath}/fullthesis">DP
							práce </a></li>
				</ul></li>
			<!-- <li><a href="${pageContext.request.contextPath}/presentation">Presentation</a></li> -->
			<li><a href="${pageContext.request.contextPath}/about">About</a>
			</li>
			<li><a href="${pageContext.request.contextPath}/contact">Contact</a>
			</li>
			<li><a href="${pageContext.request.contextPath}/statistics">Statistics</a>
			</li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="${pageContext.request.contextPath}/logout"><span
					class="glyphicon glyphicon-log-in"> Logout</span> </a></li>
		</ul>
	</div>
	</nav>

</div>