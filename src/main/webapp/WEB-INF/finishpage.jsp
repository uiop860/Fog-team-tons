<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Færdig
    </jsp:attribute>

    <jsp:body>

        <div class="row pt-5 pb-5">
            <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <div class="mt-2 col-md-18">
                        <div class="fs-1 pb-5 text-primary text-center">
                            Tak for din henvendelse!
                        </div>
                        <div class="fs-5">
                            Vi kontakter dig hurtigst muligt angående din personlige carport.
                            <br>
                            En medarbejder vil gennemgå din forespørgsel og kontakte dig med et tilbud.
                            <br>
                            Her har du en nogle skitser over den carport vi har beregnet til dig.
                        </div>
                    </div>

                </div>
            <div class="col-lg-3"></div>
        </div>
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
        <div class="mt-2 col-md-18">
            <a type="button" class="btn btn-outline-primary"
               href="${pageContext.request.contextPath}/fc/index">Gå til forsiden</a>
        </div>

    </jsp:body>

</t:genericpage>