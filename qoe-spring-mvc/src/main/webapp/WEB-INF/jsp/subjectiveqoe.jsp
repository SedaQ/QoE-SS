<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:pagetemplate title="QoE">
	<jsp:attribute name="head">
		<script type="text/x-mathjax-config">
	  		MathJax.Hub.Config({tex2jax: {inlineMath: [['$','$'], ['\\(','\\)']]}});
		</script>
		<script type="text/javascript"
			src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML">
			
		</script>
	</jsp:attribute>

	<jsp:attribute name="body">
	<h1 class="page-header">
		Subjektivní QoE <small></small>
	</h1>
	Metody subjektivního QoE jsou založeny na hodnocení služeb samotnými pozorovateli, buď může jít o laboratorní testy, kde jsou pozorovatelé (lidé), 
	kteří hodnotí jednotlivé představené služby nebo může jít o hodnocení v rámci takzvaného crowdsourcingu.
	 Výsledky jsou poté vyhodnoceny (popřípadě ještě dodatečně korelovány a je z nich sestaveno Mean Opinion Score (MOS).
Nevýhodou laboratorních testů je, že jsou zpravidla náročné na finanční, časové a lidské zdroje.
 Mezi nevýhody také patří, že pozorovatel se může účastnit testovací události pouze jednou, protože pokud by se testů účastnil opakovaně,
  tak by se zkresloval výsledek v rámci procesu ("učení se").
Výhodou subjektivního QoE je, že pokud jsou dodrženy veškeré podmínky, tak je měření subjektivními metodami nejpřesnější ze všech současných způsobů měření, 
to je důvodem, proč se tyto metody často používají jako referenční metody u nových zařízení, multimediálních kodeků.
				
	<div>
		<br></br>
	</div>
	</jsp:attribute>
</my:pagetemplate>