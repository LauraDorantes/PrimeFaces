/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Provedor;
import org.gerdoc.dao.Producto;
import org.gerdoc.dao.Marca;

/**
 *
 * @author gerdoc
 */
public class ProductoService 
{
    
    public List<Producto> getProductoList( )
    {
        List<Producto>productoList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Producto producto = null;
        String sql = null;
        Marca marca = null;
        Provedor provedor = null;
        
        try 
        {
            connection = MySqlConnection1.getConnection( );
            if( connection == null )
            {
                return null;
            }
            statement = connection.createStatement( );
            if( statement == null )
            {
                return null;
            }
            sql = "SELECT " +
                    "TBL_PRODUCTOS.ID, " +
                    "TBL_PRODUCTOS.NOMBRE, " +
                    "TBL_PRODUCTOS.DESCRIPCION, " +
                    "TBL_PRODUCTOS.URL,"+
                    "TBL_PRODUCTOS.PRECIOPUBLICO, "+
                    "TBL_PRODUCTOS.COSTO, "+
                    "TBL_MARCA.ID, " +
                    "TBL_MARCA.MARCA, " +
                    "TBL_PROVEDOR.ID, " +
                    "TBL_PROVEDOR.NOMBRE "+
                    "FROM TBL_PRODUCTOS "+
                    "INNER JOIN TBL_PROVEDOR ON "+
                    "TBL_PRODUCTOS.TBL_PROVEDOR_ID = TBL_PROVEDOR.ID "+
                    "INNER JOIN TBL_MARCA ON " +
                    "TBL_PRODUCTOS.TBL_MARCA_ID = TBL_MARCA.ID";
            resultSet = statement.executeQuery( sql );
            if( resultSet == null )
            {
                return null;
            }
            productoList = new ArrayList<>();
            while( resultSet.next() )
            {
                producto = new Producto( new Marca(), new Provedor());
                producto.setId( resultSet.getInt(1) );
                producto.setNombre( resultSet.getString(2) );
                producto.setDescripcion( resultSet.getString(3) );
                producto.setUrl( resultSet.getString(4) );
                producto.setPreciopublico( resultSet.getInt(5) );
                producto.setCosto( resultSet.getInt(6) );
                producto.getMarca().setId(resultSet.getInt(7));
                producto.getMarca().setMarca(resultSet.getString(8));
                producto.getProvedor().setId(resultSet.getInt(9));
                producto.getProvedor().setNombre(resultSet.getString(10));
                productoList.add(producto);      
            }
            resultSet.close();
            MySqlConnection1.closeConnection(connection);
            return productoList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addProducto( Producto producto )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_PRODUCTOS (TBL_PROVEDOR_ID,TBL_MARCA_ID, NOMBRE, DESCRIPCION, URL, PRECIOPUBLICO, COSTO) VALUES(?,?,?,?,?,?,?)";
        int row = 0;
        try 
        {
            connection = MySqlConnection1.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, producto.getProvedor().getId());
            preparedStatement.setInt(2, producto.getMarca().getId());
            preparedStatement.setString(3, producto.getNombre());
            preparedStatement.setString(4, producto.getDescripcion());
            preparedStatement.setString(5, producto.getUrl());
            preparedStatement.setInt(6, producto.getPreciopublico());
            preparedStatement.setInt(7, producto.getCosto());
            row = preparedStatement.executeUpdate();
            MySqlConnection1.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteProducto( Producto producto )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM TBL_PRODUCTOS WHERE ID = ?";
        int row = 0;
        try 
        {
            connection = MySqlConnection1.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, producto.getProvedor().getProvedor());
            preparedStatement.setInt(2, producto.getId());
            row = preparedStatement.executeUpdate();
            MySqlConnection1.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Producto getProductoById( Integer id )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM TBL_PRODUCTOS WHERE ID= ?";
        Producto producto = null;
        try 
        {
            connection = MySqlConnection1.getConnection( );
            if( connection == null )
            {
                return null;
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id );
            resultSet = preparedStatement.executeQuery( );
            if( resultSet == null )
            {
                return null;
            }
            while( resultSet.next() )
            {
                producto = new Producto();
                /*producto.setCosto(resultSet.getInt(1) );
                producto.setPreciopublico(resultSet.getInt(2) );
                producto.setUrl(resultSet.getString(3) );
                producto.setDescripcion(resultSet.getString(4) );
                producto.setNombre(resultSet.getString(5) );
                producto.setId(resultSet.getInt(6) );*/
                producto.getProvedor().setNombre(resultSet.getString(1));
                producto.getProvedor().setId(resultSet.getInt(2));
                
            }
            resultSet.close();
            MySqlConnection1.closeConnection(connection);
            return producto;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean updateProducto( Producto producto )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update TBL_PRODUCTOS SET NOMBRE=?, DESCRIPCION=?, URL=?, PRECIOPUBLICO=?, COSTO=? WHERE ID = ?";
        int row = 0;
        try 
        {
            connection = MySqlConnection1.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            
            //preparedStatement.setInt(1, producto.getCosto());
            //preparedStatement.setInt(2, producto.getPreciopublico());
            //preparedStatement.setString(3, producto.getUrl());
            //preparedStatement.setString(4, producto.getDescripcion());
            //preparedStatement.setString(5, producto.getNombre());
            //preparedStatement.setInt(6, producto.getId());
            preparedStatement.setString(1, producto.getProvedor().getNombre());
            preparedStatement.setInt(2, producto.getProvedor().getId());
            row = preparedStatement.executeUpdate();
            MySqlConnection1.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
}