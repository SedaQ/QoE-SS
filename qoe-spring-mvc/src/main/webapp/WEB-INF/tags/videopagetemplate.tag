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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><c:out value="${title}" /></title>
<link href="<c:url value="/assets/bootstrap/css/bootstrap.css"/>"
	type="text/css" rel="stylesheet" media="all">

<jsp:invoke fragment="head" />
</head>
<body>
	<div class="container">
		<!-- page body -->
		<div class="row">
			<div class="col-md-12">
				<!-- page body -->
				<jsp:invoke fragment="body" />
			</div>
		</div>
	</div>
	
	<!-- js -->
	<script src="<c:url value="/assets/bootstrap/js/bootstrap.js"/>"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value="/assets/js/jquery-1.11.1.js"/>"></script>
	<script src="<c:url value="/assets/js/scripts.js"/>"></script>
	
</body>
</html>