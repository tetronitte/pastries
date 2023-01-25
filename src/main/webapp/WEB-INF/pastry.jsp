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
        <div class="card" style="width: 18rem; border: 1px solid black;">
            <img src="https://sauvageboris.fr/training/api/pastries/images/${pastry.imgName}" class="card-img-top" alt="" />
            <div class="card-body">
                <h5 class="card-title">${pastry.name}</h5>
                <p class="card-text">${pastry.description}</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
