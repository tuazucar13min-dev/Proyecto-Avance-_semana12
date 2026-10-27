package pe.gourmetsoft.pattern.singleton;

public final class ControlCaja {
    private static final ControlCaja INSTANCIA =new ControlCaja();
    private boolean abierta;
    private String codigoCaja = "SIN-ASIGNAR";
    private String usuarioResponsable="Ninguno";
    
    private ControlCaja() { 
        abierta = false; 
    }
    
    public static ControlCaja getInstancia(){ return INSTANCIA; }
    
    public synchronized void abrir(String codigo,String responsable){
        if(abierta) 
            throw new IllegalStateException("La caja ya se encuentra abierta.");
        if(codigo==null||codigo.isBlank()||responsable == null||responsable.isBlank())
            throw new IllegalArgumentException("El código de caja y el responsable son obligatorios.");
        codigoCaja=codigo.trim(); 
        usuarioResponsable=responsable.trim(); 
        abierta=true;
    }
    
    public synchronized void cerrar(){
        if(!abierta) throw new IllegalStateException("La caja ya está cerrada.");
        abierta=false;
    }
    
    public synchronized boolean isAbierta(){
        return abierta;
    }
    
    public synchronized String getCodigoCaja(){
        return codigoCaja;
    }
    
    public synchronized String getUsuarioResponsable(){
        return usuarioResponsable;
    }
    
    public synchronized String obtenerEstado(){
        return "Caja abierta: "+abierta+", codigo: "+codigoCaja+", responsable: "+usuarioResponsable;
    }
}