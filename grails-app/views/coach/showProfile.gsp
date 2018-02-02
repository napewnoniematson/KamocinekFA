<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your profile</title>
    <asset:stylesheet src="application.css"/>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'editProfile']">
    <g:hiddenField name="id" value="${coach.id}"/>
    <g:message code="profile.name" ></g:message><Label>${coach.name}</Label></br>
    <g:message code="profile.lastname"/><Label>${coach.lastname}</Label></br>
    <g:message code="profile.email"/><Label>${coach.email}</Label></br>
    %{--<g:link action="editProfile"><input type="button" value="edit"/></g:link>--}%
    %{--<g:link action="editProfile" id="${coach.id}"><input type="button" value="Edit Profile"/></g:link>--}%
    <g:actionSubmit value="Edit" action="editProfile"/>
</g:form>
</body>
</html>