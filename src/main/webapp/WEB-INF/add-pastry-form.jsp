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
    <div class="row">
        <form method="post" action="${pageContext.request.contextPath}/add-pastry">
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Name</span>
                <input name="name" type="text" class="form-control" placeholder="Name" aria-label="Name"
                       aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon2">Description</span>
                <input name="description" type="text" class="form-control" placeholder="Description" aria-label="Description"
                       aria-describedby="basic-addon2">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon3">Name image</span>
                <input name="imgName" type="textarea" class="form-control" placeholder="Name image" aria-label="Name image"
                       aria-describedby="basic-addon3">
            </div>
            <c:if test="${error}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${error}"/>
                </div>
            </c:if>
            <div class="input-group mb-3">
                <input type="submit" class="btn btn-primary"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>