<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>Modifica Evento</h1>
		</div>
	</div>
</section>
<div class="container container5">
	<form:form action="adminEvent" method="POST"
		modelAttribute="adminEvent" class="form-signin">

		<br>

		<div
			class="p-3 mb-2 bg-light text-dark shadow-sm p-3 mb-5 bg-white rounded single_copy_title">
			<h2 align="center">MODIFICA IL TUO EVENTO</h2>
		</div>

		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="name" class="form-control"
					placeholder="Name" autofocus="true" required="true"
					value="${evento.name}"></form:input>
				<form:errors path="name"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="description">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="description" class="form-control"
					placeholder="Description" autofocus="true" required="true"
					value="${evento.description}"></form:input>
				<form:errors path="description"></form:errors>
			</div>
		</spring:bind>


		<spring:bind path="Year">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="Year" class="form-control"
					placeholder="Anno" autofocus="true" required="true"
					value="${evento.year}"></form:input>
				<form:errors path="Year"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="Month">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="Month" class="form-control"
					placeholder="Mese" autofocus="true" required="true"
					value="${evento.month}"></form:input>
				<form:errors path="Month"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="Day">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="Day" class="form-control"
					placeholder="Giorno" autofocus="true" required="true"
					value="${evento.day}"></form:input>
				<form:errors path="Day"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="Ora">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="Ora" class="form-control"
					placeholder="Ora" autofocus="true" required="true"
					value="${evento.ora}"></form:input>
				<form:errors path="Ora"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="Minuti">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="Minuti" class="form-control"
					placeholder="Minuti" autofocus="true" required="true"
					value="${evento.minuti}"></form:input>
				<form:errors path="Minuti"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="owner">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="owner" class="form-control"
					placeholder="Owner" autofocus="true" required="true"
					value="${evento.owner}"></form:input>
				<form:errors path="owner"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="category">
			<div class="form-group">
				<form:input list="Categorie" path="category" placeholder="Categoria"
					value="${evento.category}" autofocus="true" required="true"></form:input>
				<datalist id="Categorie">
					<option value="Sport">
					<option value="Studio">
					<option value="Giochi">
				</datalist>
			</div>
		</spring:bind>

		<spring:bind path="luogo">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:input type="text" path="luogo" class="form-control"
					placeholder="Luogo" autofocus="true" required="true"
					value="${evento.luogo}"></form:input>
				<form:errors path="luogo"></form:errors>
			</div>
		</spring:bind>



		<button class="btn btn-lg btn-primary btn-block" type="submit">Modifica</button>




	</form:form>
</div>

<%@ include file="common/footer.jspf"%>