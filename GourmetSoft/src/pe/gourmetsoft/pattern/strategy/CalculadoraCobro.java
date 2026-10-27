/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.strategy;

/**
 *
 * @author lanza
 */

public class CalculadoraCobro {

    private EstrategiaCobro estrategia;

    public CalculadoraCobro(EstrategiaCobro estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaCobro estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double subtotal) {
        return estrategia.calcularTotal(subtotal);
    }
}