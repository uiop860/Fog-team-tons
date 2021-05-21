<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Færdig
    </jsp:attribute>

    <jsp:body>
        <div    class="mt-2 col-md-18">
            <h2>Tak for din henvendelse!</h2>
                Vi kontakter dig hurtigst muligt angående din personlige carport.
                En medarbejder vil gennemgå din forespørgsel og kontakte dig med et tilbud.

        </div>





        <div class="mt-2 col-md-18">
            <a type="button" class="btn btn-sm  btn-outline-secondary"
               href="${pageContext.request.contextPath}/fc/index">Gå til forsiden</a>
        </div>
        <br>
        <br>


        <div class="pb-3">
            <div class="card">
                <div class="card-header text-center bg-primary">
                    <div class="fs-2 text-light">
                        Skitse ovenfra
                    </div>
                </div>
                <div class="pt-4">
                        ${requestScope.svg}
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header text-center bg-primary">
                <div class="fs-2 text-light">
                    Skitse fra siden
                </div>
            </div>
            <div class="pt-4">
                    ${requestScope.sideSVG}
            </div>
        </div>


       <%-- <div class="mt-2 col-md-18">
            <div>
            <img src="${pageContext.request.contextPath}/resources/smiley.png" alt="Smiley" width="200" height="200">
            </div>
        </div>--%>

    </jsp:body>

</t:genericpage>