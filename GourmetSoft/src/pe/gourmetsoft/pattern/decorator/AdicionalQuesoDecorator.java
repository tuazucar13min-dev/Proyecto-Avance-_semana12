/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.decorator;

public class AdicionalQuesoDecorator extends PlatoDecorator {
    public AdicionalQuesoDecorator(IPlatoBase p) { 
        super(p); 
    }
    
    @Override 
    public String getDescripcion() { 
        return platoDecorado.getDescripcion() + " + [Queso Extra]"; 
    }
    
    @Override 
    public double getPrecio() { 
        return platoDecorado.getPrecio() + 3.50; 
    }
}
