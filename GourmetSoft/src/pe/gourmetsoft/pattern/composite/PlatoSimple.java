/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.composite;

public class PlatoSimple implements IComponenteCarta{
    private String nombre;
    private double precio;
    
    public PlatoSimple(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public double obtenerPrecio(){
        return this.precio;
    }
    
    @Override
    public void mostrarDetalle(String nivel){
        System.out.println(nivel + "- Plato: " + nombre + " | S/. " + precio);
    }
}
