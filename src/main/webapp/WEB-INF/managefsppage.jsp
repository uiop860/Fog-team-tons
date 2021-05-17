<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Administrer forespørgsel
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div>
        <section id="request info">
            <div class="stats py-3 px-4 table-responsive">
                <table class="table ">
                    <thead class="table-primary">
                    <th scope="col">Id</th>
                    <th scope="col">Bredde</th>
                    <th scope="col">Længde</th>
                    <th scope="col">Navn</th>
                    <th scope="col">Adresse</th>
                    <th scope="col">Hus nr.</th>
                    <th scope="col">Telefon</th>
                    <th scope="col">Email</th>
                    <c:if test="${requestScope.request.employeeID != 0}">
                        <th scope="col">MedarbejderID</th>
                    </c:if>
                    </thead>
                    <tr>
                        <td>${requestScope.request.requestID}</td>
                        <td>${requestScope.request.carportWidth}</td>
                        <td>${requestScope.request.carportLength}</td>
                        <td>${requestScope.request.name}</td>
                        <td>${requestScope.request.road}</td>
                        <td>${requestScope.request.houseNumber}</td>
                        <td>${requestScope.request.phone}</td>
                        <td>${requestScope.request.email}</td>
                        <c:if test="${requestScope.request.employeeID == 0}">
                            <td>
                                <form action="${pageContext.request.contextPath}/fc/takefsp" method="post">
                                    <input type="hidden" name="requestID" value="${requestScope.request.requestID}">
                                    <button name="employeeID" value="${sessionScope.email}"
                                            class="btn btn-primary text-light" type="submit">Tag forespørgsel
                                    </button>
                                </form>
                            </td>
                        </c:if>
                        <c:if test="${requestScope.request.employeeID != 0}">
                            <td>${requestScope.request.employeeID}</td>
                        </c:if>
                    </tr>
                </table>
            </div>
        </section>

        <div class="row">
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
            <div class="col-md-8">
                <svg xmlns="http://www.w3.org/2000/svg"
                     xmlns:xlink="http://www.w3.org/1999/xlink"
                     width="800" height="600" viewBox="0 0 855 690"
                     preserveAspectRatio="xMinYMin">


                    <svg xmlns="http://www.w3.org/2000/svg"
                         xmlns:xlink="http://www.w3.org/1999/xlink"
                         x="75"
                         y="10"
                         width="800"
                         height="600"
                         viewBox="0 0 780 600"
                         preserveAspectRatio="xMinYMin">
                        <rect x="0" y="0" height="100%" width="100%" fill="#ffffff"></rect>

                        <rect x="0" y="0" height="100%" width="100%"
                              style="stroke:#000000;stroke-width: 1;fill:none;"></rect>

                        <rect x="0" y="0" height="600" width="10" style="stroke:#000000;fill:none;"></rect>
                        <rect x="770" y="0" height="600" width="10" style="stroke:#000000;fill:none;"></rect>

                        <rect x="10" y="30" height="10" width="760" style="stroke:#000000;fill:none;"></rect>
                        <rect x="10" y="570" height="10" width="760" style="stroke:#000000;fill:none;"></rect>

                        <rect x="100" y="25" height="20" width="20" style="stroke:#000000;fill:none;"></rect>
                        <rect x="100" y="565" height="20" width="20" style="stroke:#000000;fill:none;"></rect>
                        <rect x="720" y="25" height="20" width="20" style="stroke:#000000;fill:none;"></rect>
                        <rect x="720" y="565" height="20" width="20" style="stroke:#000000;fill:none;"></rect>
                        <rect x="450" y="25" height="20" width="20" style="stroke:#000000;fill:none;"></rect>
                        <rect x="450" y="565" height="20" width="20" style="stroke:#000000;fill:none;"></rect>

                        <line x1="50" x2="650" y1="580" y2="30" stroke="black" stroke-width="1" stroke-linecap="square"
                              stroke-dasharray="1 3"/>
                        <line x1="50" x2="650" y1="30" y2="580" stroke="black" stroke-width="1" stroke-linecap="square"
                              stroke-dasharray="1 3"/>

                    </svg>

                    <defs>
                        <marker
                                id="beginArrow"
                                markerWidth="12"
                                markerHeight="12"
                                refX="5"
                                refY="5"
                                orient="auto">
                            <path d="M0,6 L12,0 L12,12 L0,6" style="fill: #000000;"/>
                        </marker>
                        <marker
                                id="endArrow"
                                markerWidth="12"
                                markerHeight="12"
                                refX="5"
                                refY="5"
                                orient="auto">
                            <path d="M0,0 L12,6 L0,12 L0,0 " style="fill: #000000;"/>
                        </marker>
                    </defs>
                    <line x1="10" y1="10" x2="10" y2="600"
                          style="stroke: #000000;
	marker-start: url(#beginArrow);
	marker-end: url(#endArrow);"/>
                    <defs>
                        <marker
                                id="beginArrow"
                                markerWidth="12"
                                markerHeight="12"
                                refX="5"
                                refY="5"
                                orient="auto">
                            <path d="M0,6 L12,0 L12,12 L0,6" style="fill: #000000;"/>
                        </marker>
                        <marker
                                id="endArrow"
                                markerWidth="12"
                                markerHeight="12"
                                refX="5"
                                refY="5"
                                orient="auto">
                            <path d="M0,0 L12,6 L0,12 L0,0 " style="fill: #000000;"/>
                        </marker>
                    </defs>

                    <line x1="80" y1="650" x2="800" y2="650" style="stroke: #000000; marker-start: url(#beginArrow);
	marker-end: url(#endArrow);"></line>
                    <text style="text-anchor: middle" transform="translate(30,300) rotate(-90)">600 cm</text>
                    <text style="text-anchor: middle" transform="translate(450,670)">800 cm</text>

                </svg>

            </div>
        </div>


        <div>
    </jsp:body>
</t:genericpage>