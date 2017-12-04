<%-- 
    Document   : 404
    Created on : Nov 30, 2017, 7:51:32 PM
    Author     : tienpv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<jsp:include page="header.jsp"></jsp:include>
    <div class="container text-center">
        <div class="logo-404">
            <a href="index.html"><img src="${pageContext.request.contextPath}/resources/images/home/logo.png" alt="" /></a>
        </div>
        <div class="content-404">
            <img src="${pageContext.request.contextPath}/resources/images/404/404.png" class="img-responsive" alt="" />
            <h1><b>OPPS!</b> We Couldn’t Find this Page</h1>
            <p>Uh... So it looks like you brock something. The page you are looking for has up and Vanished.</p>
            <h2><a href="index.html">Bring me back Home</a></h2>
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>

