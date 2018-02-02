<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your profile</title>
    <asset:stylesheet src="application.css"/>
</head>
<body>
<g:form name="myForm" url="[controller:'player', action:'editProfile']">
    <g:hiddenField name="id" value="${player.id}"/>
    <g:message code="profile.name"/> ${player.name}</br>
    <g:message code="profile.lastname"/> ${player.lastname}</br>
    <g:message code="profile.email"/> ${player.email}</br>
    %{--<g:link action="editProfile"><input type="button" value="edit"/></g:link>--}%
    %{--<g:link action="editProfile" id="${coach.id}"><input type="button" value="Edit Profile"/></g:link>--}%
    <g:actionSubmit value="${message(code: 'button.edit')}" action="editProfile"/>
</g:form>
</body>
</html>