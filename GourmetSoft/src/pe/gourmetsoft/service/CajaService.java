package pe.gourmetsoft.service;

public interface CajaService {
    void abrirCaja(String codigo,String responsable);
    void cerrarCaja();
    String consultarEstado();
}