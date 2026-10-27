/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.service.impl;
import pe.gourmetsoft.model.Pedido;
import pe.gourmetsoft.service.PedidoService;
import java.util.HashMap;
import java.util.Map;
//Implementacion del repositorio
import pe.gourmetsoft.dao.RepositorioPedido;
import pe.gourmetsoft.dao.PedidoDao;

/**
 *
 * @author CIELO
 */


public class PedidoServiceImpl implements PedidoService {

    private final Map<String, Pedido> repositorio = new HashMap<>();
    
    private final RepositorioPedido dao = new PedidoDao();
    
    @Override
    public String registrarPedido(String canal, String detalle) {
        String id = "PED-" + System.currentTimeMillis();
        Pedido nuevo = new Pedido(id, canal, detalle);
        repositorio.put(id, nuevo);
        
        // Guarda en el TXT
        dao.guardar(id, detalle);
        
        return "Pedido #" + id + " registrado en canal " + canal;
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        //Guarda en memoria
        repositorio.put(pedido.getId(), pedido);
        
        // Guardar  en el TXT
        dao.guardar(pedido.getId(),
                pedido.getCanal() + "|" +
                pedido.getNombreCliente() + "|" +
                pedido.getDetalle() + "|" +
                pedido.getTotal() + "|" +
                pedido.getEstado());
        return pedido;
    }

    @Override
    public Pedido buscar(String id) {
        return repositorio.get(id);
    }

    @Override
    public Pedido buscar(Long id) {
        return repositorio.get(id);
    }
}

