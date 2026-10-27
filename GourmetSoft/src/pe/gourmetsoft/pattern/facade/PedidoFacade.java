package pe.gourmetsoft.pattern.facade;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import pe.gourmetsoft.model.Pedido;
import pe.gourmetsoft.model.PedidoExterno;
import pe.gourmetsoft.pattern.adapter.PlataformaDelivery;
import pe.gourmetsoft.service.CajaService;
import pe.gourmetsoft.service.PedidoService;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CIELO
 */


public class PedidoFacade {

    private final CajaService cajaService;
    private final PedidoService pedidoService;
    private final Map<String, PlataformaDelivery> plataformas;

    public PedidoFacade(CajaService cajaService, PedidoService pedidoService) {
        this.cajaService = cajaService;
        this.pedidoService = pedidoService;
        this.plataformas = new HashMap<>();
    }

    public void registrarPlataforma(PlataformaDelivery plataforma) {
        plataformas.put(plataforma.getNombre().toUpperCase(), plataforma);
    }

    public Pedido registrarPedidoSalon(String cliente, String detalle, double total) {
        if (!cajaService.consultarEstado().contains("abierta: true")) {
            throw new IllegalStateException("Debe abrir la caja antes de registrar pedidos.");
        }
        String id = "SAL-" + System.currentTimeMillis();
        Pedido pedido = new Pedido(id, "SALON", detalle, "RECIBIDO", total, cliente);
        return pedidoService.guardar(pedido);
    }

    public Pedido recibirPedidoExterno(String nombrePlataforma, String payloadJson) {
        PlataformaDelivery adapter = plataformas.get(nombrePlataforma.toUpperCase());
        if (adapter == null) {
            throw new IllegalArgumentException("Plataforma no registrada: " + nombrePlataforma);
        }
        PedidoExterno externo = adapter.recibirPedido(payloadJson);

        String id = "DEL-" + System.currentTimeMillis();
        String detalle = "Pedido externo de " + externo.getPlataforma();
        Pedido pedidoInterno = new Pedido(id,
                "DELIVERY_" + externo.getPlataforma(),
                detalle,
                "RECIBIDO",
                externo.getMonto(),
                externo.getNombreCliente());

        Pedido guardado = pedidoService.guardar(pedidoInterno);
        adapter.enviarEstado(externo.getIdExterno(), "ACEPTADO");
        return guardado;
    }

    public Pedido consultarPedido(String id) {
        return pedidoService.buscar(id);
    }
}