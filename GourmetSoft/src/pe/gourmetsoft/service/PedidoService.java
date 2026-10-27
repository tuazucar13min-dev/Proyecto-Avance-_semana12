package pe.gourmetsoft.service;
import pe.gourmetsoft.model.Pedido;

public interface PedidoService { 
    String registrarPedido(String canal,String detalle); 
    Pedido guardar(Pedido pedido);
    Pedido buscar(Long id);

    public Pedido buscar(String id);
}


