<%@ include file="common/headerBootstrap.jspf"%>
<link href="${contextPath}/resources/css/flipside.css" rel="stylesheet"
	type="text/css" />

<link href="${contextPath}/resources/css/flipside_evento.css" rel="stylesheet"
	type="text/css" />

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>ACCOUNT</h1>
		</div>
	</div>
</section>



<c:forEach items="${User}" var="user" varStatus="tagStatus">
	<article class="single">
		<div class="single_copy">
			<h2 class="single_copy_title">INFORMAZIONI
				UTENTE</h2>
			<br>

			<p class="single_copy_meta2">
				<strong>Nome : </strong>&emsp;${user.username}
			</p>

			<p class="single_copy_meta2">
				<strong>Cognome : </strong>&emsp;${user.cognome}
			</p>

			<p class="single_copy_meta2">
				<strong>Citta : </strong>&emsp;${user.citta}
			</p>

			<p class="single_copy_meta2">
				<strong>Email : </strong>&emsp;${user.email}
			</p>

			<p class="single_copy_meta2">
				<strong>Preferenza 1 : </strong>&emsp;${user.preferenceUno}
			</p>

			<p class="single_copy_meta2">
				<strong>Preferenza 2 : </strong>&emsp;${user.preferenceDue}
			</p>

			<p class="single_copy_meta2">
				<strong>Preferenza 3 : </strong>&emsp;${user.preferenceTre}
			</p>

			<p class="single_copy_meta2">
				<strong>Lista amici : <c:forEach items="${amici}"
						var="user" varStatus="tagStatus">
						<a
							href="${contextPath}/eventView/account?nomeUser=${user.username}"></strong>&emsp;${user.username}&emsp;|</a>
</c:forEach>
</p>
<br>
<!-- <p class="centro"> -->

<a href="${contextPath}/modifyAccount"
	class="button_dettagli_account allinea allinea_modifica_account">MODIFICA ACCOUNT</a>
<div class="btn allinea allinea2">
	<div class="btn-back allinea allinea2">
		<p>Are you sure you want to do that?</p>
		<button class="yes"
			onclick="location.href='${contextPath}/account/deleteMe';">Yes</button>
		<button class="no">No</button>
	</div>
	<div class="btn-front allinea allinea2">ELIMINA ACCOUNT</div>
</div>
<br>
<br>
<br>
<p class="nascondi">
	<a href="${contextPath}/account/deleteMe" class="button_elimina_account">ELIMINA ACCOUNT</a>
</p>
<br>
<!-- </p> -->
<br>


</div>

</article>
</c:forEach>



<section class="cards clearfix">
	<h1>EVENTI A CUI TI SEI UNITO</h1>
	<c:forEach items="${Events}" var="event" varStatus="tagStatus">
		<div class="card">
			<img class="card_image"
				src="${contextPath}/resources/images/LogoEventi.jpg" alt="Nature">
			<div class="card_copy">
				<h3>${event.name}</h3>
				<p>Descrizione : ${event.description}</p>
				<p>Luogo : ${event.luogo}</p>

				<p></p>

				<div class="allinea allinea_dett_dis">
					<a href="${contextPath}/eventi/getEventId?idEvento=${event.id}"
						class="button_dettagli">Dettagli</a>
				</div>

				<div class="allinea allinea_dett_dis">
					<a
						href="${contextPath}/account/getEventNamePerDisdire?id=${event.id}"
						class="button_disdici">Disdici</a>
				</div>

			</div>
		</div>
	</c:forEach>

</section>

<section class="cards clearfix">
	<h1>EVENTI CHE HAI CREATO</h1>
	<c:forEach items="${owner}" var="event" varStatus="tagStatus">
		<div class="card">
			<img class="card_image"
				src="${contextPath}/resources/images/myevents.jpg" alt="Nature">
			<div class="card_copy">
				<h3>${event.name}</h3>
				<p>Descrizione : ${event.description}</p>
				<p>Luogo : ${event.luogo}</p>

				<p></p>

				<div class="allinea allinea3">
					<a href="${contextPath}/adminEvent?idEvento=${event.id}"
						class="button_partecipa">Modifica</a>
				</div>

				<div class="allinea allinea3">
					<a href="${contextPath}/managePartecipanti?idEvento=${event.id}"
						class="button_dettagli">Gestione</a>
				</div>

				<br>
				<br>
				


				<div>
					<a href="${contextPath}/account/deleteEvent?idEvento=${event.id}"
						class="btn2 button_elimina btn-lg btn-block">Elimina</a>
				</div>
			</div>
		</div>
	</c:forEach>

</section>



<%@ include file="common/footer.jspf"%>