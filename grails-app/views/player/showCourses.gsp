<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your courses</title>
</head>
<body>

<g:form name="myForm" url="[controller:'player', action:'showCourses']">
    <g:message code="show.course.message"/></br>
    <g:hiddenField name="id_player" value="3"/>
    <g:if test="${courses!=null}">
        <g:each in="${courses}" var="course">
            %{--<g:hiddenField name="id_course" value="${course.id}"/>--}%%{-- chyba bedzie trzeba g:linkiem--}%
            <g:link action="showCourse" id="${course.id}">${course.title}</g:link>
            <g:if test="${course.players.size() < course.maxPlayers}">
                <g:message code="course.available"/>
                <g:actionSubmit action="join" value="join"/>
            </g:if>
            <g:else>
                <g:message code="course.noavailable"/>
            </g:else>
            </br>
        </g:each>
    </g:if>
    <g:else>
        <g:message code="show.course.error.message"/>
    </g:else>
</g:form>
</body>
</html>