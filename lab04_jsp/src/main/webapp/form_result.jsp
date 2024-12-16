<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
        <style>
            <% 
            // 요청 파라미터 color의 값을 찾음.
            String color = request.getParameter("color");
            String textColor = null;
            switch (color) {
            case "r":
                textColor = "crimson";
                break;
            case "g":
                textColor = "MediumSeaGreen";
                break;
            case "b":
                textColor = "DodgerBlue";
                break;
            default:
                textColor = "black";
            }
            %>
            
            span#username {
                color: <%= textColor %>;
            }
        </style>
    </head>
    <body>
        <%@ include file="header.jspf" %>
        
        <main>
            <h1>폼 양식 제출 결과</h1>
            
            <%
            // 클라이언트에서 전송한 요청 파라미터의 값을 찾는 방법:
            String username = request.getParameter("username");
            %>
            <h2>안녕하세요, <span id="username"><%= username %></span>!</h2>
            
            <% if (username.equals("admin")) { %>
                <h3>관리자 페이지</h3>
            <% } else { %>
                <h3>일반 사용자 페이지</h3>
            <% } %>
            
        </main>
    </body>
</html>
