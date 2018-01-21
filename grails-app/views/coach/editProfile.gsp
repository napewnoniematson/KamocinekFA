<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of books by publisher</title>
</head>
<body>
<g:form name="myForm" url="[controller:'coach', action:'editProfile']">
<p>worsk</p>
    %{--Books published by: <g:select name="selectedPublisher" from="${publishers}" value="${selectedPublisher? selectedPublisher : ''}"--}%
                                  %{--optionKey="id" optionValue="name" onchange="form.submit();" noSelection="['':'-Choose publisher-']"></g:select>--}%

    %{--<g:if test="${publishers==null}"><p>i chuj</p></g:if>--}%
    %{--<g:if test="${publisher == null}">i dupa</g:if>--}%
    %{--<br>--}%
    %{--<g:if test="${!books.empty}">--}%
        %{--<p>Publisher: ${selectedPublisherName}</p>--}%
        %{--<h2>Books:</h2>--}%
        %{--<g:each in="${books}" var="book">--}%
            %{--<p>${book.title}</p>--}%
        %{--</g:each>--}%
    %{--</g:if>--}%


</g:form>
</body>
</html>