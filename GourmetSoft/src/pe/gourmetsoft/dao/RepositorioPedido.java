package pe.gourmetsoft.dao;

public interface RepositorioPedido { 
    void guardar(String id,String detalle); 
    String buscarPorId(String id); 
}
