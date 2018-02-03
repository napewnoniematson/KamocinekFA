<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="admin"/>
    <title>Player home</title>
    %{--<asset:stylesheet src="application.css"/>--}%
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'home']">
    <g:message code="coach.home.message" args="${ [coach?.name, coach?.lastname] }" />
</g:form>
</body>
</html>