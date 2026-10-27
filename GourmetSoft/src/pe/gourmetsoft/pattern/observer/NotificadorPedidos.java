/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.observer;

/**
 *
 * @author lanza
 */

import java.util.ArrayList;
import java.util.List;
import pe.gourmetsoft.model.Pedido;

public class NotificadorPedidos {

    private final List<ObservadorPedido> observadores =
            new ArrayList<>();

    public void agregarObservador(ObservadorPedido observador) {
        observadores.add(observador);
    }

    public void quitarObservador(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    public void notificar(Pedido pedido, String evento) {

        for (ObservadorPedido observador : observadores) {
            observador.actualizar(pedido, evento);
        }
    }
}