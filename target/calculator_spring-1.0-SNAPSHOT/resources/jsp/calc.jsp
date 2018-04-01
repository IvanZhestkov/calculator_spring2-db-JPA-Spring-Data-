<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />

<html>
<head>
    <title>Calculator</title>
</head>
<body>
<sf:form method="post" action="calc" modelAttribute="calc">
        <div id="digitInput">
            <sf:label path="digit">Введите число</sf:label>
            <sf:input path="digit" />
            <sf:errors path="digit"/>

        </div>

        <div id="last_result">
            <div class="panel panel-default">
                <div class="panel-body lastDigit">${calc.digit}</div>
            </div>

            <div class="panel panel-default">
                <div class="panel-body lastOper">${calc.operation}</div>
            </div>
        </div>

        <div>
            <button type="submit" name="operation" value="+">+</button>
            <button type="submit" name="operation" value="-">-</button>
            <button type="submit" name="operation" value="*">*</button>
            <button type="submit" name="operation" value="/">/</button>
            <button type="submit" name="operation" value="=">=</button>
        </div>
    </sf:form>

    <form action="logout">
                             <button type="submit" class="btn btn-default">Log out</button>
    </form>

</body>
</html>

