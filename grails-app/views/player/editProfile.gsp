<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of books by publisher</title>
</head>
<body>
<g:form name="myForm" url="[controller:'player', action:'editProfile']">
    <g:hiddenField name="id" value="${id}" />
    <label>Name: </label><g:textField name="name" value="${player?.name}"/><g:renderErrors bean="${player}" as="list" field="name"/> <br>
    <label>Last name: </label><g:textField name="lastname" value="${player?.lastname}"/><g:renderErrors bean="${player}" as="list" field="lastname"/> <br>
    <label>Email: </label><g:textField name="email" value="${player?.email}"/><g:renderErrors bean="${player}" as="list" field="email"/> <br>
    <label>Birthdate: </label><g:textField name="birthdate" value="${player?.birthdate}"/><g:renderErrors bean="${player}" as="list" field="birthdate"/> <br>
    <label>Height: </label><g:textField name="height" value="${player?.height}"/><g:renderErrors bean="${player}" as="list" field="height"/> <br>
    <label>Weight: </label><g:textField name="weight" value="${player?.weight}"/><g:renderErrors bean="${player}" as="list" field="weight"/> <br>
    <g:actionSubmit action="update" value="Confirm"/>
    <g:link action="showProfile"><input type="button" value="Cancel" </g:link>


</g:form>
</body>
</html>