<%@ include file = "common/headerBootstrap.jspf"%>
<section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
            <h1>AMICI</h1>
        </div>
      </div>
    </section>
<br>
<div id="myBtnContainer" class="button_Sh_My allinea_dx">
<form:form class="form-inline my-2 my-lg-0" name="searchFriend" id="contattaci" action="amici/search" method="POST">
      <input class="form-control mr-sm-2" type="search" name="searchFriend" placeholder="Cerca nuovi amici.." aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fa fa-search"></i> Cerca</button>
</form:form>
</div>

<section class="cards clearfix" >
    <h1>Tuoi amici : </h1>

    <c:forEach items="${listaAmici}" var="user" varStatus="tagStatus">
    
    <div class="card">

        <c:choose>
          <c:when test="${user.username=='Noyz Narcos'}">
              <img class="card_image" src="http://3.citynews-latinatoday.stgy.ovh/~media/original-hi/45112367075825/noyz-12-2.jpg" alt="Nature">
          </c:when> 
          
          <c:when test="${user.username=='Pato07'}">
              <img class="card_image" src="https://i.pinimg.com/originals/d4/51/00/d4510008149492dd4d554d20d426bea9.jpg">
          </c:when>
          
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
          
          <c:when test="${user.username=='Pato07'}">
              <img class="card_image" src="https://i.pinimg.com/originals/d4/51/00/d4510008149492dd4d554d20d426bea9.jpg">
          </c:when> 
          
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