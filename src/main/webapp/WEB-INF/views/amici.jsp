<%@ include file = "common/header.jspf"%>

<h1>Cerca nuovi amici : </h1>
<form:form name="searchFriend" action="amici/search" method="POST" >
    
         <input type="text" name="searchFriend" placeholder="Search.."/>
         <button type="submit"  ><i class="fa fa-search"></i></button>
    
</form:form>

<section class="cards clearfix" >
    <h1>I tuoi amici : </h1>
    <c:forEach items="${listaAmici}" var="user" varStatus="tagStatus">
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
            <a href="${contextPath}/amici/remove?username=${user.username}" class="button_disdici">Rimuovi</a>
          </div>

        </div>
      </div>
    </c:forEach>
      
    </section>

<section class="cards clearfix" >
    <h1>Persone che potresti conoscere : </h1>
    <c:forEach items="${tutti}" var="user" varStatus="tagStatus">
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