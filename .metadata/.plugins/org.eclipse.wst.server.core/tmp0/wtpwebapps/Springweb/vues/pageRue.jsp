<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<title>Liste des regions</title>
    </head>
    <body>
    	   <a href="index.jsp">Page d'accueil</a>

        <table border="1">
            <thead>
                <tr>
                    <th>Code postale</th>
                    <th>Nom de rue</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listStreet}" var="street_name">
                    <tr>
                        <td><c:out value="${street_name.idCity}"/></td>
                        <td><c:out value="${street_name.street_name}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>