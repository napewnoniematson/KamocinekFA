<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><g:layoutTitle default="Kamocinek Football Club"/></title>
    <asset:link rel="icon" href="KamocinekFC_icon.jpg" type="image/x-ico" />
    <asset:stylesheet src="application.css"/>
    <style>
        #body {min-height: 400px; padding-left: 20px; padding-right: 20px}
        #header {background-color:#FFFFFF;text-align: center; height: 250px}
        #footer {background-color:#5e5e5e;text-align: center; height: 50px}
        #navmenu {float: left;width: 100%;height: 40px;margin: -20px 0 0 0;}
        #navmenu ul {list-style-type: none;margin: 10px 0 10px 10px;padding: 0;}
        #navmenu ul li {display: inline;position: relative;float: left;}
        #navmenu ul li a {display: block;padding: 0 18px 10px 0px;}
        a:link, a:visited{color: #666;font-weight: bold;text-decoration: none;}
        a:hover {color: #1b6d85;font-weight: bold;text-decoration: none;}
    </style>
    <g:layoutHead/>

</head>
<body>
%{--<g:form name="myForm" url="[controller:'coach', action:'index']">--}%

    <div id="header">
        <asset:image src="KamocinekFC.jpg" style="height: 250px"/>
    </div>
    <div id="langs" style="text-align: right; font-size: 15px; padding-right: 15px">
        <g:link uri="${request.getRequestURI()}" params="[lang: 'pl']">pl</g:link>
          |
        <g:link uri="${request.getRequestURI()}" params="[lang: 'en']">en</g:link><br>
    </div>
    <sec:ifLoggedIn>
        <div id="navmenu">
            <ul>
                <sec:ifAllGranted roles="ROLE_ADMIN">
                    <li><g:link controller="admin" action="home"><g:message code="nav.admin.home"/></g:link></li>
                    <li><g:link controller="admin" action="addPlayer"><g:message code="nav.admin.add.player"/></g:link></li>
                    <li><g:link controller="admin" action="showPlayers"><g:message code="nav.admin.show.players"/></g:link></li>
                    <li><g:link controller="admin" action="addCoach"><g:message code="nav.admin.add.coach"/></g:link></li>
                    <li><g:link controller="admin" action="showCoaches"><g:message code="nav.admin.show.coaches"/></g:link></li>
                    <li><g:link controller="admin" action="addCourse"><g:message code="nav.admin.add.course"/></g:link></li>
                    <li><g:link controller="admin" action="showCourses"><g:message code="nav.admin.show.courses"/></g:link></li>
                </sec:ifAllGranted>
                <sec:ifAllGranted roles="ROLE_COACH">
                    <li><g:link controller="coach" action="home"><g:message code="nav.coach.home"/></g:link></li>
                    <li><g:link controller="coach" action="showProfile"><g:message code="nav.coach.profile"/></g:link></li>
                    <li><g:link controller="coach" action="showCourses"><g:message code="nav.coach.my.courses"/></g:link></li>
                </sec:ifAllGranted>
                <sec:ifAllGranted roles="ROLE_PLAYER">
                    <li><g:link controller="player" action="home"><g:message code="nav.player.home"/></g:link></li>
                    <li><g:link controller="player" action="showProfile"><g:message code="nav.player.profile"/></g:link></li>
                    <li><g:link controller="player" action="showOwnCourses"><g:message code="nav.player.my.courses"/></g:link></li>
                    <li><g:link controller="player" action="showCourses"><g:message code="nav.player.other.courses"/></g:link></li>
                </sec:ifAllGranted>
                <li><g:link controller="logout"><g:message code="nav.logout"/></g:link></li>
            </ul>
        </div>
    </sec:ifLoggedIn>

    <div id="body">
        <g:layoutBody/>
    </div>
    <div id="footer">
        <p>KAMOCINEK FOOTBALL CLUB 2018 OWNER: MATEUSZ CYPEL</p>
    </div>

%{--</g:form>--}%
</body>
</html>