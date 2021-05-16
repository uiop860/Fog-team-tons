<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register as new User
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">
                        <input id="email" class="form-control" type="email" name="email" value="${param.email}" placeholder="Mogens@gmail.com">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password1">Kodeord</label>
                    <div class="col-sm-4">
                        <input id="password1" class="form-control" type="password" name="password1"  value="${param.password1}"  placeholder="Indtast kodeord">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password2">Kodeord</label>
                    <div class="col-sm-4">
                        <input id="password2" class="form-control" type="password" name="password2" value="${param.password2}"  placeholder="Gentag kodeord">
                        <div class="pt-3"><button type="submit" class="btn btn-primary btn-lg btn-block w-100" name="Opret" value="submit">Opret bruger</button></div>
                    </div>
                </div>
                <%--<div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="name">Navn</label>
                    <div class="col-sm-4">
                        <input id="name" class="form-control" type="text" name="name" value="${param.name}"  placeholder="Mogens Jørgensen">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="phone">Telefon</label>
                    <div class="col-sm-4">
                        <input id="phone" class="form-control" type="tel" name="phone" value="${param.phone}" placeholder="12345678">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="road">Vej</label>
                    <div class="col-sm-4">
                        <input id="road" class="form-control" type="text" name="road" value="${param.road}"  placeholder="Vesterbrogade">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="house">Hus nr.</label>
                    <div class="col-sm-4">
                        <input id="house" class="form-control" type="number" name="house" value="${param.house}" placeholder="19">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="zipcode">Post nr.</label>
                    <div class="col-sm-4">
                        <input id="zipcode" class="form-control" type="number" name="zipcode" value="${param.zipcode}" placeholder="4260">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="city">By</label>
                    <div class="col-sm-4">
                        <input id="city" class="form-control" type="text" name="city" value="${param.city}"  placeholder="Odense">

                    </div>
                </div>--%>
                <%--<div class="pt-3"><button type="submit" class="btn btn-primary btn-lg btn-block w-100" name="Opret" value="submit">Opret bruger</button></div>--%>

                <%--<input class="btn btn-primary" type="submit" value="Submit">--%>
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>


