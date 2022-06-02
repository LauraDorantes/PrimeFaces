/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

/**
 *
 * @author ldrnt
 */
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.gerdoc.dao.Provedor;
import org.gerdoc.service.ProvedorService;


/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped

public class ProvedorHelper implements Serializable{
    private Provedor provedor;
    private boolean edit;
    
    public ProvedorHelper(){
        
    }
    
    public boolean loadProvedor(){
        if (provedor == null)
        {
            provedor = new Provedor();
        }
        return provedor != null;
    }
    
    public void addProvedor(){
        if(! ProvedorService.addProvedor(provedor)){
            System.out.println("Error");
        }
        else{
            provedor = null;
        }
    }
    
    public void editProvedor(Integer id){
        if(id == null || id == 0 ){
            return;
        }
        provedor = ProvedorService.getProvedorById(id);
        if(provedor == null){
            System.out.println("Error");
            return;
        }
        edit = true;
          
    }

    public List<Provedor> getProvedorList(){
        return ProvedorService.getProvedorList();
    }
    
    public void updateProvedor(){
            if (!ProvedorService.updateProvedor(provedor)){
                System.out.println("Error");
            }
            else
            {
               provedor = null;
               edit = false;
            }
    }
    public void deleteProvedor(Integer id){
            if (!ProvedorService.deleteProvedor(id)){
                System.out.println("Error");
            }
            else
            {
               provedor = null;
               edit = false;
            }
    }
    
    public Provedor getProvedor() {
        if (provedor == null)
        {
            if (!loadProvedor())
            {
                return null;
            }
        }
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
