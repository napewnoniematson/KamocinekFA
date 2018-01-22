<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Players</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showPlayers']">
    <h3>New Player</h3>
    <label>Name: </label><g:textField name="name" value="${player?.name}"/><g:renderErrors bean="${player}" as="list" field="name"/> <br>
    <label>Last name: </label><g:textField name="lastname" value="${player?.lastname}"/><g:renderErrors bean="${player}" as="list" field="lastname"/> <br>
    <label>Email: </label><g:textField name="email" value="${player?.email}"/><g:renderErrors bean="${player}" as="list" field="email"/> <br>
    <label>Birthdate: </label><g:textField name="birthdate" value="${player?.birthdate}"/><g:renderErrors bean="${player}" as="list" field="birthdate"/> <br>
    <label>Height: </label><g:textField name="height" value="${player?.height}"/><g:renderErrors bean="${player}" as="list" field="height"/> <br>
    <label>Weight: </label><g:textField name="weight" value="${player?.weight}"/><g:renderErrors bean="${player}" as="list" field="weight"/> <br>
    <g:if test="${player == null}">
        <g:actionSubmit action="addPlayer" value="add"/>
    </g:if>
    <g:else>
        <g:hiddenField name="id" value="${id}"/>
        <g:actionSubmit action="updatePlayer" value="update"/>
    </g:else>

    <h3>Players:</h3>
    <g:if test="${players!=null}">
        <table style="border: 1px solid black;">
            <g:each in="${players}" var="player">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.name}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.lastname}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                        <g:link action="deletePlayer" id="${player.id}"><input type="button" value="Delete"/></g:link>
                        <g:link action="editPlayer" id="${player.id}"><input type="button" value="Edit"/></g:link>
                    </td>
                </tr>
            </g:each>
        </table>
    </g:if>
    <g:else>
        <p>Brak piłkarzy</p>
    </g:else>
</g:form>
</body>
</html>