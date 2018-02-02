<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Players</title>
    <asset:stylesheet src="application.css"/>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showPlayers']">
    <h3><g:message code="show.player.message"/></h3>
    <g:message code="profile.name"/><g:textField name="name" value=" ${player?.name}"/><g:renderErrors bean="${player}" as="list" field="name"/> <br>
    <g:message code="profile.lastname"/><g:textField name="lastname" value=" ${player?.lastname}"/><g:renderErrors bean="${player}" as="list" field="lastname"/> <br>
    <g:message code="profile.email"/><g:textField name="email" value=" ${player?.email}"/><g:renderErrors bean="${player}" as="list" field="email"/> <br>
    <g:message code="profile.birthdate"/><g:textField name="birthdate" value=" ${player?.birthdate}"/><g:renderErrors bean="${player}" as="list" field="birthdate"/> <br>
    <g:message code="profile.height"/><g:textField name="height" value=" ${player?.height}"/><g:renderErrors bean="${player}" as="list" field="height"/> <br>
    <g:message code="profile.weight"/><g:textField name="weight" value=" ${player?.weight}"/><g:renderErrors bean="${player}" as="list" field="weight"/> <br>
    <g:if test="${player == null}">
        <g:actionSubmit action="addPlayer" value="${message(code: 'button.add')}"/>
    </g:if>
    <g:else>
        <g:hiddenField name="id" value="${id}"/>
        <g:actionSubmit action="updatePlayer" value="${message(code: 'button.update')}"/>
    </g:else>

    <h3><g:message code="show.player.message2"/></h3>
    <g:if test="${players!=null}">
        <table style="border: 1px solid black;">
            <tr style="padding: 15px;  border: 1px solid black;" nowrap="true">
                <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                    <g:message code="table.name"/>
                </td>
                <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                    <g:message code="table.lastname"/>
                </td>
                <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                    <g:message code="table.actions"/>
                </td>
            </tr>
            <g:each in="${players}" var="player">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.name}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.lastname}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                        <g:link action="deletePlayer" id="${player.id}"><input type="button" value="${message(code: 'button.delete')}"/></g:link>
                        <g:link action="editPlayer" id="${player.id}"><input type="button" value="${message(code: 'button.edit')}"/></g:link>
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