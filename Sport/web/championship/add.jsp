<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/WEB-INF/sporttags.tld" %>

<!-- breadcrumb -->
<ol class="breadcrumb">
    <li>Adminisztráció</li>
    <li>Bajnokság</li>
    <li class="active">Felvitel</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Torna felvitele</div>
    <div class="panel-body">
        <!-- Form -->        
        <form method="post" action="${pageContext.request.contextPath}/admin/championship/add">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Bajnokság neve</span>
                <input type="text" name="name" class="form-control" placeholder="Bajnokság neve" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Leírás</span>
                <input type="text" name="desc" class="form-control" placeholder="Leírás" aria-describedby="basic-addon1">
            </div>

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sportág</span>
                <s:type css="form-control" id="sel1" name="sport" aria="basic-addon1"></s:type>
<%--                
                <select class="form-control" id="sel1" name="sport" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].sportTypeDAO.all}">
                        <option value="${item.name}">${item.name}</option>
                    </c:forEach>
                </select>
--%>
            </div>                    
            
            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Szezon</span>
                <select class="form-control" id="sel1" name="season" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].seasonDAO.all}">
                        <option value="${item.name}">${item.name}</option>
                    </c:forEach>
                </select>
            </div>                    

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sorozat</span>
                <select class="form-control" id="sel1" name="series" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].seriesDAO.all}">
                        <option value="${item.name}">${item.name}</option>
                    </c:forEach>
                </select>
            </div>                    

            <div class="input-group">
                <input type="submit" value="Felvitel" class="form-control" aria-describedby="basic-addon1">
            </div>

        </form>     
    </div>
</div>            
