<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your profile</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'showProfile']">
   <Label>Name: ${coach.name}</Label></br>
    <Label>Last name: ${coach.lastname}</Label></br>
    <Label>Email: ${coach.email}</Label></br>
    %{--<g:link action="editProfile"><input type="button" value="edit"/></g:link>--}%
    <g:link action="editProfile" id="${coach.id}"><input type="button" value="Edit Profile"/></g:link>
</g:form>
</body>
</html>