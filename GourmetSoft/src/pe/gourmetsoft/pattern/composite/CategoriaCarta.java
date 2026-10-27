/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gourmetsoft.pattern.composite;

import java.util.ArrayList;
import java.util.List;
public class CategoriaCarta implements IComponenteCarta{
    private String nombre;
    private List<IComponenteCarta> elementos = new ArrayList<>();

    public CategoriaCarta(String nombre) { 
        this.nombre = nombre; 
    }
    
    public void agregar(IComponenteCarta c) { 
        elementos.add(c); 
    }
    public void eliminar(IComponenteCarta c) { 
        elementos.remove(c); 
    }

    @Override 
    public double obtenerPrecio() {
        double total = 0.0;
        for (IComponenteCarta e : elementos) total += e.obtenerPrecio();
        return total;
    }

    @Override 
    public void mostrarDetalle(String nivel) {
        System.out.println(nivel + "+ Categoría/Menú: " + nombre);
        for (IComponenteCarta e : elementos) e.mostrarDetalle(nivel + "   ");
    }
}
