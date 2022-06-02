/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.dao;
import java.io.Serializable;

/**
 *
 * @author Alumno
 */
public class Producto implements Serializable
{
    private Integer id;
    private String nombre;
    private String descripcion;
    private String url;
    private Integer preciopublico;
    private Integer costo;
    private Marca marca;
    private Provedor provedor;

    public Producto() 
    {
    }

    public Producto(Marca marca, Provedor provedor) 
    {
        this.marca = marca;
        this.provedor = provedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPreciopublico() {
        return preciopublico;
    }

    public void setPreciopublico(Integer preciopublico) {
        this.preciopublico = preciopublico;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }
    
    
    
    
}
