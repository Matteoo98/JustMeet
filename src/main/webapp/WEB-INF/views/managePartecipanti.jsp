<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>Gestione Partecipanti</h1>
		</div>
	</div>
</section>

<section class="cards clearfix">
	<h1>Partecipanti :</h1>
	
	<div class="container4">  
	
	<c:forEach items="${lista}" var="user" varStatus="tagStatus">
		<div class="card">
			<img class="card_image"
				src="${contextPath}/resources/images/persona.jpg" alt="Nature">
			<div class="card_copy">
				<h3>${user.username}</h3>
				<p>Email : ${user.email}</p>
				<p>Citta : ${user.citta}</p>

				<p></p>

				<div class="allinea">
					<a
						href="${contextPath}/eventView/account?nomeUser=${user.username}"
						class="button_dettagli">Dettagli</a>
				</div>

				<div class="allinea">
					<a
						href="${contextPath}/managePartecipanti/remove?id=${idevento}&username=${user.username}"
						class="button_disdici">Rimuovi</a>
				</div>

			</div>
		</div>
	</c:forEach>

	</div>

</section>

<hr width=70%; align="center";>
<br>

<div class="container4">  

<form:form class="form-inline my-2 my-lg-0" name="search"
	action="search" method="POST" id="contattaci">
	<input class="form-control mr-sm-2" type="search" name="search"
		placeholder="Nuovi partecipanti.." aria-label="Search">
	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
		<i class="fa fa-search"></i> Cerca
	</button>
</form:form>

</div>

<c:forEach items="${ricercati}" var="user" varStatus="tagStatus">
	<section class="banner_notify clearfix">
	
		<div class="container5">  
	
		<div class="banner_copy">
			<div class="banner_copy_text">

				<p class="single_copy_meta2">
					<strong>Nome :</strong> &emsp;<a
						href="${contextPath}/eventView/account?nomeUser=${user.username}">${user.username}</a>
				</p>

				<p class="single_copy_meta2">
					<strong>Citta &nbsp;&nbsp;:</strong> &emsp;${user.citta}
				</p>

				<p class="single_copy_meta2">
					<strong>Email &nbsp;:</strong> &emsp;${user.email}
				</p>

				<a
					href="${contextPath}/managePartecipanti/addToEvent?id=${idevento}&username=${user.username}"
					class="button_partecipa allinea">Aggiungi all'evento</a>
			</div>
		</div>
		
		</div>
		
	</section>
</c:forEach>








<%@ include file="common/footer.jspf"%>
