<%-- 
    Document   : menu
    Created on : Nov 30, 2017, 7:45:12 PM
    Author     : tienpv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-3">
    <div class="left-sidebar">
        <!--category-productsr-->
        <!--
        <h2>Category</h2>
        <div class="panel-group category-products" id="accordian">
            <div class="panel panel-default">
                <div class="panel-heading">
        <%--<c:forEach var="item" items="${lstCategory}">--%>
        <h4 class="panel-title"><a href="#">${fn:escapeXml(item.name)}</a></h4>
        <%--</c:forEach>--%>
    </div>
</div>
</div>
        -->
        <!--/category-products-->

        <!--brands_products-->

        <div class="brands_products">
            <h2>Category</h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <c:forEach var="item" items="${lstCategory}">
                        <h4 class="panel-title"><a href="#"></a></h4>
                        <li><a href="${pageContext.request.contextPath}/category/category_${fn:escapeXml(item.categoryId)}.html">${fn:escapeXml(item.name)}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <!--/brands_products-->

        <!--price-range-->
        <div class="price-range">
            <h2>Price Range</h2>
            <div class="well text-center">
                <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
                <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
            </div>
        </div>
        <!--/price-range-->

        <!--shipping-->
        <!--
        <div class="shipping text-center">
            <img src="${pageContext.request.contextPath}/resources/images/home/shipping.jpg" alt="" />
        </div>
        -->
        <!--/shipping-->

    </div>
</div>
