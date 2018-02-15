<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Register</title>
</head>
<body>
<div style="text-align: center; border: 1px solid #122b40">
    <g:form name="myForm" url="[controller:'account', action:'save']">
        <h3>Prepare your account</h3>
        <g:message code="profile.username"/><g:textField name="username" value="${user?.username}"/><g:renderErrors bean="${user}" as="list" field="username"/> <br>
        <g:message code="profile.Password"/><g:passwordField name="password" value="${user?.password}"/><g:renderErrors bean="${user}" as="list" field="password"/> <br>
        <g:message code="profile.name"/><g:textField name="name" value="${player?.name}"/><g:renderErrors bean="${player}" as="list" field="name"/> <br>
        <g:message code="profile.lastname"/><g:textField name="lastname" value="${player?.lastname}"/><g:renderErrors bean="${player}" as="list" field="lastname"/> <br>
        <g:message code="profile.email"/><g:textField name="email" value="${player?.email}"/><g:renderErrors bean="${player}" as="list" field="email"/> <br>
        <g:message code="profile.birthdate"/><g:textField name="birthdate" value="${player?.birthdate}"/><g:renderErrors bean="${player}" as="list" field="birthdate"/> <br>
        <g:message code="profile.height"/><g:textField name="height" value="${player?.height}"/><g:renderErrors bean="${player}" as="list" field="height"/> <br>
        <g:message code="profile.weight"/><g:textField name="weight" value="${player?.weight}"/><g:renderErrors bean="${player}" as="list" field="weight"/> <br>
        <div align="center">
            <recaptcha:ifEnabled>
                <recaptcha:recaptcha theme="dark"/>
            </recaptcha:ifEnabled>
        </div>
        <g:actionSubmit controller="account" action="save" value="${message(code: 'button.create')}"/>
    </g:form>
</div>
</body>
</html>