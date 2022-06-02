/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Usuario;


/**
 *
 * @author gerdoc
 */
public class UsuarioService extends MySqlConnection1 implements Serializable
{
    public static Usuario getUsuarioByUsuario (String usuario1)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;
        String sql = "SELECT * FROM TBL_USUARIO where usuario =?";
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return null;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return null;
            }
            preparedStatement.setString(1, usuario1);
            resultSet = preparedStatement.executeQuery();
            if( resultSet == null )
            {
                return null;
            }
            
            while( resultSet.next() )
            {
                usuario = new Usuario();
                usuario.setUsuario( resultSet.getString(1) );
                usuario.setPassword(resultSet.getString(2) );
                usuario.setCorreo(resultSet.getString(3) );
                
            }
            preparedStatement.close();
            resultSet.close();
            closeConnection(connection);
            return usuario;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static boolean addUsuario( Usuario usuario )
    {
        Connection connection = null;        
        String sql = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try 
        {
            if( usuario == null || usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getCorreo() == null )
            {
                return false;
            }
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            sql = "insert into tbl_usuario(usuario, password, correo) values( ? , ? , ?)";
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, usuario.getUsuario() );
            preparedStatement.setString(2, usuario.getPassword() );
            preparedStatement.setString(3, usuario.getCorreo());
            row = preparedStatement.executeUpdate();
            if( row == 0 )
            {
                return false;
            }
            preparedStatement.close();
            closeConnection(connection);
            return true;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static List<Usuario> getUsuarioList( )
    {
        List<Usuario>usuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;
        
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return null;
            }
            statement = connection.createStatement( );
            if( statement == null )
            {
                return null;
            }
            resultSet = statement.executeQuery( "SELECT * FROM TBL_USUARIO" );
            if( resultSet == null )
            {
                return null;
            }
            usuarioList = new ArrayList<>();
            while( resultSet.next() )
            {
                usuario = new Usuario();
                usuario.setUsuario( resultSet.getString(1) );
                usuario.setPassword(resultSet.getString(2) );
                usuario.setCorreo(resultSet.getString(3) );
                usuarioList.add(usuario);
            }
            resultSet.close();
            closeConnection(connection);
            return usuarioList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static boolean updateUsuario( Usuario usuario )
    {
        Connection connection = null;        
        String sql = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try 
        {
            if( usuario == null || usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getCorreo() == null )
            {
                return false;
            }
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            sql = "update tbl_usuario SET USUARIO=?, PASSWORD= ?, CORREO=? where usuario = ?";//TODO: CAMBIAR
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, usuario.getCorreo());
            preparedStatement.setString(2, usuario.getPassword() );
            preparedStatement.setString(3, usuario.getUsuario());
            row = preparedStatement.executeUpdate();
            if( row == 0 )
            {
                return false;
            }
            preparedStatement.close();
            closeConnection(connection);
            return true;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean deleteUsuario( String usuario )
    {
        Connection connection = null;        
        String sql = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try 
        {
            if( usuario == null)
            {
                return false;
            }
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            sql = "delete from tbl_usuario where usuario = ?";//TODO: CAMBIAR
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, usuario);
            row = preparedStatement.executeUpdate();
            if( row == 0 )
            {
                return false;
            }
            preparedStatement.close();
            closeConnection(connection);
            return true;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
}
