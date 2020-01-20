<%@ include file = "common/header.jspf"%>

    <section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
          <h1>Eventi</h1>
          
          <a href="${contextPath}/eventCreator" class="button ">Crea un evento</a>
        </div>
      </div>
    </section>
    

                         
     
  <div id="myBtnContainer" class="button_Sh_My allinea">
  <button type="button" class="btn btn-outline-primary" onclick="filterSelection('tutti')"> Show all</button>
  <button type="button" class="btn btn-outline-primary" onclick="filterSelection('mymatch')"> myMatch</button>
  </div>

  <div id="myBtnContainer" class="button_Sh_My allinea_dx">
  <form:form class="form-inline my-2 my-lg-0" name="searchEvent" action="searchEvent" method="POST">
      <input class="form-control mr-sm-2" type="search" name="searchEvent" placeholder="Cerca un evento.." aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fa fa-search"></i> Cerca</button>
    </form:form>
  </div>
  <br><br>
  
  <div >
    <section class="cards clearfix">
    
    <c:forEach items="${lists}" var="list" varStatus="tagStatus">
    <div class="filterDiv tutti">
    <div class="card">
        <img class="card_image" src="${contextPath}/resources/images/LogoEventi.jpg" alt="Nature">
        <div class="card_copy">
          <h3>${list.name}</h3>
          <p>${list.description}</p>
          <p>${list.luogo}</p>

          <div class="allinea allinea_par_dett">
            <a href="${contextPath}/eventi/askToJoin?idevento=${list.id}" class="button_partecipa">Partecipa</a>
          </div>
          <div class="allinea allinea_par_dett">
            <a href="${contextPath}/eventi/getEventId?idEvento=${list.id}" class="button_dettagli">Dettagli</a>
          </div>
        </div>
      </div>
      </div>
    </c:forEach>
      
    </section>
    
    
     <section class="cards clearfix">
    <h1>EVENTI SUGGERITI IN BASE ALLE PREFERENZE</h1>
    <c:forEach items="${mymatchlist}" var="list" varStatus="tagStatus">
    <div class="filterDiv mymatch" >
    <div class="card " >
        <img class="card_image" src="${contextPath}/resources/images/LogoEventi.jpg" alt="Nature">
        <div class="card_copy ">
          <h3>${list.name}</h3>
          <p>${list.description}</p>
          <p>${list.luogo}</p>

          <div class="allinea">
            <a href="${contextPath}/eventi/askToJoin?idevento=${list.id}" class="button_partecipa">Partecipa</a>
          </div>
          <div class="allinea">
            <a href="${contextPath}/eventi/getEventId?idEvento=${list.id}" class="button_dettagli">Dettagli</a>
          </div>
          
        </div>
      </div>
      </div>
    </c:forEach>
      
    </section>
   </div> 

<script src="${contextPath}/resources/js/scriptPerFiltroEventi.js"></script>
<%@ include file = "common/footer.jspf"%>