<%@ include file = "common/headerBootstrapIndex.jspf"%>

    <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
      	<br><br>
      	<br>
        <div class="p-3 mb-2 bg-light text-dark shadow p-3 mb-5 bg-white rounded"><h2 align="center" class="form-heading">LOG IN</h2></div>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
             <div class="font-effect-shadow-multiple  "><font size="6">Username : </font></div>
             <br>  
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus required/>
            <br>      
            <div class="font-effect-shadow-multiple "><font size="6">Password : </font></div> 
            <br>      
            <input name="password" type="password" class="form-control" placeholder="Password" required/>
            <br>
            <tr>
                <td ><font size="6">Remember Me : </font></td>
                <td><input type="checkbox" name="remember-me" /></td>
            </tr>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>
            <br>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <a class="btn btn-secondary btn-lg btn-block" href="${contextPath}/registration">Create an account</a>
        </div>
      </form>
    </div>

<%@ include file = "common/footerLogin.jspf"%>