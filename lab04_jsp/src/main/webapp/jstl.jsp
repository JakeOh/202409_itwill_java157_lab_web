<%@ page import="com.itwill.jsp1.model.Contact" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSTL</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
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
            
            <% 
            String[] sns = { "인*", "얼굴책", "X", "싸이월드" };
            pageContext.setAttribute("sites", sns);
            %>
            
            <h2>scriptlet, expression 사용한 리스트</h2>
            <ul>
            <% for (String s : sns) { %>
                <li><%= s %></li>
            <% } %>
            </ul>
            
            <h2>JSTL, EL 사용한 리스트</h2>
            <ul>
                <c:forEach var="s" items="${ sites }">
                    <li>${ s }</li>
                </c:forEach>
            </ul>
            
            <% 
            // 테이블을 작성하기 위한 더미 데이터.
            ArrayList<Contact> contacts = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Contact c = new Contact(i, "이름-" + i, "전화번호-" + i, "이메일-" + i);
                contacts.add(c);
            }
            
            // EL에서 리스트를 사용할 수 있도록 contacts를 pageContext에 저장.
            pageContext.setAttribute("contactList", contacts);
            %>
            
            <h2>scriptlet, expression 사용한 테이블 작성</h2>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>전화번호</th>
                        <th>이메일</th>
                    </tr>
                </thead>
                <tbody>
                <% for (Contact c : contacts) { %>
                    <tr>
                        <td><%= c.getId() %></td>
                        <td><%= c.getName() %></td>
                        <td><%= c.getPhone() %></td>
                        <td><%= c.getEmail() %></td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        
            <h2>JSTL, EL 사용한 테이블 작성</h2>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>전화번호</th>
                        <th>이메일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ contactList }" var="c">
                        <tr>
                            <td>${ c.id }</td> <%-- EL은 프로퍼티 이름으로 getter 메서드를 찾음. --%>
                            <td>${ c.name }</td>
                            <td>${ c.phone }</td>
                            <td>${ c.email }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
        </main>
    </body>
</html>
