<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
<title>test</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
</head>


<body>

<div class="col-md-4 col-md-offset-4">
    <form action="login/process" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Логин</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Логин" name="username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Пароль" name="password">
        </div>
        <c:if test="${error}">
            <h4>Incorrect login or password</h4>
        </c:if>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
        <form action="registration">
         <button type="submit" class="btn btn-default">Sign Up</button>
         </form>
</div>

</body>
</html>