<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="card card-inverse card-primary mb-3 text-center">
    <div class="card-block">
        <h3 class="card-title">Hero</h3>
        <p class="card-text">List of Heroes.</p>
    </div>
</div>



<table class="table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Available</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="hero" items="${heroes}" varStatus="ln">
            <c:set var="class" value="default" />
            <c:choose>
                <c:when test="${ln.index % 3 == 0}">
                    <c:set var="class" value="table-primary" />
                </c:when>
                <c:when test="${ln.index % 3 == 1}">
                    <c:set var="class" value="table-success" />
                </c:when>
                <c:otherwise>
                    <c:set var="class" value="table-danger" />
                </c:otherwise>
            </c:choose>
            <tr class="${class}">          
                <td>${hero.name} </td>
                <td>${hero.description}</td>
                <td>${hero.available}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<form method="post" action="hero">
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Name:</span>
        <input name="name" type="text" class="form-control" placeholder="Name" aria-describedby="basic-addon1">
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Description</span>
        <input  name="description" type="text" class="form-control" placeholder="Description" aria-describedby="basic-addon1">
    </div>

    <div class="input-group">
        <span class="input-group-addon">
            <input  name="active" type="checkbox" aria-label="Checkbox for following text input">
        </span>
        <span class="input-group-addon" id="basic-addon2">Active</span>
    </div>

    <div class="input-group">
        <span class="input-group-addon">
            <input type="submit" aria-label="Checkbox for following text input">
        </span>
    </div>
</form>    