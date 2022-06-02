/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.gerdoc.dao.Usuario;
import org.gerdoc.service.UsuarioService;


/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped

public class UsuarioHelper implements Serializable{
    private Usuario usuario;
    private boolean edit;
    
    public UsuarioHelper(){
        
    }
    
    public boolean loadUsuario(){
        if (usuario == null)
        {
            usuario = new Usuario();
        }
        return usuario != null;
    }
    
    public void addUsuario(){
        if(! UsuarioService.addUsuario(usuario)){
            System.out.println("Error");
        }
        else{
            usuario = null;
        }
    }
    
    public void editUsuario(String usuario1){
        if(usuario == null ){
            return;
        }
        usuario = UsuarioService.getUsuarioByUsuario(usuario1);
        if(usuario == null){
            System.out.println("Error");
            return;
        }
        edit = true;
          
    }

    public List<Usuario> getUsuarioList(){
        return UsuarioService.getUsuarioList();
    }
    
    public void updateUsuario(){
            if (!UsuarioService.updateUsuario(usuario)){
                System.out.println("Error");
            }
            else
            {
               usuario = null;
               edit = false;
            }
    }
    public void deleteUsuario(String usuario){
            if (!UsuarioService.deleteUsuario(usuario)){
                System.out.println("Error");
            }
            else
            {
               usuario = null;
               edit = false;
            }
    }
    
    public Usuario getUsuario() {
        if (usuario == null)
        {
            if (!loadUsuario())
            {
                return null;
            }
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
