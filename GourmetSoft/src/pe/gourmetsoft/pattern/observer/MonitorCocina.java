/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.observer;

/**
 *
 * @author lanza
 */

import pe.gourmetsoft.model.Pedido;

public class MonitorCocina implements ObservadorPedido {

    @Override
    public void actualizar(Pedido pedido, String evento) {

        System.out.println(
            "[COCINA] " + evento
            + " | Pedido: " + pedido.getId()
            + " | Detalle: " + pedido.getDetalle()
        );
    }
}