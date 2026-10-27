/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.decorator;

public class PlatoBaseRestaurante implements IPlatoBase{
    private String descripcion;
    private double precio;

    public PlatoBaseRestaurante(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override 
    public String getDescripcion() { 
        return descripcion; 
    }
    
    @Override 
    public double getPrecio() { 
        return precio; 
    }
}
