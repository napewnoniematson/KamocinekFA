<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your courses</title>
</head>
<body>

<g:form name="myForm" url="[controller:'coach', action:'showCourses']">
    Your courses:

    <g:if test="${courses!=null}">
        <g:each in="${courses}" var="course">
            <g:link action="showCourse" id="${course.id}">${course.title}</g:link>
        </g:each>
    </g:if>
    <g:else>
        <p>Brak kursów</p>
    </g:else>
</g:form>
</body>
</html>