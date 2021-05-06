<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Færdig
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Tak for din henvendelse!</h2>
                Vi kontakter dig hurtigst muligt angående din personlige carport.
        </div>
        <div>
            <a type="button" class="btn btn-sm  btn-outline-secondary"
               href="${pageContext.request.contextPath}/fc/index">Gå til forsiden</a>
        </div>

        <div>
            <img src="img.png" alt="Smiley">
        </div>

    </jsp:body>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

</t:genericpage>