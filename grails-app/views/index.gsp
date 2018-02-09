<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Panel testowy</title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

</head>
<body>
<g:form name="myForm">
    <sec:ifLoggedIn>
        <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_PLAYER, ROLE_COACH">
            <p>Welcome <sec:username/></p>
        </sec:ifAnyGranted>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
        <div style="border:1px solid #a60000;">
            <div style = "text-align: center;  margin: 10px">
                <g:link uri="/login/auth">Zaloguj sie</g:link></br>
                <g:link controller="account" action="create">Nie masz konta? Załóż je!</g:link>
            </div>
        </div>
    </sec:ifNotLoggedIn>
</g:form>
</body>
</html>
