<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Estudiante"%>


<%
    Estudiante est = (Estudiante) request.getAttribute("estudiante");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="estilos.css">
    </head>
    <body>
        <p>
            SEGUNDO PARCIAL <br> 
            Nombre: Nayely Quispe Mamani<br>
            CI: 12768327
        </p>
        <h1>Nuevo Registro</h1>
        <form action="EstControlador" method="post">
            <input type="hidden" name="id" value="${est.id}" />
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${est.nombre}" /></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="${est.apellidos}" /></td>
                </tr>
                <tr>
                    <td>Seminario</td>
                    <td><input type="text" name="seminario" value="${est.seminario}" /></td>
                </tr>
                <tr>
                    <td>Confirmado</td>
                    <td>
                        <input type="checkbox" name="confirmado" ${est.confirmado ? 'checked' : ''} />
                    </td>
                </tr>

                <tr>
                    <td>Fecha Inscripcion</td>
                    <td><input type="date" name="fecha_inscripcion" value="${est.fecha_inscripcion}" /></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
