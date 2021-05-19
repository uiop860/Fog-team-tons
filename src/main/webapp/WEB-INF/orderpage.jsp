<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Bestilling af carport
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <form method="post" action="${pageContext.request.contextPath}/fc/finishpage" class="align-content-center">
            <div class="row pt-5">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <div class="pb-3">
                        <div class="fs-1 text-primary pb-5 text-center ">
                            Skræddersyet carport
                        </div>
                        <div class="fs-4 text-primary pb-3 text-center">
                            Vælg længde og bredde på carport
                        </div>
                        <label class="fs-6 pb-1" for="width">
                            Vælg bredde på carport
                        </label>
                        <div class="pb-3">
                            <select class="form-select" name="width" id="width">
                                <option selected="">Vælg bredde</option>
                                <c:forEach var="width" items="${applicationScope.carportwidth}">
                                    <option value="${width.key}">${width.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <label class="fs-6 pb-1" for="length">
                            Vælg længde på carport
                        </label>
                        <div class="pb-5">
                            <select class="form-select " name="length" id="length">
                                <option selected>Vælg længde</option>
                                <c:forEach var="length" items="${applicationScope.carportlength}">
                                    <option value="${length.key}">${length.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="fs-4 text-primary pb-3 text-center">
                            Kontaktinformation
                        </div>

                        <div class="d-flex ">
                            <div class="p-2 flex-fill">
                                <label class="pb-1" for="name">Navn</label><br>
                                <input class ="form-control" type="text" id="name" name="name" placeholder="Anders" value="">
                            </div>
                        </div>
                        <div class="d-flex">
                            <div class="p-2 w-100">
                                <label class="pb-1" for="road">Adresse</label><br>
                                <input class ="form-control w-100" id="road" type="text" name="road" value="" placeholder="Jagtvej">
                            </div>
                            <div class="p-2 align-items-end w-25">
                                <label class="pb-1" for="housenumber">Hus nr.</label><br>
                                <input class ="form-control w-100" id="housenumber" type="number" name="housenumber" value="" placeholder="54">
                            </div>
                        </div>
                        <div class="d-flex">
                            <div class="p-2 align-items-start w-50">
                                <label class="pb-1" for="zipcode">Postnummer</label><br>
                                <input class ="form-control w-100" id="zipcode" type="text" name="zipcode" value="" placeholder="2200">
                            </div>
                            <div class="p-2 w-100">
                                <label class="pb-1" for="city">By</label><br>
                                <input class ="form-control w-100" id="city" type="text" name="city" value="" placeholder="København">
                            </div>
                        </div>
                        <div class="d-flex">
                            <div class="p-2 flex-fill">
                                <label class="pb-1" for="phone">Telefon</label><br>
                                <input class ="form-control" id="phone" type="number" name="phone" value="" placeholder="45649376">
                            </div>
                        </div>
                        <div class="d-flex">
                            <div class="p-2 flex-fill">
                                <label class="pb-1" for="email">Email</label><br>
                                <input class ="form-control" id="email" type="text" name="email" value="" placeholder="Anders@gmail.com">
                            </div>
                        </div>

                        <c:if test="${requestScope.error != null}">
                            <div class="d-flex">
                                <div class="p-2 flex-fill">
                                    <p style="color:red">${requestScope.error}</p>
                                </div>
                            </div>
                        </c:if>
                        <div class="p-2">
                            <button type="submit" class="btn btn-lg btn-block btn-primary" name="carportRequest"
                                    value="${sessionScope.user.id}">Send Forspørgsel
                            </button>
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
            </div>
        </form>
    </jsp:body>
</t:genericpage>