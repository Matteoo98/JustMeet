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
	<div class="single_copy shadow p-3 mb-5 bg-white rounded">
		<div class="p-3 mb-2 bg-light text-dark shadow-sm p-3 mb-5 bg-white rounded single_copy_title"><h2 align="center">INFORMAZIONI UTENTE</h2></div>
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
	</div>
</article>



<section class="cards clearfix">

	<div class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded"><h1 align="center">EVENTI A CUI SI E' UNITO</h1></div>
	<c:forEach items="${Events}" var="event" varStatus="tagStatus">
		<div class="card shadow p-3 mb-5 bg-white rounded">
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