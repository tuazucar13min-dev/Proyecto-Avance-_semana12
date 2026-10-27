/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.factory;

public class ComprobanteDelivery implements Comprobante{
    @Override 
    public void emitirComprobante() { 
        System.out.println("[DELIVERY] Emitiendo Comprobante Electrónico con envío."); 
    }
}

