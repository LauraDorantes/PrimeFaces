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

import org.gerdoc.dao.Dos;
import org.gerdoc.service.DosService;


/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped

public class DosHelper implements Serializable{
    private Dos dos;
    private boolean edit;
    
    public DosHelper(){
        
    }
    
    public boolean loadDos(){
        if (dos == null)
        {
            dos = new Dos();
        }
        return dos != null;
    }
    
    public void addDos(){
        if(! DosService.addDos(dos)){
            System.out.println("Error");
        }
        else{
            dos = null;
        }
    }
    
    public void editDos(Integer id){
        if(id == null || id == 0 ){
            return;
        }
        dos = DosService.getDosById(id);
        if(dos == null){
            System.out.println("Error");
            return;
        }
        edit = true;
          
    }

    public List<Dos> getDosList(){
        return DosService.getDosList();
    }
    
    public void updateDos(){
            if (!DosService.updateDos(dos)){
                System.out.println("Error");
            }
            else
            {
               dos = null;
               edit = false;
            }
    }
    public void deleteDos(Integer id){
            if (!DosService.deleteDos(id)){
                System.out.println("Error");
            }
            else
            {
               dos = null;
               edit = false;
            }
    }
    
    public Dos getDos() {
        if (dos == null)
        {
            if (!loadDos())
            {
                return null;
            }
        }
        return dos;
    }

    public void setDos(Dos dos) {
        this.dos = dos;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
