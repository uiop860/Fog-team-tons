<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div class="row pt-5">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <div class="fs-1 pb-5 text-primary text-center">
                    Skræddersyet carport
                </div>
                <div class="fs-5" >
                    Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på
                    en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
                    <br><br>
                    Tilbud og skitsetegning fremsendes med post hurtigst muligt.
                    <br><br>
                    Ved bestilling medfølger standardbyggevejledning.
                </div>
                <div class="pt-4">
                    <a href="${pageContext.request.contextPath}/fc/orderpage" class="btn btn-primary">Find din carport</a>
                </div>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </jsp:body>
</t:genericpage>