<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Coaches</title>
</head>
<body>

<g:form name="myForm" url="[controller:'admin', action:'showCoaches']">
    <h3><g:message code="show.coach.message2"/></h3>
    <g:if test="${coaches!=null}">
        <table style="border: 1px solid black;">
            <tr style="padding: 15px; border: 1px solid black;">
                <td style="padding: 15px; border: 1px solid black;">
                    <g:message code="table.name"/>
                </td>
                <td style="padding: 15px; border: 1px solid black;">
                    <g:message code="table.lastname"/>
                </td>
                <td style="padding: 15px; border: 1px solid black;">
                    <g:message code="table.actions"/>
                </td>
            </tr>
            <g:each in="${coaches}" var="coach">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${coach.name}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${coach.lastname}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">
                        <g:link action="deleteCoach" id="${coach.id}"><input type="button" value="${message(code: 'button.delete')}"/></g:link>
                        <g:link action="editCoach" id="${coach.id}"><input type="button" value="${message(code: 'button.edit')}"/></g:link>
                    </td>
                </tr>
            </g:each>
        </table>
    </g:if>
    <g:else>
        <g:message code="show.coach.error.message"/>
    </g:else>
</g:form>
</body>
</html>