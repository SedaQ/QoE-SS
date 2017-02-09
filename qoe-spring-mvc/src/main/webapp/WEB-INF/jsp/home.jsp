<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:pagetemplate title="QoE">
	<jsp:attribute name="body">
	<h1 class="page-header">
		Vítejte na stránce zabývající se měřením subjektivního QoE <small></small>
	</h1>
	<section class="container">
			<article class="row">
			<div class="col-md-3">
				<h3>
					<a href="#">Subjektivní QoE</a>
				</h3>
				<p>Metody subjektivního QoE jsou založeny na hodnocení služeb samotnými pozorovateli, buď může jít o laboratorní testy, kde jsou pozorovatelé (lidé), 
				kteří hodnotí jednotlivé představené služby nebo může jít o hodnocení v rámci takzvaného crowdsourcingu. 
				Výsledky jsou poté vyhodnoceny (popřípadě ještě dodatečně korelovány a je z nich sestaveno Mean Opinion Score (MOS).
				Nevýhodou laboratorních testů je, že jsou zpravidla náročné na finanční, časové a lidské zdroje. Mezi nevýhody také patří, 
				že pozorovatel se může účastnit testovací události pouze jednou, protože pokud by se testů účastnil opakovaně, 
				tak by se zkresloval výsledek v rámci procesu ("učení se"). Výhodou subjektivního QoE je, že pokud jsou dodrženy veškeré podmínky, 
				tak je měření subjektivními metodami nejpřesnější ...
				</p>
				<a href="#" class="btn btn-primary" role="button">Přečtěte si více</a>
			</div>
			<div class="col-md-3">
				<h3>
					<a href="#">Objektivní QoE</a>
				</h3>
				<p>
				Objektivní QoE se vyhodnocuje zpravidla strojově, což vede na rozdíl od subjektivního QoE k menší náročnosti na lidské a finanční zdroje, 
				proto se někdy upřednostňují objektivní metody před subjektivními. Objektivní metody měření kvality se dají rozčlenit do 3 skupin:
				<ul>
					<li>plná reference,</li>
					<li>redukovaná reference,</li>
					<li>bez reference.</li>
				</ul>
				Některé z těchto metod jsou založeny na zahrnutí původního referenčního signálu v měření.
				Plná reference vyžaduje původní materiál v celku. 
				Operují na základě porovnávání původního s pozměněným či narušeným signálem k vypočítání degradace. 
				Výpočty této degradace se pohybují od jednoduchých algoritmů typu odhadu chyb v signálu k velmi 
				komplexním ...
				</p>
				<a href="#" class="btn btn-primary" role="button">Přečtěte si více</a>
			</div>
			<div class="col-md-3">
				<h3>
					<a href="#">Metody měření subjektivního QoE</a>
				</h3>
				<p>V současné době bylo publikováno poměrně velké množství metod měření subjektivního QoE.
				Jde o metody Crowdsourcing, Absolute Category Rating (ACR), Absolute Category Rating with hidden reference (ACR-HR), 
				Degradation Category Rating (DCR), Pair comparison method (PC), 
				The Double-Stimulus Continuous Quality-Scale method (DSCQS). 
				U všech těchto metod je vysvětlen jejich základní princip.
				<h4>Crowdsourcing</h4>
				Crowdsourcing je poměrně nová metoda používaná k získávání dat od velkého množství uživatelů, 
				kteří nejsou nuceni se účastnit laboratorních testů, jako je tomu v případě metod ACR, ACR-HR, DCR, 
				PC, DSCQS ...
				</p>
				<a href="#" class="btn btn-primary" role="button">Přečtěte si více</a>
			</div>
		</article>
	</section>
	</jsp:attribute>
</my:pagetemplate>