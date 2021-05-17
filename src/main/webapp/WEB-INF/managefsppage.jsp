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
                            <thead>
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
                                            <button name="employeeID" value="${sessionScope.email}" class="btn btn-primary text-light" type="submit">Tag forespørgsel</button>
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

        <div class="modal-body row">
            <div class="col-md-4">
                <img src="https://lh3.googleusercontent.com/pw/ACtC-3db4WVzov-MjX84nhSnBxR80Q_riOV20hwa-UEJtRzXRg7s3Im5xY0TTOOjlspoCN9dv2gDm1K8Zz20FkaGis20_vst0zdlJJtomzBnAG-uSsXB2qmVFChxf0xsZj01fn9PLWx9FD_Ai2hm-DBK_kGP=w1250-h937-no?authuser=0" width="100%">
            </div>
            <div class="col-md-8">
                <img src="https://lh3.googleusercontent.com/pw/ACtC-3e2B2OQYhUkn2se09sjUgRph4M249NVF__uVtIh5J3uK_nV96dVhqAd09WHDsM0OCJrvqj43lm98QsVlEUuvZsJSSmYsQEETxr-v3qq3uYhbDkp6aliYFWQ7t9mhRaWaQLyFRFpmqsHHkg24729Scy5=w1250-h937-no?authuser=0" width="100%">
            </div>
        </div>


        <div>
    </jsp:body>
</t:genericpage>