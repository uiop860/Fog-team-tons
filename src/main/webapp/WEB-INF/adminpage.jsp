<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for admins
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="main col-12 pt-4">
        <div class="row first-row">
        <div class="col-4">
            <section id="recently-posted">
                <div class="card">
                    <div class="card-header bg-primary">
                        <h2 class="text-light">Beskeder</h2>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row g-0">
                                <div class="col-md-9">
                                    <div class="card-body">
                                        <h6 class="card-title">Lorem ipsum dolor sit amet...</h6>
                                        <p class="card-text">This is a wider card with supporting text below as a
                                            natural lead-in to additional content.</p>
                                        <p class="card-text"><small class="text-muted">Added 3 days ago</small></p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row g-0">
                                <div class="col-md-9">
                                    <div class="card-body">
                                        <h6 class="card-title">Lorem ipsum dolor sit amet...</h6>
                                        <p class="card-text">This is a wider card with supporting text below as a
                                            natural lead-in to additional content.</p>
                                        <p class="card-text"><small class="text-muted">Added 3 days ago</small></p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row g-0">
                                <div class="col-md-9">
                                    <div class="card-body">
                                        <h6 class="card-title">Lorem ipsum dolor sit amet...</h6>
                                        <p class="card-text">This is a wider card with supporting text below as a
                                            natural lead-in to additional content.</p>
                                        <p class="card-text"><small class="text-muted">Added 3 days ago</small></p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </section>
        </div>
        <div class="col-8">
            <section id="Foresp??rgsler">
                <div class="card">
                    <div class="card-header bg-primary">
                        <h2 class="text-light">Foresp??rgsler</h2>
                    </div>
                    <div class="stats py-3 px-4 table-responsive">
                        <table class="table ">
                            <thead>
                            <th scope="col">Id</th>
                            <th scope="col">Bredde</th>
                            <th scope="col">L??ngde</th>
                            <th scope="col">Navn</th>
                            <th scope="col">Adresse</th>
                            <th scope="col">Telefon</th>
                            <th scope="col">Email</th>
                            </thead>
                            <c:forEach var="requestList" items="${requestScope.requestList}">
                                <tr>
                                    <td>${requestList.requestID}</td>
                                    <td>${requestList.carportWidth}</td>
                                    <td>${requestList.carportLength}</td>
                                    <td>${requestList.name}</td>
                                    <td>${requestList.road}</td>
                                    <td>${requestList.houseNumber}</td>
                                    <td>${requestList.phone}</td>
                                    <td>${requestList.email}</td>
                                    <c:if test="${requestList.employeeID == 0}">
                                        <td><button class="btn btn-primary text-light">Tag foresp??rgsel</button></td>
                                    </c:if>
                                    <c:if test="${requestList.employeeID != 0}">
                                        <td>${requestList.employeeID}</td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </section>
        </div>


    </jsp:body>
</t:genericpage>
