<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Player home</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'updateCoach']">
    <h3><g:message code="show.coach.message"/></h3>
    <g:message code="profile.name"/><g:textField name="name" value="${coach?.name}"/><g:renderErrors bean="${coach}" as="list" field="name"/> <br>
    <g:message code="profile.lastname"/><g:textField name="lastname" value="${coach?.lastname}"/><g:renderErrors bean="${coach}" as="list" field="lastname"/> <br>
    <g:message code="profile.email"/><g:textField name="email" value="${coach?.email}"/><g:renderErrors bean="${coach}" as="list" field="email"/> <br>
    <g:hiddenField name="id" value="${id}"/>
    <g:actionSubmit action="updateCoach" value="${message(code: 'button.update')}"/>
</g:form>
</body>
</html>