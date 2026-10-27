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

public interface PlataformaDelivery {
    String getNombre();
    PedidoExterno recibirPedido(String payloadJson);
    void enviarEstado(String idExterno, String estado);
}
