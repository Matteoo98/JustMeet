<%@ include file = "common/header.jspf"%>

<section class="cover cover--single">
      <div class="cover_filter"></div>
      <div class="cover_caption">
        <div class="cover_caption_copy">
          <h1>Gestione Partecipanti</h1>
        </div>
      </div>
    </section>

<section class="cards clearfix" >
    <h1>Partecipanti : </h1>
    <c:forEach items="${lista}" var="user" varStatus="tagStatus">
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
            <a href="${contextPath}/managePartecipanti/remove?id=${idevento}&username=${user.username}" class="button_disdici">Rimuovi</a>
          </div>

        </div>
      </div>
    </c:forEach>
      
    </section>


<h1>Cerca nuovi partecipanti : </h1>
<form:form name="search" action="search" method="POST" >
    
         <input type="text" name="search" placeholder="Search.."/>
         <button type="submit"  ><i class="fa fa-search"></i></button>
    
</form:form>


<c:forEach items="${ricercati}" var="user" varStatus="tagStatus">
<h1>Risultati della ricerca : </h1>
<section class="banner_notify clearfix">
      <div class="banner_copy">
        <div class="banner_copy_text">
          <p>Nome :<a href="${contextPath}/eventView/account?nomeUser=${user.username}">${user.username}</a></p>
          <p>Città : ${user.citta} </p>
          <p>Email : ${user.email} </p>
          <p><a href="${contextPath}/managePartecipanti/addToEvent?id=${idevento}&username=${user.username}" class="button_partecipa">Aggiungi all'evento</a></p>          
        </div>
      </div>
    </section>
   </c:forEach>  
         
          
         





<%@ include file = "common/footer.jspf"%>
