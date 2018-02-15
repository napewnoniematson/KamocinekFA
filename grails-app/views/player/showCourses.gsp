<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <title>Courses in offer</title>
</head>
<body>

<g:form name="myForm" url="[controller:'player', action:'showCourses']">
    Courses to join</br>
    <g:if test="${courses!=null}">
        <g:each in="${courses}" var="course">
            %{--<g:hiddenField name="id_course" value="${course.id}"/>--}%%{-- chyba bedzie trzeba g:linkiem--}%
            <g:link action="showCourse" id="${course.id}">${course.title}</g:link>
            %{--<g:if test="${course.players.size() < course.maxPlayers}">--}%
                %{--<g:message code="course.available"/>--}%
            <g:link action="join" id="${course.id}">join</g:link>
                %{--<g:actionSubmit action="join" value="join"/>--}%
            %{--</g:if>--}%
            %{--<g:else>--}%
                %{--<g:message code="course.noavailable"/>--}%
            %{--</g:else>--}%
            </br>
        </g:each>
    </g:if>
    <g:else>
        <g:message code="show.course.error.message"/>
    </g:else>
</g:form>
</body>
</html>