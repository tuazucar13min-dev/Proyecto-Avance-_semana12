/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.strategy;

/**
 *
 * @author lanza
 */

public class PagoTarjeta implements EstrategiaCobro {

    @Override
    public double calcularTotal(double subtotal) {
        return subtotal;
    }
}