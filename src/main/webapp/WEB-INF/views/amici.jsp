<%@ include file = "common/header.jspf"%>

<br>

<form:form class="form-inline my-2 my-lg-0" name="searchFriend" action="amici/search" method="POST">
      <input class="form-control mr-sm-2" type="search" name="searchFriend" placeholder="Cerca nuovi amici.." aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fa fa-search"></i> Cerca</button>
</form:form>


<section class="cards clearfix" >
    <h1>I tuoi amici : </h1>

    <c:forEach items="${listaAmici}" var="user" varStatus="tagStatus">
    
    <div class="card">

        <c:choose>
          <c:when test="${user.username=='Noyz Narcos'}">
              <img class="card_image" src="http://3.citynews-latinatoday.stgy.ovh/~media/original-hi/45112367075825/noyz-12-2.jpg" alt="Nature">
          </c:when> 

          <c:otherwise>
            <img class="card_image" src="${contextPath}/resources/images/persona.jpg" alt="Nature">
          </c:otherwise>
        </c:choose>

        <div class="card_copy">
          <h3>${user.username}</h3>
          <p>${user.email}</p>
          <p>${user.citta}</p>

          <div class="allinea">
            <a href="${contextPath}/eventView/account?nomeUser=${user.username}" class="button_dettagli">Dettagli</a>
          </div>
          
          <div class="allinea">
            <a href="${contextPath}/amici/remove?username=${user.username}" class="button_disdici">Rimuovi</a>
          </div>

        </div>
      </div>
    </c:forEach>
      
    </section>

<section class="cards clearfix" >
    <h1>Tutti gli utenti : </h1>
    <c:forEach items="${tutti}" var="user" varStatus="tagStatus">
    <div class="card">

        <c:choose>
          <c:when test="${user.username=='Kaka22'}">
              <img class="card_image" src="https://www.pianetamilan.it/wp-content/uploads/sites/23/2016/03/Kak%C3%A0_Milan_Chievo_2013_Getty_Images.jpg" alt="Nature">
          </c:when> 

          <c:otherwise>
            <img class="card_image" src="${contextPath}/resources/images/persona.jpg" alt="Nature">
          </c:otherwise>
        </c:choose>

        <div class="card_copy">
          <h3>${user.username}</h3>
          <p>${user.email}</p>
          <p>${user.citta}</p>
          
          <br>

         

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