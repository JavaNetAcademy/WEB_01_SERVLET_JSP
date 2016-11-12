<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- breadcrumb -->
<ol class="breadcrumb">
    <li><a href="/index.jsp">Adminisztráció</a></li>
    <li><a href="/sporttype/index.jsp">Sportág</a></li>
    <li class="active">Lista</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Sportág lista</div>
    <div class="panel-body">
               
        <c:set var="flag" value="false" />
        <div class="list-group">
            <c:forEach var="item" items="${applicationScope['dataModel'].sportTypeDAO.all}">
                <c:set var="flag" value="true" />
                <a href="#" class="list-group-item">
                    <h4 class="list-group-item-heading">${item.name}</h4>
                    <p class="list-group-item-text">${item.desciption}</p>
                </a>
            </c:forEach>    
        </div>
        
                <c:if test="${flag=='false'}">
                    <div class="alert alert-success" role="alert"> Nincs elem a listában </div>
                </c:if>        

    </div>
</div>            
