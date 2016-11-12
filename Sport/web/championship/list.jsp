<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- breadcrumb -->
<ol class="breadcrumb">
    <li><a href="/index.jsp">Adminisztráció</a></li>
    <li><a href="/sporttype/index.jsp">Sorozat</a></li>
    <li class="active">Lista</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Bajnokság lista</div>
    <div class="panel-body">

        <form method="post" action="${pageContext.request.contextPath}/admin/championship/list">
            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sportág</span>
                <select class="form-control" id="sel1" name="sport" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].sportTypeDAO.all}">
                        <c:choose>
                            <c:when test="${(selectedSportType != null && item.name==selectedSportType.name) || item.name == param['sport']}">
                                <option selected="" value="${item.name}">${item.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.name}">${item.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>                    
            
            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Szezon</span>
                <select class="form-control" id="sel1" name="season" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].seasonDAO.all}">
                        <c:choose>
                            <c:when test="${selectedSeason != null && selectedSeason.name == item.name}">
                                <option selected="" value="${item.name}">${item.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.name}">${item.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>                    

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sorozat</span>
                <select class="form-control" id="sel1" name="series" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].seriesDAO.all}">
                        <c:choose>
                            <c:when test="${selectedSeason != null && selectedSeason.name == item.name}">
                                <option selected="" value="${item.name}">${item.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.name}">${item.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>                    
            
            <div class="input-group">
                <input type="submit" value="Felvitel" class="form-control" aria-describedby="basic-addon1">
            </div>

        </form>     
            
        
        <c:set var="flag" value="false" />
        <div class="list-group">
            <c:forEach var="item" items="${championships}">
                <c:set var="flag" value="true" />
                <a href="#" class="list-group-item">
                    <h4 class="list-group-item-heading">${item.name}</h4>
                    <p class="list-group-item-text">${item.description}</p>
                </a>
            </c:forEach>    
        </div>
        
                <c:if test="${flag=='false'}">
                    <div class="alert alert-success" role="alert"> Nincs elem a listában </div>
                </c:if>        
    </div>
</div>            
