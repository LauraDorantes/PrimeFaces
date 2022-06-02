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

import org.gerdoc.dao.RolUsuario;
import org.gerdoc.service.RolUsuarioService;


/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped

public class RolUsuarioHelper implements Serializable{
    private RolUsuario rolUsuario;
    private boolean edit;
    
    public RolUsuarioHelper(){
        
    }
    
    public boolean loadRolUsuario(){
        if (rolUsuario == null)
        {
            rolUsuario = new RolUsuario();
        }
        return rolUsuario != null;
    }
    
    public void addRolUsuario(){
        if(! RolUsuarioService.addRolUsuario(rolUsuario)){
            System.out.println("Error");
        }
        else{
            rolUsuario = null;
        }
    }
    
    public void editRolUsuario(Integer id){
        if(id == null || id == 0 ){
            return;
        }
        rolUsuario = RolUsuarioService.getRolUsuarioById(id);
        if(rolUsuario == null){
            System.out.println("Error");
            return;
        }
        edit = true;
          
    }

    public List<RolUsuario> getRolUsuarioList(){
        return RolUsuarioService.getRolUsuarioList();
    }
    
    public void updateRolUsuario(){
            if (!RolUsuarioService.updateRolUsuario(rolUsuario)){
                System.out.println("Error");
            }
            else
            {
               rolUsuario = null;
               edit = false;
            }
    }
    public void deleteRolUsuario(Integer id){
            if (!RolUsuarioService.deleteRolUsuario(id)){
                System.out.println("Error");
            }
            else
            {
               rolUsuario = null;
               edit = false;
            }
    }
    
    public RolUsuario getRolUsuario() {
        if (rolUsuario == null)
        {
            if (!loadRolUsuario())
            {
                return null;
            }
        }
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}