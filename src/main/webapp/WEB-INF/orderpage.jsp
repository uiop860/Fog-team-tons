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
                            <option value="240">240</option>
                            <option value="270">270</option>
                            <option value="300">300</option>
                            <option value="330">330</option>
                            <option value="360">360</option>
                            <option value="390">390</option>
                            <option value="420">420</option>
                            <option value="450">450</option>
                            <option value="480">480</option>
                            <option value="510">510</option>
                            <option value="540">540</option>
                            <option value="570">570</option>
                            <option value="600">600</option>
                            <option value="630">630</option>
                            <option value="660">660</option>
                            <option value="690">690</option>
                            <option value="720">720</option>
                            <option value="750">750</option>
                        </select>
                        <br>
                        Vælg længde på carport
                        <select class="form-select " name="height" id="height">
                            <option selected>Vælg højde</option>
                            <option value="240">240</option>
                            <option value="270">270</option>
                            <option value="300">300</option>
                            <option value="330">330</option>
                            <option value="360">360</option>
                            <option value="390">390</option>
                            <option value="420">420</option>
                            <option value="450">450</option>
                            <option value="480">480</option>
                            <option value="510">510</option>
                            <option value="540">540</option>
                            <option value="570">570</option>
                            <option value="600">600</option>
                            <option value="630">630</option>
                            <option value="660">660</option>
                            <option value="690">690</option>
                            <option value="720">720</option>
                            <option value="750">750</option>
                            <option value="780">780</option>
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
                                <input class ="form-control w-100" id="housenumber" type="text" name="housenumber" value="">
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
                                <input class ="form-control" id="phone" type="text" name="phone" value=""
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