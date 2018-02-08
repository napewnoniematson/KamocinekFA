<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Player home</title>
    %{--<asset:stylesheet src="application.css"/>--}%
</head>
<body>
    <g:form name="myForm">
        <sec:ifLoggedIn>
            <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_PLAYER, ROLE_COACH">
                <p>Welcome <sec:username/></p>
            </sec:ifAnyGranted>
        </sec:ifLoggedIn>
    </g:form>
</body>
</html>