<%@ include file = "common/header.jspf"%>



<section class="cards clearfix" >
    <h1>Risultati della ricerca : </h1>
    <c:forEach items="${ricercati}" var="user" varStatus="tagStatus">
    <div class="card">
        <img class="card_image" src="${contextPath}/resources/images/persona.jpg" alt="Nature">
        <div class="card_copy">
          <h3>${user.username}</h3>
          <p>Email : ${user.email}</p>
          <p>Città : ${user.citta}</p>
          
          <p></p>

          <div class="allinea">
            <a href="${contextPath}/eventView/account?nomeUser=${user.username}" class="button_dettagli">Dettagli</a>
          </div>
          
          <div class="allinea">
            <a href="${contextPath}/amici/add?username=${user.username}" class="button_partecipa">Aggiungi</a>
          </div>

        </div>
      </div>
    </c:forEach>
      
    </section>






















<%@ include file = "common/footer.jspf"%>