<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="admin"/>
    <title>Admin home</title>
    %{--<asset:stylesheet src="application.css"/>--}%
</head>
<body>
<g:form name="myForm" url="[controller:'admin', action:'home']">
    <g:message code="admin.home.message" args="${ [admin?.name, admin?.lastname] }" />
</g:form>
</body>
</html>