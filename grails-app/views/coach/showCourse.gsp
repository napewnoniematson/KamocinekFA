<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>${title}</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'showCourse']">
    <h3>Title: ${title}</h3>
    <p>Players on course</p>
    <g:if test="${players!=null}">
        <table style="border: 1px solid black;">
            <tr style="padding: 15px; border: 1px solid black;">
                <td style="padding: 15px; border: 1px solid black;">
                    <g:message code="profile.name"/>
                </td>
                <td style="padding: 15px; border: 1px solid black;">
                    <g:message code="profile.lastname"/>
                </td>
            </tr>
            <g:each in="${players}" var="player">
                <tr style="padding: 15px; border: 1px solid black;">
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.name}</td>
                    <td style="padding: 15px;  border: 1px solid black;" nowrap="true">${player.lastname}</td>
                </tr>
            </g:each></table>
        <g:hiddenField name="id" value="${id}"/>
        <g:actionSubmit action="attendanceList" value="Generate attendance list"/>
    </g:if>

</g:form>
</body>
</html>