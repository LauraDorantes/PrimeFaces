/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.dao;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alumno
 */
public class Uno implements Serializable
{
    private Integer id;
    private Integer campo1;
    private String campo2;
    private String campo3;
    private Date campo4;

    public Uno() 
    {       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCampo1() {
        return campo1;
    }

    public void setCampo1(Integer campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public Date getCampo4() {
        return campo4;
    }

    public void setCampo4(Date campo4) {
        this.campo4 = campo4;
    }
    
    
}