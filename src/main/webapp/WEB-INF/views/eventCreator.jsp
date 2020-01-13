<%@ include file = "common/header.jspf"%>

    <div class="container">
    
    <form:form action="eventCreator" method="POST" modelAttribute="eventForm" class="form-signin">
    
            <h2 class="form-signin-heading">Create your event</h2>
            
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="name" class="form-control" placeholder="Name"
                                autofocus="true"></form:input>
                    <form:errors path="name"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="description">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="description" class="form-control" placeholder="Description"
                                autofocus="true"></form:input>
                    <form:errors path="description"></form:errors>
                </div>
            </spring:bind>
            
            
             <spring:bind path="Year">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Year" class="form-control" placeholder="Anno"
                                autofocus="true"></form:input>
                    <form:errors path="Year"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Month">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Month" class="form-control" placeholder="Mese"
                                autofocus="true"></form:input>
                    <form:errors path="Month"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Day">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Day" class="form-control" placeholder="Giorno"
                                autofocus="true"></form:input>
                    <form:errors path="Day"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Ora">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Ora" class="form-control" placeholder="Ora"
                                autofocus="true"></form:input>
                    <form:errors path="Ora"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="Minuti">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="number" path="Minuti" class="form-control" placeholder="Minuti"
                                autofocus="true"></form:input>
                    <form:errors path="Minuti"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="category">
               <div class="form-group" >
    <form:input list="Categorie" path="category" placeholder="Categoria"></form:input>
    <datalist id="Categorie">
    <option value="Sport">
    <option value="Studio">
    <option value="Giochi">
    
    </datalist>
    </div>
         </spring:bind>
            
            <spring:bind path="luogo">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="luogo" class="form-control" placeholder="Luogo"
                                autofocus="true"></form:input>
                    <form:errors path="luogo"></form:errors>
                </div>
            </spring:bind>
            
             <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>

        
</form:form>
    </div>

<%@ include file = "common/footer.jspf"%>