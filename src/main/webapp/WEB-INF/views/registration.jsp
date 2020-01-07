<%@ include file = "common/header.jspf"%>

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Create your account</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>
            
             <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="email" path="email" class="form-control" placeholder="Email"></form:input>
                    <form:errors path="email"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="cognome">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="cognome" path="cognome" class="form-control" placeholder="Cognome"></form:input>
                    <form:errors path="cognome"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="citta">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="citta" path="citta" class="form-control" placeholder="Citt�"></form:input>
                    <form:errors path="citta"></form:errors>
                </div>
            </spring:bind>
            
            <h1>Scegli i tuoi interessi</h1>
            
            <spring:bind path="preferenceUno">
               <div class="form-group" >
    <form:input list="sports" type="text" path="preferenceUno" placeholder="your preferences"></form:input>
    <datalist id="sports">
    <option value="CALCIO">
    <option value="BASKET">
    <option value="PALLAVOLO">
    <option value="CALCIO A 5">
    <option value="RUGBY">
    </datalist>
    </div>
         </spring:bind>
         
         <spring:bind path="preferenceDue">
               <div class="form-group" >
    <form:input list="faculty" type="text" path="preferenceDue" placeholder="your preferences"></form:input>
    <datalist id="faculty">
    <option value="INFORMATICA">
    <option value="CHIMICA">
    <option value="MATEMATICA">
    <option value="GIURISPRUDENZA">
    <option value="GEOLOGIA">
    </datalist>
    </div>
         </spring:bind>
         
         <spring:bind path="preferenceTre">
               <div class="form-group" >
    <form:input list="games" type="text" path="preferenceTre" placeholder="your preferences"></form:input>
    <datalist id="games">
    <option value="FORTNITE">
    <option value="CALL OF DUTY">
    <option value="NBA2K20">
    <option value="FIFA20">
    <option value="GTA5">
    </datalist>

</div>
         </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>
<%@ include file = "common/footer.jspf"%>