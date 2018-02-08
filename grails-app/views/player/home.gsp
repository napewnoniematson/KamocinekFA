<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Player home</title>
    %{--<asset:stylesheet src="application.css"/>--}%
</head>
<body>
<g:form name="myForm" url="[controller:'player', action:'home']">
    <g:message code="player.home.message" args="${ [player?.name, player?.lastname] }" />
</g:form>
</body>
</html>