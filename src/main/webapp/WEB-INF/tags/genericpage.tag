<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <!-- Bootstrap JS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap/js/bootstrap.bundle.min.js">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/scss/custom.css">
</head>


<body class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/fc/index">
                <img src="${pageContext.request.contextPath}/resources/fog-logo1.svg" width="55" height="55" class="d-inline-block align-text-top">
            </a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/fc/orderpage">Bestilling</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="${pageContext.request.contextPath}/fc/loginpage">Profil</a>--%>
<%--                </li>--%>
            </ul>
            <div>

                <c:if test="${sessionScope.user != null }">
                    ${sessionScope.user.email}
                </c:if>

                <c:if test="${sessionScope.role == 'admin'}">
                    <a type="button" class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/fc/adminpage">admin side</a>
                </c:if>

                <c:if test="${sessionScope.role == 'employee'}">
                    <a type="button" class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/fc/employee">Medarbejder side</a>
                </c:if>

                <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
                <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
                <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

                <c:if test="${isNotLoginPage && isNotRegisterPage}">

                    <c:if test="${sessionScope.user != null }">
                            <a type="button" class="btn btn-sm  btn-outline-primary"
                               href="${pageContext.request.contextPath}/fc/logoutcommand">Log ud</a>
                    </c:if>

                    <c:if test="${sessionScope.user == null }">
                            <a type="button" class="btn btn-sm  btn-outline-primary"
                               href="${pageContext.request.contextPath}/fc/loginpage">Log ind</a>
                    </c:if>

                </c:if>
            </div>
        </div>
    </nav>

<div id="body" class="container" style="min-height: 20vh;">
    <jsp:doBody/>
</div>


    <jsp:invoke fragment="footer"/>
    <br>
    <br>
    <footer class="container pt-3 px-4 bg-light">
        <div class="row">
            <div class="col-6 col-md">
                <h5>Kontakt</h5>
                <ul class="list-unstyled text-muted">
                    <li>Telefon: +45 45871001</li>
                    <li>Email: info@Johannesfog.dk</li>
                </ul>
            </div>
            <div class="col-6 col-md">
            </div>
        </div>
    </footer>
</body>
</html>