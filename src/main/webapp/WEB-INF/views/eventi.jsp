<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>Eventi</h1>

			<a href="${contextPath}/eventCreator" class="button ">Crea un
				evento</a>
		</div>
	</div>
</section>


<div class="container2">

	<div id="myBtnContainer" class="button_Sh_My allinea_dx">
	
		<form:form class="form-inline my-2 my-lg-0" name="searchEvent"
			action="searchEvent" method="POST">
			<input class="form-control mr-sm-2" type="search" name="searchEvent"
				placeholder="Cerca un evento.." aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
				<i class="fa fa-search"></i> Cerca
			</button>
		</form:form>
	</div>
</div>

<br><br><br>
<br>

<div id="carouselExampleIndicators" class="carousel slide"
	data-ride="carousel" data-interval="false">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">
		
		<div class="container3"> 

			<section class="cards clearfix">
			
			<div class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded"><h1 align="center">LISTA EVENTI DISPONIBILI</h1></div>

				<div class="container_flex_eventi">
				<c:forEach items="${lists}" var="list" varStatus="tagStatus">
				
					<div class="filterDiv tutti">
						<div class="item card shadow p-3 mb-5 bg-white rounded">
							<img class="card_image"
								src="${contextPath}/resources/images/LogoEventi.jpg"
								alt="Nature">
							<div class="card_copy">
								<h3 class="nome">${list.name}</h3>
								<p class="descrizione">${list.description}</p>
								<p class="descrizione">${list.luogo}</p>
							<div class="allinea_container">
								<div class="allinea_item">
									<a href="${contextPath}/eventi/askToJoin?idevento=${list.id}"
										class="button_partecipa" onclick="myFunctionPartecipa()">Partecipa</a>
								</div>
								<div class="allinea_item">
									<a href="${contextPath}/eventi/getEventId?idEvento=${list.id}"
										class="button_dettagli">Dettagli</a>
								</div>
							</div>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
			</section>
			
			</div>

		</div>
		<div class="carousel-item">

			<section class="cards clearfix">
				
				<div class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded"><h1 align="center">EVENTI SUGGERITI IN BASE ALLE PREFERENZE</h1></div>
				
				<div class="container_flex_eventi">
				<c:forEach items="${mymatchlist}" var="list" varStatus="tagStatus">
					<div class="filterDiv mymatch">
						<div class="item card shadow p-3 mb-5 bg-white rounded">
							<img class="card_image"
								src="${contextPath}/resources/images/LogoEventi.jpg"
								alt="Nature">
							<div class="card_copy ">
								<h3 class="nome">${list.name}</h3>
								<p class="descrizione">${list.description}</p>
								<p class="descrizione">${list.luogo}</p>

							<div class="allinea_container">
								<div class="allinea_item">
									<a href="${contextPath}/eventi/askToJoin?idevento=${list.id}"
										class="button_partecipa">Partecipa</a>
								</div>
								<div class="allinea_item">
									<a href="${contextPath}/eventi/getEventId?idEvento=${list.id}"
										class="button_dettagli">Dettagli</a>
								</div>
							</div>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
			</section>

		</div>
	</div>
	<br> <br> <br> <a class="carousel-control-prev"
		href="#carouselExampleIndicators" role="button" data-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>


<script src="${contextPath}/resources/js/scriptPerFiltroEventi.js"></script>
<%@ include file="common/footer.jspf"%>