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
		<script type="text/x-mathjax-config">
			MathJax.Hub.Config({
		      "HTML-CSS": { linebreaks: { automatic: true } },
       	      SVG: { linebreaks: { automatic: true } }
			});
	    </script>
	</jsp:attribute>

	<jsp:attribute name="body">
			<h1 class="page-header">
		Metody měření subjektivního QoE <small></small>
	</h1>
	V současné době bylo publikováno poměrně velké množství metod měření subjektivního QoE. 
	V této práci budou nastíněny metody, které patří mezi nejpoužívanější měřicí metody subjektivního QoE současnosti. 
	Jde o metody Crowdsourcing, Absolute Category Rating (ACR), Absolute Category Rating with hidden reference (ACR-HR),
	 Degradation Category Rating (DCR), Pair comparison method (PC), The Double-Stimulus Continuous Quality-Scale method (DSCQS).
	 <h3>Crowdsourcing</h3>
	 Crowdsourcing je poměrně nová metoda používaná k získávání dat od velkého množství uživatelů, 
	 kteří nejsou nuceni se účastnit laboratorních testů, jako je tomu v případě metod ACR, ACR-HR, DCR, PC, DSCQS aj. 
	 Crowdsourcing je založen na drobných operacích prováděných prostřednictvím služeb na internetu, které jsou snadno splnitelné:
	 <ul>
	 	<li>napsat článek / blok / komentář,</li>
	 	<li>umístit banner nebo link na webovou stránku,</li>
	 	<li>nahrát/stáhnout média,</li>
	 	<li>využívat služby sociálních sítí,</li>
	 	<li>instalovat software,</li>
	 	<li>provést YouTube Stalling test.</li>
	 </ul>
	 Mezi výhody crowdsourcingu oproti běžným laboratorním testům pro získávání dat pro studie subjektivního QoE patří široké spektrum uživatelů, 
	 rozmanitost uživatelů (např. z jiných geografických lokací nebo výrazně rozdílný věk atd.),
	 uživatelské studie mohou být provedeny v krátkém čase, nízké náklady v porovnání s laboratorními testy a
	 testování QoE pro internetové aplikace s reálnými nastaveními.
	 <ul>
	 	<li>online zlepšování pověsti / dobrého jména dané služby,</li>
	 	<ul>
	 		<li>hodnocení pro videa nebo články,</li>
	 		<li>pozitivní hodnocení profilu na základě hlasování,</li>
	 	</ul>
	 	<li>hodnocení obrázků,</li>
	 	<li>získávání nových uživatelů / využívání nových platforem,</li>
	 	<li>online reklamy / optimalizace vyhledávacích nástrojů,</li>
	 	<ul>
	 		<li>umisťování informací na twitter,</li>
	 		<li>tvorba zpětných odkazů,</li>
	 	</ul>
	 	<li>uživatelské dotazníky pro marketing / QoE studie,</li>
	 	<li>vytváření obsahů,</li>
	 	<ul>
	 		<li>příspěvky na fórech či blozích,</li>
	 		<li>články,</li>
	 	</ul>
	 	<li>výzkum a vývoj.</li>
	 </ul>
	 Z bodů výše vidíme, že crodwsourcing je často používaná metoda skýtající mnoho výhod, 
	 avšak k jejím rizikům patří možnost ovlivňování komunity, jednostranná zaměřenost komunity atd., 
	 což může vést k irelevantním výsledkům. V takovém případě nepřinese Crowdsourcing názorový průměr, ale názory jednotlivců, 
	 proto je vhodné provádět i laboratorní testy, které jsou popsány níže.
	 
	 <h3>Absolute Category Rating (ACR)</h3>
	 Absolute Category Rating (ACR) je metoda, při které jsou testované sekvence prezentovány lidskému subjektu jedna po druhé a poté jsou sekvence nezávisle hodnoceny na stupnici přiřazené dané kategorii (tato metoda se také nazývá metoda jediného stimulu). Subjekty jsou požádány, aby po zhlédnutí nebo poslechu ohodnotily kvalitu prezentace a to na základě očekáváné úrovně kvality pro danou sekvenci.
Časový průběh testování metodou ACR je vidět na obrázku níže. Pokud je zvoleno konstantní hodnocení pak by hodnotící čas měl být menší nebo rovno 10 s. Doba prezentace sekvence může být redukována nebo zvyšována v závislosti na obsahu testovaného materiálu.
	 
    <img src="${pageContext.request.contextPath}/assets/img/ACR.png"
			class="img-responsive" alt="Cinque Terre" width="750" height="550"> 
    
kde:
\begin{align*}
    &A_i: &&\text{Sekvence $A$ za testovacích podmínek $i$}\\
    &B_j: &&\text{Sekvence $B$ za testovacích podmínek $j$}\\
    &C_k: &&\text{Sekvence $C$ za testovacích podmínek $k$}   
\end{align*}
	 
	 Nejčastěji se používá pětiúrovňová stupnice hodnocení pro celkovou kvalitu. Tato stupnice je znázorněna v tabulce níže.
	   <table class="table table-bordered">
	    <tbody>
	      <tr>
	        	<td>5</td>
				<td>Excellent (vynikající)</td>
	       </tr>
	       <tr>
	       		<td>4</td>
				<td>Good (dobrá)</td>
			</tr>
     	    <tr>
	       		<td>3</td>
				<td>Fair (průměrná)</td>
			</tr>
     	    <tr>
	       		<td>2</td>
				<td>Poor (špatná)</td>
			</tr>
     	    <tr>
	       		<td>1</td>
				<td>Bad (mizerná)</td>
			</tr>
	    </tbody>
	  </table>
	 Je-li požadováno vyšší rozlišení hodnocení, pak se používají 9 nebo 11úrovňové hodnocení.
	 
	 <h3>Absolute Category Rating with hidden reference (ACR-HR)</h3>
	 Tato metoda je založena na principu posuzování, kdy je subjektu předkládán jeden vzorek, který je následně nezávisle hodnocen dle dané stupnice. Předložená testovaná sekvence musí zahrnovat i referenční verzi každé sekvence. Toto je nazýváno hidden reference condition. Při analýze dat bude hodnocena kvalita mezi každou testovací sekvencí a jí odpovídající referenční sekvenci. Tato metoda je známá jako hidden reference.
	Metoda určuje, že subjekt hodnotí kvalitu prezentované sekvence po každé prezentaci.
	
	Je-li použit konstantní hodnotící čas (několik subjektů se kouká současně), pak by čas pro hodnocení měl být menší nebo roven 10 s. Čas prezentace může být zkrácen nebo prodloužen a to na základě obsahu testovaného materiálu. Pro tento typ hodnocení by měla být použita 5stupňová stupnice. DV za použití následující rovnice:
	\begin{equation}
	    DV(PVS)=V(PVS)-V(REF)+5
	\end{equation}
	kde:
	V – ACR hodnocení subjektu
	
	V této rovnici odpovídá DV hodnota 5 vznikající kvalitě a DV hodnota 1 odpovídá špatné kvalitě. Jakákoliv hodnota vyšší než 5, (když hodnocená sekvence je hodnocena lepší kvalitou než skrytá referenční sekvence), bude obecně považována za platnou. Alternativně může být použita 2point crushing function k zabránění těmto individuálním ACR-HR hodnocením (DV) neoprávněně ovlivňovat mean opinion score:
	\begin{equation}
	    Crushed_{DV} = (7\cdot DV)/(2+DV) \text{ kde } DV > 5
	\end{equation}
	Je-li požadováno vyšší rozlišení, pak je použita 9stupňová stupnice ACR.
	
	Pro metodu ACR-HR se získá potřebný počet replikací opakováním stejné zkušební podmínky v různých časových intervalech během trvání testu. Tato metoda by měla být použita pouze s referenčním videem (sekvencí), která je experty v dané oblasti hodnocena jako dobrá nebo vynikající kvalita na výše zmíněné 5stupňové škále.
	
	Metoda ACR-HR nemusí být vhodná pro analýzu neobvyklých zhoršení kvality vyskytujících se v první a poslední sekundě sekvence. Neobeznámenost subjektu s referenční sekvencí může způsobit, že jinak zřejmá poškození budou přehlédnuta (sekvence se zastaví těsně před koncem, subjekt nemusí být schopen rozeznat zda se jedná o záměr nebo chybu sítě).
	
	Differential viewer scores (DV) jsou kalkulovány na subjekt a zprocesovanou videosekvenci. Odpovídající hidden reference (REF) je použita pro kalkulaci
	
	Differential viewer scores (DV) jsou kalkulovány na subjekt a zprocesovanou videosekvenci.
	 
	
	<h3>Degradation Category Rating (DCR)</h3>
	V metodě Degradation Category Rating (DCR) jsou testované sekvence uvedeny v párech. První stimul v každé dvojici je vždy zdrojový bez jakýchkoliv vad. Druhý z páru je ze stejného zdroje, ale zhoršen zkušebními podmínkami (tato metoda se také nazývá Double Stimulus Impairment Scale (DSIS)). 
	Časový průběh testování metodou DCR je vidět na obrázku níže:

	<img src="${pageContext.request.contextPath}/assets/img/DCR.png"
			class="img-responsive" alt="Cinque Terre" width="750" height="550"> 
	
	kde:
	\begin{align*}
	    &A_i: &&\text{Sekvence $A$ za testovacích podmínek $i$}\\
	    &A_r, B_r: &&\text{Sekvence $A$  a $B$ v referenčním zdrojovém formátu $j$}\\
	    &B_j: &&\text{Sekvence $B$ za testovacích podmínek $j$}   
	\end{align*}
		
	Doba hodnocení by měla, i v tomto případě, být menší nebo rovna 10 sekund. V tomto případě jsou subjekty žádány, 
	aby ohodnotili zhoršení druhého vzorku ve srovnání se vzorkem zdrojovým. 
	Nejrozšířenější stupnicí pro toto hodnocení je opět 5úrovňová stupnice. 
	V podstatě lze pro toto hodnocení použít jakákoli stupnice použitá při metodě ACR, pouze je nutno zaměnit hodnotící parametry.
	 Prezentační čas může být redukován nebo zvýšen v závislosti na obsahu testovaného materiálu stejně jako u metody ACR.
	 
	 	   <table class="table table-bordered">
	    <tbody>
	      <tr>
	        	<td>5</td>
				<td>Imperceptible (nepatrné)</td>
	       </tr>
	       <tr>
	       		<td>4</td>
				<td>Perceptible but no annoying (znatelné, ale ne nepříjemné)</td>
			</tr>
     	    <tr>
	       		<td>3</td>
				<td>Slightly annoying (mírně nepříjemné)</td>
			</tr>
     	    <tr>
	       		<td>2</td>
				<td>Annoying (nepříjemné)</td>
			</tr>
     	    <tr>
	       		<td>1</td>
				<td>Very annoying (velmi nepříjemné)</td>
			</tr>
	    </tbody>
	  </table>

	<h3>Pair comparison method (PC)</h3>
	Metoda pair comparison zahrnuje, že testované sekvence jsou prezentovány v párech, 
	sestavených ze stejné sekvence prezentované nejprve jedním testovaným systémem a následně dalším systémem.
	Testované systémy (A, B, C) jsou zpravidla kombinovány ze všech možných systémů $n(n-1)$ kombinací AB, BA, CA atd. 
	Takto by všechny testované páry měly být prezentovány v obou možných pořadích (AB, BA).
	Po každém páru se hodnotí, který element dvojice je preferován v rámci zkušebního scénáře. 
    Je-li použit konstantní hodnotící čas (několik subjektů se kouká současně), pak by čas pro hodnocení měl být menší nebo roven 10 s.
    Čas prezentace může být zkrácen nebo prodloužen a to na základě obsahu testovaného materiálu. 
    Časový průběh testování metodou ACR je vidět na obrázku níže.
	
	<img src="${pageContext.request.contextPath}/assets/img/PC.png"
			class="img-responsive" alt="Cinque Terre" width="750" height="550"> 
	Použije-li se menší rozlišení (CIF, QCIF, SIF), je vhodné zobrazit každý pár sekvencí současně na stejném monitoru.
	 Pro PC metodu není obecně stanoveno počet opakování, a to protože metoda sama o sobě obsahuje opakované prezentace sekvencí se stejnými podmínkami, 
	 ačkoliv v různých párech. Různé variace metody PC využívají kategorické měřítko pro další měření rozdílů mezi páry sekvenci.
	 <div>
			<br></br>
	</div>

			
	</jsp:attribute>
</my:pagetemplate>