/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.dao;

/**
 *
 * @author lanza
 */
import java.io.*;

public class PedidoDao implements RepositorioPedido {

    private final String archivo = "pedidos.txt";

    @Override
    public void guardar(String id, String detalle) {

        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(id + "|" + detalle);
            bw.newLine();

            System.out.println("Pedido guardado en TXT.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @Override
    public String buscarPorId(String id) {

        try (BufferedReader br =
                 new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split("\\|", 2);

                if (datos.length == 2 && datos[0].equals(id)) {
                    return datos[1];
                }
            }

        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }

        return null;
    }
}