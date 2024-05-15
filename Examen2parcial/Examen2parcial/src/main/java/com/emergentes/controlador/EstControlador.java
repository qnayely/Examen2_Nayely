package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAO_impl;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstControlador", urlPatterns = {"/EstControlador"})
public class EstControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EstudianteDAO dao = new EstudianteDAO_impl();
        Estudiante est = new Estudiante();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("estudiante", est);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    est = dao.getById(id);
                } catch (Exception ex) {

                    System.out.println("Error al obtener el registro: " + ex.getMessage());
                }

                request.setAttribute("estudiante", est);
                request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar el registro: " + ex.getMessage());
                }

                response.sendRedirect("EstControlador");
                break;

            case "view":
                List<Estudiante> lista = new ArrayList<Estudiante>();

                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar: " + ex.getMessage());
                }

                request.setAttribute("estudiantes", lista);
                request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                break;

            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String seminario = request.getParameter("seminario");

        String confirmadoParam = request.getParameter("confirmado");
        boolean confirmado = (confirmadoParam != null);
        Date fecha_inscripcion = Date.valueOf(request.getParameter("fecha_inscripcion"));

        Estudiante est = new Estudiante();

        est.setId(id);
        est.setNombre(nombre);
        est.setApellidos(apellidos);
        est.setSeminario(seminario);
        est.setConfirmado(confirmado);
        est.setFecha_inscripcion(fecha_inscripcion);

        EstudianteDAO dao = new EstudianteDAO_impl();

        if (id == 0) {
            try {
                dao.insert(est);
            } catch (Exception ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
            }
        } else {
            try {
                dao.update(est);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("EstControlador");

    }

}
