<%@ include file = "common/headerIndex.jspf"%>

    <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <tr>
                <td>Remember Me:</td>
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