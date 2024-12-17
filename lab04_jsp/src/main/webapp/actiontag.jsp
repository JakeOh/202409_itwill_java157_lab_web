<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Action Tag</title>
    </head>
    <body>
        <%@ include file="header.jspf" %>
        
        <main>
            <h1>JSP Action Tag</h1>
            <%-- 
            JSP Action Tag: scriptlet에서 사용되는 일부 자바 코드들을 HTML 또는 XML과
            비슷하게 태그, 태그 속성(attribute), 태그 컨텐트로 작성해서 대체하기 위한 문법.
            액션 태그는 대/소문자를 구분! (HTML 태그는 대/소문자를 구분하지 않음.)
              o. <jsp:forward>: request.getRequestDispatcher("").forward(req, resp)
              o. <jsp:include>: <%@ include file="" %> 비슷.
              o. <jsp:useBean>: (기본) 생성자 호출.
              o. <jsp:getProperty>: getter 메서드 호출.
              o. <jsp:setProperty>: setter 메서드 호출.
            --%>
        </main>
    </body>
</html>
