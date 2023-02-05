<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Перевозчики</title>
    </head>
    <body>

        <div align="center">
            <h2>Перевозчики</h2>
            <form method="get" action="search">
                <input type="text" name="filter" />  
                <input type="submit" value="Поиск" />
            </form>
            <h3><a href="new">Создать</a></h3>
            <table border="1" cellpadding="5">
                <tr>
                    <th>№</th>
                    <th>Наименование</th>
                    <th>ИНН</th>
                    <th>Адрес</th>
                    <th>Страна</th>
                    <th>Налогообложение</th>
                </tr>
                <c:forEach items="${carriers}" var="person">
                    <tr>
                        <td><c:out value="${person.id}"/></td>
                        <td><c:out value="${person.name}"/></td>
                        <td><c:out value="${person.inn}"/></td>
                        <td><c:out value="${person.address}"/></td>
                        <td><c:out value="${person.country}"/></td>
                        <td><c:out value="${person.tax_system}"/></td>
                        <td>
                            <a href="edit?id=${person.id}">Изменить</a>
                        </td>
                        <td>
                            <a href="delete?id=${person.id}">Удалить</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
