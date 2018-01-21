<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your profile</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'showProfile']">
   <p>Name: ${name}</p>
    <p>Last name: ${lastname}</p>
    <p>Email: ${email}</p>
    %{--<g:link action="editProfile"><input type="button" value="edit"/></g:link>--}%
    <g:link action="editProfile" >xd</g:link>
</g:form>
</body>
</html>