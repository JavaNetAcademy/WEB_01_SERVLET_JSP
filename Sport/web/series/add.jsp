<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- breadcrumb -->
<ol class="breadcrumb">
    <li>Adminisztráció</li>
    <li>Sorozat</li>
    <li class="active">Felvitel</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Sorozat felvitele</div>
    <div class="panel-body">
        <!-- Form -->        
        <form method="post" action="${pageContext.request.contextPath}/admin/series/add">
            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sportág</span>
                <select class="form-control" id="sel1" name="sport"  aria-describedby="basic-addon1" multiple>
                    <c:forEach var="item" items="${applicationScope['dataModel'].sportTypeDAO.all}">
                        <option value="${item.name}">${item.name}</option>
                    </c:forEach>
                </select>
            </div>    
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Szezon neve</span>
                <input type="text" name="name" class="form-control" placeholder="Szezon neve" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Leírás</span>
                <input type="text" name="desc" class="form-control" placeholder="Leírás" aria-describedby="basic-addon1">
            </div>

            <div class="input-group">
                <input type="submit" value="Felvitel" class="form-control" aria-describedby="basic-addon1">
            </div>

        </form>     
    </div>
</div>            
