/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.factory;

public class ComandaDelivery implements ComandaCocina {
    @Override 
    public void imprimirComanda() { 
        System.out.println("[DELIVERY] Imprimiendo etiqueta de empaque."); 
    }
}
