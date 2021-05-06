<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/scss/custom.css">
</head>
<body>
    <!--
        This header is inspired by this bootstrap
        example: https://getbootstrap.com/docs/5.0/examples/pricing/
    -->
<%--<header class="container d-flex flex-column flex-md-row align-items-center p-3 pb-0 px-md-4 mb-4 bg-white border-bottom shadow-sm">--%>
    <%--<nav class="my-2 my-md-0 me-md-3">
        <div class="container">
            <a href="${pageContext.request.contextPath}/fc/index">
                <img src="${pageContext.request.contextPath}/resources/fog-logo1.svg">
            </a>
        </div>
        <div class=""


            <c:if test="${addHomeLink == null }">
                <a class="p-2 text-dark" href="<%=request.getContextPath()%>">Hjem</a>
            </c:if>
            <a class="p-2 text-dark" href="#">Orders</a>
            <a class="p-2 text-dark" href="#">Profile</a>
            <a class="p-2 text-dark" href="#">About</a>
    </nav>--%>
    <div class="container">
        <nav class="nav navbar-expand-lg navbar-light bg-light pt-">
            <div class="col-10">
                <ul class="navbar-nav">
                    <li>
                        <div class="container">
                            <a class="navbar-brand" href="${pageContext.request.contextPath}/fc/index">
                                <img src="${pageContext.request.contextPath}/resources/fog-logo1.svg" width="50" height="50" class="d-inline-block align-text-top">
                            </a>
                        </div>
                    </li>
                    <li class="nav-item pt-1">
                        <a class="nav-link" href="#">
                            Orders
                        </a>
                    </li>
                    <li class="nav-item pt-1">
                        <a class="nav-link" href="#">
                            Profile
                        </a>
                    </li>
                    <li class="nav-item pt-1">
                        <a class="nav-link" href="#">
                            About
                        </a>
                    </li>
                </ul>
            </div>
            <div class="col-2 pt">
                <ul class="navbar-nav">
                    <c:if test="${sessionScope.user != null }">
                        ${sessionScope.user.email}
                    </c:if>

                    <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
                    <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
                    <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

                    <c:if test="${isNotLoginPage && isNotRegisterPage}">
                        <c:if test="${sessionScope.user != null }">
                            <li class="nav-item pe-4 pt-2">
                                <a type="button" class="btn btn-sm  btn-outline-primary"
                                   href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.user == null }">
                            <li class="nav-item pe-4 pt-2">
                                <a type="button" class="btn btn-sm  btn-outline-primary"
                                   href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                            </li>
                            <li class="nav-item pt-2">
                                <a type="button" class="btn btn-sm  btn-outline-primary"
                                   href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
                            </li>
                        </c:if>
                    </c:if>
                </ul>
            </div>
        </nav>
    </div>

<%--</header>--%>

<div id="body" class="container" style="min-height: 20vh;">
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container">
    <br>
    <hr>
    <br>
    <jsp:invoke fragment="footer"/>
</div>

</body>
</html>