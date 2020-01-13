<%@ include file = "common/header.jspf"%>

    <section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
          <h1>Eventi</h1>
          
          <a href="${contextPath}/eventCreator" class="button">Crea un evento</a>
        </div>
      </div>
    </section>
    

                         
     
  <div id="myBtnContainer" class="button_Sh_My">
  <button type="button" class="btn btn-outline-primary" onclick="filterSelection('tutti')"> Show all</button>
  <button type="button" class="btn btn-outline-primary" onclick="filterSelection('mymatch')"> myMatch</button>
  <form:form name="searchEvent" action="searchEvent" method="POST" >
    
         <input type="text" name="searchEvent" placeholder="Search.."/>
         <button type="submit"  ><i class="fa fa-search"></i></button>
    
</form:form>
  </div>
  
  <div class="grid">
    <section class="cards clearfix">
    
    <c:forEach items="${lists}" var="list" varStatus="tagStatus">
    <div class="filterDiv tutti">
    <div class="card">
        <img class="card_image" src="${contextPath}/resources/images/LogoEventi.jpg" alt="Nature">
        <div class="card_copy">
          <h3>${list.name}</h3>
          <p>Descrizione : ${list.description}</p>
          <p>Luogo : ${list.luogo}</p>

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
    
    
     <section class="cards clearfix">
    <h1> EVENTI SUGGERITI IN BASE ALLE PREFERENZE</h1>
    <c:forEach items="${mymatchlist}" var="list" varStatus="tagStatus">
    <div class="filterDiv mymatch" >
    <div class="card " >
        <img class="card_image" src="${contextPath}/resources/images/LogoEventi.jpg" alt="Nature">
        <div class="card_copy ">
          <h3>${list.name}</h3>
          <p>Descrizione : ${list.description}</p>
          <p>Luogo : ${list.luogo}</p>

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