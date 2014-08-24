<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:bundle basename="i18n.messages">
    <html>

    <head>
        <title>Welcome</title>
        <link rel='stylesheet' href='<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>'>
        <link rel='stylesheet' href='<c:url value="/style/index.css"/>'>
    </head>
    <body background="style/img/background.jpg" onload="">

    <div class="main panel panel-default">
        <div class="authentication panel panel-default">
            <c:if test="${not empty user}">
                <div id="autorized" class="border panel panel-default">
                    <label id="Welcome">Welcome ${user.getFirstName()}</label>
                    <br>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                        Exit
                    </button>
                </div>
            </c:if>
            <c:if test="${empty user}">
                <div id="unAutorized" class="border panel panel-default">
                    <form action="${pageContext.request.contextPath}/do/LoginAction" method="post">
                        <label for="inputLogin" class="label">Login</label>
                        <input type="text" name="authenticationLogin" class="form-control" id="inputLogin" value="Vano34">
                        <label for="inputPassword" class="label">Password</label>
                        <input type="text" name="authenticationPassword" class="form-control" id="inputPassword" value="101287">
                        <input type="submit" class="loginbtn btn btn-primary" value="Login">
                        <button class="registrationbtn btn btn-primary" data-toggle="modal" data-target="#myModal">
                            Registration
                        </button>

                        <input type="hidden" name="TableName" value="Clients">
                        <input type="hidden" name="actionName" value="LoginAction">
                    </form>
                </div>
            </c:if>

        </div>

        <div class="banner panel panel-default">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="style/img/background.jpg" alt="...">

                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="style/img/water/water.jpg" alt="...">

                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="style/img/water/water1.jpg" alt="...">

                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="style/img/water/water2.jpg" alt="...">

                        <div class="carousel-caption">
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </div>

        <div class="contactInformation panel panel-default" style="overflow-y: scroll">
            <c:forEach var="contact" items="${contacts}">
                <label>${contact.owner}: ${contact.telephone}</label>
            </c:forEach>
            <label>Rodion Starodubenko: +77003996925</label>
            <label>Rodion Starodubenko: +77003996925</label>
            <label>Rodion Starodubenko: +77003996925</label>
            <label>Rodion Starodubenko: +77003996925</label>
            <label>Rodion Starodubenko: +77003996925</label>
            <label>Rodion Starodubenko: +77003996925</label>
            <label>Rodion Starodubenko: +77003996925</label>
        </div>
    </div>

    <div>
        <form action="${pageContext.request.contextPath}/controller">
            <input type="submit" value="Go to DataBase">
            <ul class="pager">
                <li class="previous"><a href="#">&larr; Older</a></li>
                <li class="next"><a href="#">Newer &rarr;</a></li>
            </ul>
            <input type="hidden" name="actionName" value="DeleteFromDataBaseAction"> //
        </form>
    </div>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Registration form</h4>
                </div>
                    <%--<c:forEach var="title" items="${titlesOfColumns}">--%>
                <form action="${pageContext.request.contextPath}/controller">
                    <div class="registration">
                        <div class="form-group">
                            <label for="Login" class="label">Login</label>
                            <input type="text" name="RegistrationFormValues" value="Ivanov99" class="form-control"
                                   id="Login">
                        </div>
                        <div class="form-group">
                            <label for="Password" class="label">Password</label>
                            <input type="text" name="RegistrationFormValues" value="Ivanov9" class="form-control"
                                   id="Password">
                        </div>
                        <div class="form-group">
                            <label for="Firsname" class="label">Firsname</label>
                            <input type="text" name="RegistrationFormValues" value="Ivan" class="form-control"
                                   id="Firsname">
                        </div>
                        <div class="form-group">
                            <label for="Lastname" class="label">Lastname</label>
                            <input type="text" name="RegistrationFormValues" value="Ivanov" class="form-control"
                                   id="Lastname">
                        </div>
                        <div class="form-group">
                            <label for="Middlename" class="label">Middlename</label>
                            <input type="text" name="RegistrationFormValues" value="Ivanovich" class="form-control"
                                   id="Middlename">
                        </div>
                        <div class="form-group">
                            <label for="Address" class="label">Address</label>
                            <input type="text" name="RegistrationFormValues" value="Ivanova-32" class="form-control"
                                   id="Address">
                        </div>
                        <div class="form-group">
                            <label for="Telephone" class="label">Telephone</label>
                            <input type="text" name="RegistrationFormValues" value="87212965896" class="form-control"
                                   id="Telephone">
                        </div>
                        <div class="form-group">
                            <label for="Mobilephone" class="label">Mobilephone</label>
                            <input type="text" name="RegistrationFormValues" value="87007778958" class="form-control"
                                   id="Mobilephone">
                        </div>
                    </div>
                        <%--</c:forEach>--%>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close registration form
                        </button>
                        <button type="submit" class="btn btn-primary">Registration</button>
                    </div>
                    <input type="hidden" name="actionName" value="ClientRegistrationAction">
                    <input type="hidden" name="TableName" value="Clients">
                </form>
            </div>
        </div>
    </div>

    <script src="script/indexScript.js"></script>
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
    </html>
</fmt:bundle>
