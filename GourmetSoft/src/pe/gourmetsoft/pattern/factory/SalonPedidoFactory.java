/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.factory;

public class SalonPedidoFactory implements PedidoAbstractFactory{
   @Override 
   public Comprobante crearComprobante() { 
       return new ComprobanteSalon(); 
   }
    @Override 
    public ComandaCocina crearComandaCocina() { 
        return new ComandaSalon(); 
    } 
}
