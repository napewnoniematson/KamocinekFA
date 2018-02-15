<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Edit profile</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'editProfile']">
    <g:message code="profile.name"/><g:textField name="name" value="${coach?.name}"/><g:renderErrors bean="${coach}" as="list" field="name"/> <br>
    <g:message code="profile.lastname"/><g:textField name="lastname" value="${coach?.lastname}"/><g:renderErrors bean="${coach}" as="list" field="lastname"/> <br>
    <g:message code="profile.email"/><g:textField name="email" value="${coach?.email}"/><g:renderErrors bean="${coach}" as="list" field="email"/> <br>
    %{--<g:link action="update" id="${coach.id}" params="[name: ]"><input type="button" value="Confirm"/></g:link>--}%
    <g:actionSubmit action="update" value="${message(code: 'button.confirm')}"/>
</g:form>
</body>
</html>