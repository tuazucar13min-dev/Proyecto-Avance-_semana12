/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.model;

/**
 *
 * @author CIELO
 */

public class PedidoExterno {
    private String idExterno;
    private String plataforma;
    private String nombreCliente;
    private double monto;

    public PedidoExterno(String idExterno, String plataforma, String nombreCliente, double monto) {
        this.idExterno = idExterno;
        this.plataforma = plataforma;
        this.nombreCliente = nombreCliente;
        this.monto = monto;
    }

    public String getIdExterno() { return idExterno; }
    public String getPlataforma() { return plataforma; }
    public String getNombreCliente() { return nombreCliente; }
    public double getMonto() { return monto; }
}