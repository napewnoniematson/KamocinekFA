<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Panel testowy</title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

</head>
<body>
    <g:form name="myForm" url="[controller:'coach', action:'index']">
        <g:link controller="admin" action="showPlayers">admin/showPlayers</g:link><br>
        <g:link controller="admin" action="showCoaches">admin/showCoaches</g:link><br>
        <g:link controller="admin" action="showCourses">admin/showCourses</g:link><br>
        <g:link controller="coach" action="showProfile">coach/showProfile</g:link><br>
        <g:link controller="coach" action="showCourses">coach/showCourses</g:link><br>
        <g:link controller="player" action="home">player/showOwnCourses</g:link><br>
        <g:link controller="player" action="showCourses">player/showCourses</g:link><br>
        <g:link controller="player" action="showProfile">player/showProfile</g:link><br>
        <g:link controller="player" action="home">player/home</g:link><br>
        <g:link params="[lang: 'pl']">pl</g:link><br>
        <g:link params="[lang: 'en']">en</g:link><br>
    </g:form>
</body>
</html>
