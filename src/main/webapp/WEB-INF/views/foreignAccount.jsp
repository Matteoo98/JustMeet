<%@ include file="common/headerBootstrap.jspf"%>


<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>Just Meet</h1>
		</div>
	</div>
</section>

<div class="container2">  

<article class="single">
	<div class="single_copy">
		<h2 class="single_copy_title">INFORMAZIONI UTENTE</h2>
		<p></p>
		<p class="single_copy_meta">Nome :</p>
		<p>${user.username}</p>
		<p class="single_copy_meta">Cognome :</p>
		<p>${user.cognome}</p>
		<p class="single_copy_meta">Città :</p>
		<p>${user.citta}</p>
		<p class="single_copy_meta">Email :</p>
		<p>${user.email}</p>
		<p class="single_copy_meta">Preferenza 1 :</p>
		<p>${user.preferenceUno}</p>
		<p class="single_copy_meta">Preferenza 2 :</p>
		<p>${user.preferenceDue}</p>
		<p class="single_copy_meta">Preferenza 3 :</p>
		<p>${user.preferenceTre}</p>
	</div>
</article>



<section class="cards clearfix">
	<h1>EVENTI A CUI SI E' UNITO</h1>
	<c:forEach items="${Events}" var="event" varStatus="tagStatus">
		<div class="card">
			<img class="card_image"
				src="${contextPath}/resources/images/myevents.jpg" alt="Nature">
			<div class="card_copy">
				<h3>Nome : ${event.name}</h3>
				<p>Descrizione : ${event.description}</p>
				<p>Luogo : ${event.luogo}</p>

				<p></p>
				<a href="${contextPath}/eventi/getEventId?idEvento=${event.id}"
					class="button_partecipa">Dettagli</a>

			</div>
		</div>
	</c:forEach>

</section>

</div>

<%@ include file="common/footer.jspf"%>