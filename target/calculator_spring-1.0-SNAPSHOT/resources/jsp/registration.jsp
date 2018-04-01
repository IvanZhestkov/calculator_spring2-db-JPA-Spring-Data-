<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
<title>test</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
</head>


<body>
<div class="col-md-4 col-md-offset-4">
<sf:form action="registration" method="post" modelAttribute="userform">
    <div class="form-group">
        <label for="username">Логин</label>
        <sf:input path="username" id="username" class="form-control" placeholder="Логин"/>
        <sf:errors path="username"/>

    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <sf:input path="password" id="password" class="form-control" type="password" placeholder="Пароль"/>
        <sf:errors path="password"/>
    </div>
    <div class="form-group">
        <label for="repassword">Ещё раз</label>
        <sf:input path="repassword" id="repassword" class="form-control" type="password" placeholder="Повторите пароль"/>
        <sf:errors/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <sf:input path="email" id="email" class="form-control" placeholder="Email"/>
        <sf:errors path="email"/>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</sf:form>
</div>

</body>
</html>