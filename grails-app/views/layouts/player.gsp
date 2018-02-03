<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><g:layoutTitle default="Player"/></title>
    <asset:stylesheet src="application.css"/>
    <style>
        #body {min-height: 400px;}
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
<g:form name="myForm" url="[controller:'coach', action:'index']">

    <div id="header">
        <asset:image src="KamocinekFC.jpg" style="height: 250px"/>
    </div>
    <div id="navmenu">
        <ul>
            <li><g:link controller="player" action="home"><g:message code="nav.player.home"/></g:link></li>
            <li><g:link controller="player" action="showProfile"><g:message code="nav.player.profile"/></g:link></li>
            <li><g:link controller="player" action="showOwnCourses"><g:message code="nav.player.my.courses"/></g:link></li>
            <li><g:link controller="player" action="showCourses"><g:message code="nav.player.other.courses"/></g:link></li>
            <li><g:link ><g:message code="nav.logout"/></g:link></li>
        </ul>
    </div>
    <div id="body">
        <g:layoutBody/>
    </div>

    <div id="footer">
        <p>KAMOCINEK FOOTBALL CLUB 2018 OWNER: MATEUSZ CYPEL</p>
    </div>

</g:form>
</body>
</html>