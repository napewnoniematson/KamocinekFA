<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="coach"/>
    <title>Player home</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'editProfile']">
    <g:hiddenField name="id" value="${coach.id}"/>
    <g:message code="profile.name" ></g:message><Label>${coach.name}</Label></br>
    <g:message code="profile.lastname"/><Label>${coach.lastname}</Label></br>
    <g:message code="profile.email"/><Label>${coach.email}</Label></br>
    <g:actionSubmit value="Edit" action="editProfile"/>
</g:form>
</body>
</html>