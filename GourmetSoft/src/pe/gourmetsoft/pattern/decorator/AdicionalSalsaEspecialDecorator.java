/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.decorator;

public class AdicionalSalsaEspecialDecorator extends PlatoDecorator{
    public AdicionalSalsaEspecialDecorator(IPlatoBase platoDecorado) {
        super(platoDecorado);
    }

    @Override
    public String getDescripcion() {
        return platoDecorado.getDescripcion() + " + [Adicional: Salsa Especial Gourmet]";
    }

    @Override
    public double getPrecio() {
        return platoDecorado.getPrecio() + 2.00;
    }
}
