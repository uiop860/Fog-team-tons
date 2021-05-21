<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:printtag>

    <jsp:attribute name="header">
        Print tilbud
    </jsp:attribute>

    <jsp:attribute name="footer">
<%--        <c:set var="addHomeLink" value="${false}" scope="request"/>--%>
    </jsp:attribute>

    <jsp:body>
        <div>
            <div class="row">
                <div class="col-sm-4"></div>
            <div class="col-sm-2 pt-3 pb-3 ">
            <button class="noprint btn btn-primary" onclick="window.print()">Print eller gem side</button>
            </div>
            <div class="col-sm-2 pt-3 pb-3 ">
                <form action="${pageContext.request.contextPath}/fc/managefsp" method="post">
                    <button name="manageRequest" value="${requestScope.request.requestID}" class="noprint btn btn-primary">Gå tilbage</button>
                </form>
            </div>
                <div class="col-sm-4"></div>
            </div>
            <div class="row">
                <div class="col-sm-4"></div>
            <div class="col-md-4">
                <table class="table">
                    <thead>
                    <th scope="col">Materiale</th>
                    <th scope="col">Beskrivelse</th>
                    <th scope="col">Antal</th>
                    <th scope="col">Pris</th>
                    </thead>
                    <c:forEach var="material" items="${requestScope.materialList}">
                        <tr>
                            <td>${material.material_name}</td>
                            <td>${material.description}</td>
                            <td>${material.amount}</td>
                            <td>${material.total_material_price} kr.</td>
                        </tr>
                    </c:forEach>
                </table>
                <h3 class="text-center">Total pris: ${requestScope.request.total_price} kr.</h3>

            </div>
                <div class="col-sm-4"></div>
            </div>

                <div class="pb-3">
                    <div class="card">
                        <div class="card-header text-center bg-primary">
                            <div class="fs-2 text-light">
                                Skitse ovenfra
                            </div>
                        </div>
                        <div class="pt-4">
                                ${requestScope.SVG}
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
                            ${requestScope.sideSvg}
                    </div>
                </div>


        </div>

        <div>
    </jsp:body>
</t:printtag>