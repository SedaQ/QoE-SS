<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:videopagetemplate title="QoE">
	<jsp:attribute name="body">
	    <h1 class="page-header">
		  Děkujeme, že jste se účastnil testování, Vaše hodnocení bylo uloženo do databáze<small></small>
	    </h1>
	    <div class="form-group">
	    	<label>Pokud chcete spustit další scénář klikněte na tlačítko níže:</label>
	    </div>
	    <form:form method="GET"
				action="${pageContext.request.contextPath}/video/mobileretesting">
	    	<button type="submit" class="btn btn-primary">Spustit další scénář</button>
	    </form:form>
	    <div>
		    <br/>
		    <br/>
	    </div>
	</jsp:attribute>
</my:videopagetemplate>