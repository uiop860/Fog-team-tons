<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
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
                    <img src="${pageContext.request.contextPath}/resources/smiley.png" width="200" height="200">
                </div>
    </jsp:body>
</t:genericpage>