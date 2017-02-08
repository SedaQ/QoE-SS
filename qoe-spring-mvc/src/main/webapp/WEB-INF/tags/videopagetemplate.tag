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

<jsp:invoke fragment="head" />
</head>
<body>
	<!-- page body -->
	<jsp:invoke fragment="body" />
	
</body>
</html>