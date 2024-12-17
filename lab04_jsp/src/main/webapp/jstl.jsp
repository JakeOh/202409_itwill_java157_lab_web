<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSTL</title>
    </head>
    <body>
        <%@ include file="header.jspf" %>
        
        <main>
            <h1>JSTL(JSP/Jakarta Standard Tag Library)</h1>
            <%-- JSTL 사용하기:
              1. pom.xml 파일에 의존성(dependency)을 추가.
                 o. jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:version
                 o. org.glassfish.web:jakarta.servlet.jsp.jstl:version
              2. JSTL을 사용하는 jsp 파일에서 지시문 <%@ taglib prefix="" url="" %>을 작성.
            --%>
        </main>
    </body>
</html>
