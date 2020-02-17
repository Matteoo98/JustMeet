<%@ include file="common/headerBootstrap.jspf"%>

<section class="cover cover--single">
	<div class="cover_filter"></div>
	<div class="cover_caption">
		<div class="cover_caption_copy">
			<h1>Modifica Account</h1>
		</div>
	</div>
</section>
<div class="container">
	<form:form action="modifyAccount" method="POST"
		modelAttribute="modifyAccount" class="form-signin">

		<br>
		<div
			class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded">
			<h2 align="center">MODIFICA IL TUO ACCOUNT</h2>
		</div>

		<div class="container5">

			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true" required="true"
						value="${user.username}"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="email" path="email" class="form-control"
						placeholder="Email" value="${user.email}" autofocus="true"
						required="true"></form:input>
					<form:errors path="email"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="cognome">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="cognome" path="cognome" class="form-control"
						placeholder="Cognome" value="${user.cognome}" autofocus="true"
						required="true"></form:input>
					<form:errors path="cognome"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="citta">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="citta" path="citta" class="form-control"
						placeholder="Citta" value="${user.citta}" autofocus="true"
						required="true"></form:input>
					<form:errors path="citta"></form:errors>
				</div>
			</spring:bind>

		</div>
		<br>
		<div
			class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded">
			<h2 align="center">MODIFICA GLI INTERESSI</h2>
		</div>

		<div class="container5">

			<spring:bind path="preferenceUno">
				<div class="form-group">

					<form:input class="custom-select" list="sports" type="text"
						path="preferenceUno" placeholder="your preferences"
						value="${user.preferenceUno}" autofocus="true" required="true"></form:input>

					<datalist id="sports">
						<option value="CALCIO"></option>
						<option value="BASKET"></option>
						<option value="PALLAVOLO"></option>
						<option value="CALCIO A 5"></option>
						<option value="RUGBY"></option>
					</datalist>

					<form:errors path="preferenceUno"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="preferenceDue">
				<div class="form-group">
					<form:input class="custom-select" list="faculty" type="text"
						path="preferenceDue" placeholder="your preferences"
						value="${user.preferenceDue}" autofocus="true" required="true"></form:input>
					<datalist id="faculty">
						<option value="INFORMATICA">
						<option value="CHIMICA">
						<option value="MATEMATICA">
						<option value="GIURISPRUDENZA">
						<option value="GEOLOGIA">
					</datalist>
					<form:errors path="preferenceDue"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="preferenceTre">
				<div class="form-group">
					<form:input class="custom-select" list="games" type="text"
						path="preferenceTre" placeholder="your preferences"
						value="${user.preferenceTre}" autofocus="true" required="true"></form:input>
					<datalist id="games">
						<option value="FORTNITE">
						<option value="CALL OF DUTY">
						<option value="NBA2K20">
						<option value="FIFA20">
						<option value="GTA5">
					</datalist>
					<form:errors path="preferenceTre"></form:errors>
				</div>
			</spring:bind>

		</div>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Modifica</button>
	</form:form>

</div>

<%@ include file="common/footer.jspf"%>