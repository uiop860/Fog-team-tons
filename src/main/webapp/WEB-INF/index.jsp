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
            <div>
                    <h1 class="pb-3 text-center">Skræddersyet carport</h1>
            </div>
        <div>
            <h5 class="pb-3">
                Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
                <br><br>
                Tilbud og skitsetegning fremsendes med post hurtigst muligt.
                <br><br>
                Ved bestilling medfølger standardbyggevejledning.
            </h5>
        </div>
        <div class="pb-3 text-left">
        <a href="${pageContext.request.contextPath}/fc/loginpage" class="btn btn-lg btn-block btn-primary">Find din carport<a>
        <div>
    </jsp:body>
</t:genericpage>