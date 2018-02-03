<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="admin"/>
    <title>Player home</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'savePlayer']">
    <h3><g:message code="show.player.message"/></h3>
    <g:message code="profile.name"/><g:textField name="name" value=" ${name}"/><g:renderErrors bean="${player}" as="list" field="name"/> <br>
    <g:message code="profile.lastname"/><g:textField name="lastname" value=" ${lastname}"/><g:renderErrors bean="${player}" as="list" field="lastname"/> <br>
    <g:message code="profile.email"/><g:textField name="email" value=" ${email}"/><g:renderErrors bean="${player}" as="list" field="email"/> <br>
    <g:message code="profile.birthdate"/><g:textField name="birthdate" value=" ${birthdate}"/><g:renderErrors bean="${player}" as="list" field="birthdate"/> <br>
    <g:message code="profile.height"/><g:textField name="height" value=" ${height}"/><g:renderErrors bean="${player}" as="list" field="height"/> <br>
    <g:message code="profile.weight"/><g:textField name="weight" value=" ${weight}"/><g:renderErrors bean="${player}" as="list" field="weight"/> <br>
    <g:actionSubmit action="savePlayer" value="${message(code: 'button.add')}"/>
</g:form>
</body>
</html>