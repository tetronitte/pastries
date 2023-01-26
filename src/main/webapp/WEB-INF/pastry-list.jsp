<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/pastry-list">
        <div class="input-group" style="width: 400px;">
            <div class="form-outline">
                <input name="search" type="text" class="form-control" placeholder="Search" aria-label="Search"
                       aria-describedby="basic-addon1">
            </div>
            <input type="submit" class="btn-btn-primary" value="search"/>
        </div>
    </form>
    <div class="row">
        <c:forEach items="${pastries}" var="pastry">
            <div class="card" style="width: 18rem; border: 1px solid black;">
                <img src="https://sauvageboris.fr/training/api/pastries/images/${pastry.imgName}" class="card-img-top" alt="" />
                <div class="card-body">
                    <h5 class="card-title">${pastry.name}</h5>
                    <p class="card-text">${pastry.description}</p>
                    <form method="post" action="${pageContext.request.contextPath}/delete-pastry">
                        <input type="hidden" name="id" value="${pastry.id}"/>
                        <input type="submit" class="btn-btn-primary" value="Supprimer"/>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>