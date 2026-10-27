/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.decorator;

public abstract class PlatoDecorator implements IPlatoBase{
    protected IPlatoBase platoDecorado;
    
    public PlatoDecorator(IPlatoBase platoDecorado) { 
        this.platoDecorado = platoDecorado; 
    }
    
    @Override 
    public String getDescripcion() { 
        return platoDecorado.getDescripcion(); 
    }
    
    @Override 
    public double getPrecio() { 
        return platoDecorado.getPrecio(); 
    }

}
