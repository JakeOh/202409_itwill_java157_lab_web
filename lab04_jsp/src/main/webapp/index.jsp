<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP1</title>
    </head>
    <body>
        <header>
            <h1>Sevlet/JSP 소개</h1>
            <div> <%=LocalDateTime.now()%> </div>
        </header>
        <nav>
            <h2>목차</h2>
            <ul>
                <li>
                    <a href="ex1">첫번째 서블릿</a>
                </li>
            </ul>
        </nav>
    </body>
</html>
