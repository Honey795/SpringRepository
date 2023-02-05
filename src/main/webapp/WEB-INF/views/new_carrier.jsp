<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<html>
    <head>
        <title>Новый перевозчик</title>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <fmt:requestEncoding value = "UTF-8"/>
        <div align="center">
            <h1>Новый перевозчик</h1>
            <form:form action="save" acceptCharset="utf-8" method="post" modelAttribute="carrier">
                <table border="0" cellpadding="5">
                    <tr>
                        <td>Наименование:</td>
                        <td><form:input path="name"/></td>
                    </tr>
                    <tr>
                        <td>ИНН:</td>
                        <td><form:input path="inn"/></td>
                    </tr>
                    <tr>
                        <td>Адрес:</td>
                        <td><form:input path="address"/></td>
                    </tr>    
                    <tr>
                        <td>Страна:</td>
                        <td><form:input path="country"/></td>
                    </tr>   
                    <tr>
                        <td>Налогообложение:</td>
                        <td><form:input path="tax_system"/></td>
                    </tr>   
                    <tr>
                        <td colspan="2"><input type="submit" value="Save"></td>
                    </tr>                    
                </table>
            </form:form>
        </div>
    </body>
</html>
