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
import org.gerdoc.dao.Rol;
import org.gerdoc.dao.RolUsuario;
import org.gerdoc.dao.Usuario;


/**
 *
 * @author gerdoc
 */
public class RolUsuarioService extends MySqlConnection1 implements Serializable
{
    public static RolUsuario getRolUsuarioById (Integer id )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RolUsuario rolUsuario = null;
        Usuario usuario = null;
        Rol rol = null;
        String sql = "SELECT " +
                    "ID," +
                    "USUARIO, " +
                    "PASSWORD," +
                    "CORREO,"+
                    "ROL,"+
                    "DESCRIPCION "+
                    "FROM TBL_ROL_TBL_USER "+
                    "INNER JOIN TBL_ROL ON "+
                    "TBL_ROL_TBL_USER.TBL_ROL_ROL = TBL_ROL.ROL "+
                    "INNER JOIN TBL_USUARIO ON " +
                    "TBL_ROL_TBL_USER.TBL_USUARIO_USUARIO = TBL_USUARIO.USUARIO";;
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
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if( resultSet == null )
            {
                return null;
            }
            
            while( resultSet.next() )
            {
                rolUsuario = new RolUsuario( );
                usuario = new Usuario( );
                rol = new Rol( );
                rolUsuario.setRol(rol);
                rolUsuario.setUsuario(usuario);
                rolUsuario.setId( resultSet.getInt(1) );
                usuario.setUsuario( resultSet.getString(2) );
                usuario.setPassword( resultSet.getString(3) );
                usuario.setCorreo( resultSet.getString(4) );
                rol.setRol( resultSet.getString(5) );
                rol.setDescripcion( resultSet.getString(6) );
                //rolUsuarioList.add(rolUsuario);
                
            }
            preparedStatement.close();
            resultSet.close();
            closeConnection(connection);
            return rolUsuario;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static boolean addRolUsuario( RolUsuario rolUsuario )
    {
        Connection connection = null;        
        String sql = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try 
        {
            if( rolUsuario == null || rolUsuario.getRol() == null || rolUsuario.getUsuario() == null)
            {
                return false;
            }
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            sql = "insert into tbl_rol_tbl_user(rol,usuario) values( ? , ? )";
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, rolUsuario.getRol().getRol() );
            preparedStatement.setString(2, rolUsuario.getUsuario().getUsuario());
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
    
    public static List<RolUsuario> getRolUsuarioList( )
    {
        List<RolUsuario>rolUsuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        RolUsuario rolUsuario = null;
        
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
            resultSet = statement.executeQuery( "SELECT * FROM TBL_ROL_TBL_USER" );
            if( resultSet == null )
            {
                return null;
            }
            rolUsuarioList = new ArrayList<>();
            while( resultSet.next() )
            {
                rolUsuario = new RolUsuario();
                rolUsuario.setId( resultSet.getInt(1) );
                rolUsuario.getRol().setRol(resultSet.getString(2) );
                rolUsuario.getUsuario().setUsuario(resultSet.getString(3) );
                rolUsuarioList.add(rolUsuario);
            }
            resultSet.close();
            closeConnection(connection);
            return rolUsuarioList;
        } 
        catch (SQLException ex) 
        {
           ex.printStackTrace();
        }
        return null;
    }
    
    public static boolean updateRolUsuario( RolUsuario rolUsuario )
    {
        Connection connection = null;        
        String sql = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try 
        {
            if( rolUsuario == null || rolUsuario.getRol() == null || rolUsuario.getUsuario() == null || rolUsuario.getId() == null)
            {
                return false;
            }
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            sql = "update tbl_rol_tbl_user set rol= ?, usuario=? where id = ?";//TODO: CAMBIAR
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(1, rolUsuario.getUsuario().getUsuario());
            preparedStatement.setString(2, rolUsuario.getRol().getRol());
            preparedStatement.setInt(1, rolUsuario.getId());
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
    
    public static boolean deleteRolUsuario( Integer id)
    {
        Connection connection = null;        
        String sql = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        try 
        {
            if( id == null || id == 0)
            {
                return false;
            }
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            sql = "delete from tbl_rolUsuario where id = ?";//TODO: CAMBIAR
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, id);
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