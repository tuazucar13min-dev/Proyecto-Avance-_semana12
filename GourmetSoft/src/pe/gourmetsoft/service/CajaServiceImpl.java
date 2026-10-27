package pe.gourmetsoft.service;

import pe.gourmetsoft.pattern.singleton.ControlCaja;

public class CajaServiceImpl implements CajaService {
    private final ControlCaja controlCaja;
    
    public CajaServiceImpl(ControlCaja controlCaja){
        if(controlCaja==null) throw new IllegalArgumentException("ControlCaja es obligatorio.");
        this.controlCaja=controlCaja;
    }
    
    @Override
    public void abrirCaja(String codigo,String responsable){
        controlCaja.abrir(codigo,responsable);
    }
    
    @Override
    public void cerrarCaja(){
        controlCaja.cerrar();
    }
    
    @Override
    public String consultarEstado(){
        return controlCaja.obtenerEstado();
    }
}