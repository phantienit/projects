<%-- 
    Document   : login
    Created on : Nov 30, 2017, 7:54:08 PM
    Author     : tienpv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
    <section id="form"><!--form-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-1">
                    <div class="login-form"><!--login form-->
                        <h2><spring:message code="label.login"/></h2>
                    <form action="login.html" method="POST" id="usersForm" name="usersForm">
                        <input id="login-email" name="email" placeholder="<spring:message code="label.email"/>" />
                        <input id="login-password" name="password" type="password" placeholder="<spring:message code="label.password"/>" />
                        <span>
                            <input type="checkbox" class="checkbox"> 
                            <spring:message code="label.remember"/>
                        </span>
                        <!--<span><a href="x"><spring:message code="label.forgot"/></a></span>-->
                        <input type="submit" class="btn btn-default" value="<spring:message code="btn.login"/>" />
                    </form>
                </div><!--/login form-->
            </div>
            <div class="col-sm-1">
                <h2 class="or">OR</h2>
            </div>
            <div class="col-sm-4">
                <div class="signup-form"><!--sign up form-->
                    <h2><spring:message code="label.register"/></h2>
                    <form action="register.html" commandName="usersForm" method="post">
                        <input id="register-userName" name="userName" size="30" placeholder="<spring:message code="label.userName"/>"/>
                        <input id="register-email" name="email" size="30" placeholder="<spring:message code="label.email"/>"/>
                        <input id="register-password" name="password" size="30" placeholder="<spring:message code="label.password"/>" type="password"/>
                        <input type="submit" class="btn btn-default" value="<spring:message code="btn.register"/>" />
                    </form>
                </div><!--/sign up form-->
            </div>
        </div>
    </div>
</section><!--/form-->
<jsp:include page="footer.jsp"></jsp:include>

<script src="<c:url value="/resources/js/login.js"/>" type="text/javascript"></script>
<script>
    var isErr = ${fn:escapeXml(incorrect)};
    if (isErr == true) {
        resultMessage_show(0,"Đăng nhập thất bại!");
        document.getElementById('login-email').focus();
    }
</script>
