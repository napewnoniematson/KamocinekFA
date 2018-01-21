<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Players</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showPlayers']">
    <h3>Players:</h3>
    <g:if test="${players!=null}">
        <table style="border: 1px solid black;">
            <g:each in="${players}" var="player">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.name}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.lastname}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                        <g:link action="deletePlayer" id="${player.id}"><input type="button" value="Delete"/></g:link>
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