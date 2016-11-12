<!-- breadcrumb -->
<ol class="breadcrumb">
    <li><a href="/index.jsp">Adminisztráció</a></li>
    <li><a href="/sporttype/index.jsp">Sportág</a></li>
    <li class="active">Felvitel</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Sportág felvitele</div>
    <div class="panel-body">
        <!-- Form -->        
        <form method="post" action="${pageContext.request.contextPath}/admin/sporttype/add">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Neve</span>
                <input type="text" name="name" class="form-control" placeholder="Sportág" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Leírás</span>
                <input type="text" name="desc" class="form-control" placeholder="Leírás" aria-describedby="basic-addon1">
            </div>

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Eredmény értékelése</span>
                <select class="form-control" id="sel1" name="result" aria-describedby="basic-addon1">
                    <option value="NUMBER">Egész szám (gól,pont stb)</option>
                    <option value="FLOAT_NUMBER">Valós szám (pont stb)</option>
                    <option value="TIME">Ido</option>
                </select>
            </div>                    

            <div class="input-group">
                <input type="submit" value="Felvitel" class="form-control" aria-describedby="basic-addon1">
            </div>

        </form>     
    </div>
</div>            
