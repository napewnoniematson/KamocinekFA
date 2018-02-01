<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of books by publisher</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'editProfile']">
    <g:hiddenField name="id" value="${coach.id}" />
    <label>Name: </label><g:textField name="name" value="${coach?.name}"/><g:renderErrors bean="${coach}" as="list" field="name"/> <br>
    <label>Last name: </label><g:textField name="lastname" value="${coach?.lastname}"/><g:renderErrors bean="${coach}" as="list" field="lastname"/> <br>
    <label>Email </label><g:textField name="email" value="${coach?.email}"/><g:renderErrors bean="${coach}" as="list" field="email"/> <br>
    %{--<g:link action="update" id="${coach.id}" params="[name: ]"><input type="button" value="Confirm"/></g:link>--}%
    <g:actionSubmit action="update" value="Confirm"/>
    <g:link action="showProfile"><input type="button" value="Cancel" </g:link>


</g:form>
</body>
</html>