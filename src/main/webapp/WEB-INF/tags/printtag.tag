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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
</head>


<body class="container">

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