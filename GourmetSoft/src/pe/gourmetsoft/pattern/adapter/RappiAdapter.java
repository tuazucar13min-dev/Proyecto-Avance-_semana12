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

// Adapta el formato de Rappi al modelo interno de GourmetSoft
public class RappiAdapter implements PlataformaDelivery {

    @Override
    public String getNombre() { return "Rappi"; }

    @Override
    public PedidoExterno recibirPedido(String payloadJson) {
        System.out.println("[RappiAdapter] Parseando payload Rappi: " + payloadJson);
        return new PedidoExterno("RAPP-" + System.currentTimeMillis(),
                                 "RAPPI",
                                 "Cliente Rappi",
                                 85.50);
    }

    @Override
    public void enviarEstado(String idExterno, String estado) {
        System.out.println("[RappiAdapter] Notificando a Rappi - ID: "
                + idExterno + " Estado: " + estado);
    }
}
