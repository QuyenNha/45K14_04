

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<jsp:useBean id="CategoryDAO" scope="page" class="dao.CategoryDAO" />
<jsp:setProperty name="CategoryDAO" property="*" />
<c:set var="LIST_CATEGORY" value="${CategoryDAO.getList()}"/>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${LIST_CATEGORY}" var="crr">
                <li class="list-group-item text-white"><a href="LoadCategory?cId=${crr.cId}">${crr.name}</a></li>
                </c:forEach>

        </ul>
    </div>
    
</div>