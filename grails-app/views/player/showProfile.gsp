<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your profile</title>
</head>
<body>
<g:form name="myForm" url="[controller:'player', action:'editProfile']">
    <g:hiddenField name="id" value="${player.id}"/>
    <Label>Name: ${player.name}</Label></br>
    <Label>Last name: ${player.lastname}</Label></br>
    <Label>Email: ${player.email}</Label></br>
    %{--<g:link action="editProfile"><input type="button" value="edit"/></g:link>--}%
    %{--<g:link action="editProfile" id="${coach.id}"><input type="button" value="Edit Profile"/></g:link>--}%
    <g:actionSubmit value="Edit" action="editProfile"/>
</g:form>
</body>
</html>