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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap/js/bootstrap.bundle.min.js">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/scss/custom.css">
</head>


<body>
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