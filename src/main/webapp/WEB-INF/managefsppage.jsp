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
        </div>


        <div>
    </jsp:body>
</t:genericpage>