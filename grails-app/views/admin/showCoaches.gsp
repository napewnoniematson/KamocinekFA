<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Coaches</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showCoaches']">
    <h3>New Coach</h3>
    <label>Name: </label><g:textField name="name" value="${coach?.name}"/><g:renderErrors bean="${coach}" as="list" field="name"/> <br>
    <label>Last name: </label><g:textField name="lastname" value="${coach?.lastname}"/><g:renderErrors bean="${coach}" as="list" field="lastname"/> <br>
    <label>Email </label><g:textField name="email" value="${coach?.email}"/><g:renderErrors bean="${coach}" as="list" field="email"/> <br>
    <g:if test="${coach == null}">
        <g:actionSubmit action="addCoach" value="add"/>
    </g:if>
    <g:else>
        <g:hiddenField name="id" value="${id}"/>
        <g:actionSubmit action="updateCoach" value="update"/>
    </g:else>

    <h3>Coaches:</h3>
    <g:if test="${coaches!=null}">
        <table style="border: 1px solid black;">
            <g:each in="${coaches}" var="coach">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${coach.name}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${coach.lastname}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                        <g:link action="deleteCoach" id="${coach.id}"><input type="button" value="Delete"/></g:link>
                        <g:link action="editCoach" id="${coach.id}"><input type="button" value="Edit"/></g:link>
                    </td>
                </tr>
            </g:each>
        </table>
    </g:if>
    <g:else>
        <p>Brak trenerow</p>
    </g:else>
</g:form>
</body>
</html>