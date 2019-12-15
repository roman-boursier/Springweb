<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<title>Liste des pays</title>
    </head>
    <body>
    	   <a href="index.jsp">Page d'accueil</a>

        <table border="1">
            <thead>
                <tr>
                    <th>Identifiant</th>
                    <th>Code ISO</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listCountry}" var="country">
                    <tr>
                        <td><c:out value="${country.idCountry}"/></td>
                        <td><c:out value="${country.codeIso}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>