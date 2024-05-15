<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>


<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    List<Estudiante> estudiantes = (List<Estudiante>) request.getAttribute("estudiantes");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP PAGE</title>

    </head>
    <body>
        <p>
            SEGUNDO PARCIAL <br> 
            Nombre: Nayely Quispe Mamani<br>
            CI: 12768327
        </p>
    </div>

    <h1>Registro Dia Del Internet</h1>

    <p><a href="EstControlle?action=add">Nuevo</a></p>

    <table border="1">

        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Seminario</th>
            <th>Confirmado</th>
            <th>Fecha Inscripcion</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach var="item" items="${estudiantes}">

            <tr>
                <td>${item.id}</td>
                <td>${item.nombre}</td>
                <td>${item.apellidos}</td>
                <td>${item.seminario}</td>
                <td>
                    <input type="checkbox" ${item.confirmado ? 'checked' : ''} />
                </td>
                <td>${item.fecha_inscripcion}</td>
                <td><a href="EstControlador?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="EstControlador?action=delete&id=${item.id}">Eliminar</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
