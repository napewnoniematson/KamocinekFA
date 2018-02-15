<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Your profile</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'editProfile']">
    <g:message code="profile.name" ></g:message><Label>${coach.name}</Label></br>
    <g:message code="profile.lastname"/><Label>${coach.lastname}</Label></br>
    <g:message code="profile.email"/><Label>${coach.email}</Label></br>
    <g:actionSubmit value="Edit" action="editProfile"/>
</g:form>
</body>
</html>