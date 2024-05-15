package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO_impl extends ConexionBD implements EstudianteDAO{

    @Override
    public void insert(Estudiante est) throws Exception {
        String sql = "insert into estudiantes (nombre, apellidos, seminario, confirmado, fecha_inscripcion) values(?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, est.getNombre());
        ps.setString(2, est.getApellidos());
        ps.setString(3, est.getSeminario());
        ps.setBoolean(4, est.getConfirmado());
        ps.setDate(5, est.getFecha_inscripcion());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Estudiante est) throws Exception {
        String sql = "update estudiantes set nombre=?, apellidos=?, seminario=?, confirmado=?, fecha_inscripcion=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, est.getNombre());
        ps.setString(2, est.getApellidos());
        ps.setString(3, est.getSeminario());
        ps.setBoolean(4, est.getConfirmado());
        ps.setDate(5, est.getFecha_inscripcion());
        ps.setInt(6, est.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql ="delete from estudiantes where id=?";
       this.conectar();
       PreparedStatement ps = this.conn.prepareStatement(sql);
       ps.setInt(1, id);
       ps.executeUpdate();
       this.desconectar();
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        String sql = "select * from estudiantes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Estudiante>();
        while (rs.next()) {            
            Estudiante est = new Estudiante();
            est.setId(rs.getInt("id"));
            est.setNombre(rs.getString("nombre"));
            est.setApellidos(rs.getString("apellidos"));
            est.setSeminario(rs.getString("seminario"));
            est.setConfirmado(rs.getBoolean("confirmado"));
            est.setFecha_inscripcion(rs.getDate("fecha_inscripcion"));
            lista.add(est);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Estudiante getById(int id) throws Exception {
        Estudiante estudiante = new Estudiante();
        String sql = "select * from estudiantes where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {           
            estudiante.setId(rs.getInt("id"));
            estudiante.setNombre(rs.getString("nombre"));
            estudiante.setApellidos(rs.getString("apellidos"));
            estudiante.setSeminario(rs.getString("seminario"));
            estudiante.setConfirmado(rs.getBoolean("confirmado"));
            estudiante.setFecha_inscripcion(rs.getDate("fecha_inscripcion"));
        }
        this.desconectar();
        return estudiante;
    }
    
}
