/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daoImpl;

import com.mycompany.config.Conexion;
import com.mycompany.dao.ProductoDao;
import com.mycompany.model.Producto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Docente
 */
public class PrductoDaoImpl implements ProductoDao{
    private Connection cx;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int create(Producto t) {
        String SQL= "INSERT INTO producto (idproducto, nombre, precio, cantidad)"
                + " values(?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setDouble(2, t.getPrecio());
            ps.setInt(3, t.getCantidad());
            x = ps.executeUpdate();
        
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }        
       return x;
    }

    @Override
    public int update(Producto t) {
        String SQL= "UPDATE producto SET nombre=?, precio=?, cantidad=? WHERE idproducto=?";
        int x = 0;
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setDouble(2, t.getPrecio());
            ps.setInt(3, t.getCantidad());
            ps.setInt(4, t.getIdproducto());
            x = ps.executeUpdate();
        
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }        
       return x;
       
    }

    @Override
    public int delete(int id) {
        String SQL= "DELETE FROM producto WHERE idproducto=?";
        int x = 0;
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
              ps.setInt(1, id);
            x = ps.executeUpdate();
        
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }        
       return x;
    }

    @Override
    public Producto read(int id) {
        String SQL= "SELECT *FROM producto WHERE idproducto=?";
        Producto p = new Producto();
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCantidad(rs.getInt("cantidad"));
            }
        
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }        
       return p;
        
    }

    @Override
    public List<Producto> readAll() {
        String SQL= "SELECT *FROM producto";
        List<Producto> lista = new ArrayList<>();
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCantidad(rs.getInt("cantidad"));
                lista.add(p);
            }
        
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }        
       return lista;
        
    }
    
}
