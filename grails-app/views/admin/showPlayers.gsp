<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Player home</title>
</head>
<body>
<g:form name="myForm" url="[controller:'admin', action:'showPlayers']">
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
        <g:message code="show.player.error.message"/>
    </g:else>
</g:form>
</body>
</html>