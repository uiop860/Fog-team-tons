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
        <div>
            <h1 class="pb-3 text-center">Skræddersyet carport</h1>
            <br>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/fc/finishpage" class="align-content-center">
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <div class="pb-3">
                        <h4 class="pb-3 text-center">Vælg længde og bredde på carport</h4>
                        Vælg bredde på carport
                        <select class="form-select" name="width" id="width">
                            <option selected="">Vælg bredde</option>
                            <c:forEach var="width" items="${applicationScope.carportwidth}">
                                <option value="${width.value}">${width.value}</option>
                            </c:forEach>
                        </select>
                        <br>
                        Vælg længde på carport
                        <select class="form-select " name="length" id="length">
                            <option selected>Vælg længde</option>
                            <c:forEach var="length" items="${applicationScope.carportlength}">
                                <option value="${length.value}">${length.value}</option>
                            </c:forEach>
                        </select>
                        <br><br>

                        <h4 class="pb-3 text-center">Kontaktinformation</h4>

                        <div class="d-flex ">
                            <div class="p-2 flex-fill">
                                <label for="name">Navn</label><br>
                                <input class ="form-control" type="text" id="name" name="name" placeholder="Indtast dit navn" value="">
                            </div>
                        </div>
                        <div class="d-flex">
                            <div class="p-2 w-100">
                                <label for="road">Adresse</label><br>
                                <input class ="form-control w-100" id="road" type="text" name="road" value="" placeholder="Indtast adresse">
                            </div>
                            <div class="p-2 align-items-end w-25">
                                <label  for="housenumber">Hus nr.</label><br>
                                <input class ="form-control w-100" id="housenumber" type="number" name="housenumber" value="">
                            </div>
                        </div>
                        <div class="d-flex">
                            <div class="p-2 align-items-start w-50">
                                <label for="zipcode">Postnummer</label><br>
                                <input class ="form-control w-100" id="zipcode" type="text" name="zipcode" value=""
                                       placeholder="Indtast postnummer">
                            </div>
                            <div class="p-2 w-100">
                                <label  for="city">By</label><br>
                                <input class ="form-control w-100" id="city" type="text" name="city" value="" placeholder="Indtast by">
                            </div>
                        </div>
                        <div class="d-flex">
                            <div class="p-2 flex-fill">
                                <label for="phone">Telefon</label><br>
                                <input class ="form-control" id="phone" type="number" name="phone" value=""
                                       placeholder="Indtast gyldigt telefonnummer">
                            </div>
                        </div>
                        <div class="d-flex">
                            <div class="p-2 flex-fill">
                                <label for="email">Email</label><br>
                                <input class ="form-control" id="email" type="text" name="email" value=""
                                       placeholder="Indtast gyldig mailadresse">
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
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </form>
    </jsp:body>
</t:genericpage>