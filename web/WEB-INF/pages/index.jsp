<%-- 
    Document   : index
    Created on : Nov 29, 2017, 8:54:57 PM
    Author     : tienpv
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="slider.jsp"></jsp:include>
<section>
    <div class="container">
        <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <jsp:include page="content.jsp"></jsp:include>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
    
