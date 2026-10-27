/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.factory;

public interface PedidoAbstractFactory {
    Comprobante crearComprobante();
    ComandaCocina crearComandaCocina();
}
