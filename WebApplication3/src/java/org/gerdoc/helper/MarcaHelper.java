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

import org.gerdoc.dao.Marca;
import org.gerdoc.service.MarcaService;


/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped

public class MarcaHelper implements Serializable{
    private Marca marca;
    private boolean edit;
    
    public MarcaHelper(){
        
    }
    
    public boolean loadMarca(){
        if (marca == null)
        {
            marca = new Marca();
        }
        return marca != null;
    }
    
    public void addMarca(){
        if(! MarcaService.addMarca(marca)){
            System.out.println("Error");
        }
        else{
            marca = null;
        }
    }
    
    public void editMarca(Integer id){
        if(id == null || id == 0 ){
            return;
        }
        marca = MarcaService.getMarcaById(id);
        if(marca == null){
            System.out.println("Error");
            return;
        }
        edit = true;
          
    }

    public List<Marca> getMarcaList(){
        return MarcaService.getMarcaList();
    }
    
    public void updateMarca(){
            if (!MarcaService.updateMarca(marca)){
                System.out.println("Error");
            }
            else
            {
               marca = null;
               edit = false;
            }
    }
    public void deleteMarca(Integer id){
            if (!MarcaService.deleteMarca(id)){
                System.out.println("Error");
            }
            else
            {
               marca = null;
               edit = false;
            }
    }
    
    public Marca getMarca() {
        if (marca == null)
        {
            if (!loadMarca())
            {
                return null;
            }
        }
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
