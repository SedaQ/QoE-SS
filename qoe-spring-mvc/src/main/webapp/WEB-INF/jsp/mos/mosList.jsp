<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>

<my:pagetemplate title="QoE Mos">
	<jsp:attribute name="body">
			<h1 class="page-header">
				List of all mos <small></small>
			</h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>mosValue</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${mos}" var="m">
						<tr>
							<td><c:out value="${m.id}" /></td>
							<td><c:out value="${m.value}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</jsp:attribute>
</my:pagetemplate>
