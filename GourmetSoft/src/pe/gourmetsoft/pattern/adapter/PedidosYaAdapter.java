/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.adapter;
import pe.gourmetsoft.model.PedidoExterno;

/**
 *
 * @author CIELO
 */

// Adapta el formato de PedidosYa al modelo interno
public class PedidosYaAdapter implements PlataformaDelivery {

    @Override
    public String getNombre() { return "PedidosYa"; }

    @Override
    public PedidoExterno recibirPedido(String payloadJson) {
        System.out.println("[PedidosYaAdapter] Parseando payload PedidosYa: " + payloadJson);
        return new PedidoExterno("PYA-" + System.currentTimeMillis(),
                                 "PEDIDOSYA",
                                 "Cliente PedidosYa",
                                 62.90);
    }

    @Override
    public void enviarEstado(String idExterno, String estado) {
        System.out.println("[PedidosYaAdapter] Notificando a PedidosYa - ID: "
                + idExterno + " Estado: " + estado);
    }
}