<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Your profile</title>
</head>
<body>
<g:form name="myForm" url="[controller:'player', action:'editProfile']">
    <g:message code="profile.name"/> ${player?.name}</br>
    <g:message code="profile.lastname"/> ${player?.lastname}</br>
    <g:message code="profile.email"/> ${player?.email}</br>
    <g:message code="profile.birthdate"/>${player?.birthdate}<br>
    <g:message code="profile.height"/>${player?.height}<br>
    <g:message code="profile.weight"/>${player?.weight}<br>
    %{--<g:link action="editProfile"><input type="button" value="edit"/></g:link>--}%
    %{--<g:link action="editProfile" id="${coach.id}"><input type="button" value="Edit Profile"/></g:link>--}%
    <g:actionSubmit value="${message(code: 'button.edit')}" action="editProfile"/>
</g:form>
</body>
</html>