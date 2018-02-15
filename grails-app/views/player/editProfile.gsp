<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Edit profile</title>
</head>
<body>
<g:form name="myForm" url="[controller:'player', action:'editProfile']">
    <g:message code="profile.name"/><g:textField name="name" value="${player?.name}"/><g:renderErrors bean="${player}" as="list" field="name"/> <br>
    <g:message code="profile.lastname"/><g:textField name="lastname" value="${player?.lastname}"/><g:renderErrors bean="${player}" as="list" field="lastname"/> <br>
    <g:message code="profile.email"/><g:textField name="email" value="${player?.email}"/><g:renderErrors bean="${player}" as="list" field="email"/> <br>
    <g:message code="profile.birthdate"/><g:textField name="birthdate" value="${player?.birthdate}"/><g:renderErrors bean="${player}" as="list" field="birthdate"/> <br>
    <g:message code="profile.height"/><g:textField name="height" value="${player?.height}"/><g:renderErrors bean="${player}" as="list" field="height"/> <br>
    <g:message code="profile.weight"/><g:textField name="weight" value="${player?.weight}"/><g:renderErrors bean="${player}" as="list" field="weight"/> <br>
    <g:actionSubmit action="update" value="${message(code: 'button.confirm')}"/>
</g:form>
</body>
</html>