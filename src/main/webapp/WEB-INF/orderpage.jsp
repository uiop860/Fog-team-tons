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
            </div>
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
        <form method="post" action="${pageContext.request.contextPath}/fc/finishpage" class="align-content-center">


            <div class="pb-3">
                <h4 class="pb-3 text-center">Vælg længde og bredde på carport</h4>
                <br><br>
                Vælg bredde på carport
                <select class="form-select" name="width" id="width">
                        <option value="123">1234</option>
                </select>
                <br>
                Vælg længde på carport
                <select class="form-select " name="height" id="height">
                    <option value="123">1234</option>
                </select>
                <br><br>
            <h4 class="pb-3 text-center">Kontaktinformation</h4>
            </div>

            <button type="submit" class="btn btn-lg btn-block btn-primary" name="carportRequest" value="${sessionScope.user.id}">Send Forspørgsel</button>
        </form>
            </div>
            <div class="col-sm-3"></div>
        </div>

    </jsp:body>
</t:genericpage>