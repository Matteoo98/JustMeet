<%@ include file = "common/headerBootstrap.jspf"%>

    <div class="container">
    
    <form:form action="eventCreator" method="POST" modelAttribute="eventForm" class="form-signin" id="contattaci">
    
    		<br>
    		<br>
    		<br>
    
            <h2 class="form-signin-heading">Crea un evento</h2>
            <br>
            
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="name" class="form-control" placeholder="Name"
                                autofocus="true" required="true"></form:input>
                    <form:errors path="name"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="description">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="description" class="form-control" placeholder="Description"
                                autofocus="true" required="true"></form:input>
                    <form:errors path="description"></form:errors>
                </div>
            </spring:bind>
            
            
             <spring:bind path="Year">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Year" class="form-control" placeholder="Anno"
                                autofocus="true" required="true"></form:input>
                    <form:errors path="Year"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Month">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Month" class="form-control" placeholder="Mese"
                                autofocus="true" required="true"></form:input>
                    <form:errors path="Month"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Day">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Day" class="form-control" placeholder="Giorno"
                                autofocus="true" required="true"></form:input>
                    <form:errors path="Day"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Ora">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Ora" class="form-control" placeholder="Ora"
                                autofocus="true" required="true"></form:input>
                    <form:errors path="Ora"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Minuti">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Minuti" class="form-control" placeholder="Minuti"
                                autofocus="true" required="true"></form:input>
                    <form:errors path="Minuti"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="category">
               <div class="form-group" >
    <form:input class="custom-select" list="list" type="text" path="category" placeholder="Categoria" autofocus="true" required="true" ></form:input>
    <datalist id="list">
    <option value="Sport">
    <option value="Giochi">
    <option value="Studio">
    
    </datalist>
    <form:errors path="category"></form:errors>
    </div>
         </spring:bind>
            
            <spring:bind path="luogo">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="luogo" class="form-control" placeholder="Luogo"
                                autofocus="true" required="true"></form:input>
                    <form:errors path="luogo"></form:errors>
                </div>
            </spring:bind>
            
             <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>

        
</form:form>
    </div>

<%@ include file = "common/footer.jspf"%>