
package pe.gourmetsoft.model;

public class Pedido {
    private final String id;
    private final String canal;
    private final String detalle;

    private String estado;         // "RECIBIDO", "EN_COCINA", "DESPACHADO"
    private double total;
    private String nombreCliente;

    public Pedido(String id, String canal, String detalle) {
        this.id = id;
        this.canal = canal;
        this.detalle = detalle;
        this.estado = "RECIBIDO";
        this.total = 0.0;
        this.nombreCliente = "Sin identificar";
    }

    public Pedido(String id, String canal, String detalle, 
                  String estado, double total, String nombreCliente) {
        this.id = id;
        this.canal = canal;
        this.detalle = detalle;
        this.estado = estado;
        this.total = total;
        this.nombreCliente = nombreCliente;
    }

    public String getId() { return id; }
    public String getCanal() { return canal; }
    public String getDetalle() { return detalle; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", canal=" + canal + ", cliente=" + nombreCliente 
                + ", total=" + total + ", estado=" + estado + "}";
    }
}