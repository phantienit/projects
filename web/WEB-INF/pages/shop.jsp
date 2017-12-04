<%-- 
    Document   : shop
    Created on : Nov 30, 2017, 7:54:57 PM
    Author     : tienpv
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<jsp:include page="header.jsp"></jsp:include>
<section id="advertisement">
    <div class="container">
        <img src="${pageContext.request.contextPath}/resources/images/shop/advertisement.jpg" alt="" />
    </div>
</section>

<section>
    <div class="container">
        <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">Features Items</h2>

                <c:forEach var="item" items="${lstProduct}">
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="${pageContext.request.contextPath}/${fn:escapeXml(item.imgLink)}" alt="${fn:escapeXml(item.name)}" />
                                    <h2>${fn:escapeXml(item.price)}</h2>
                                    <a href="${pageContext.request.contextPath}/product/product_${fn:escapeXml(item.productId)}.html"><p>${fn:escapeXml(item.name)}</p></a>
                                    <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <p>${fn:escapeXml(item.shortDes)}</p>
                                        <h2>${fn:escapeXml(item.price)}</h2>
                                        <a href="${pageContext.request.contextPath}/product/product_${fn:escapeXml(item.productId)}.html"><p>${fn:escapeXml(item.name)}</p></a>
                                        <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                </div>
                            </div>
                            <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href=""><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                    <li><a href=""><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>


                </c:forEach>
                <div style="clear: both;"></div>

                <ul class="pagination">
                    <li class="active"><a href="">1</a></li>
                    <li><a href="">2</a></li>
                    <li><a href="">3</a></li>
                    <li><a href="">&raquo;</a></li>
                </ul>
                </div><!--features_items-->
            </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
