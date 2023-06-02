package examenColecciones_JorgeTapia.Comparador;

import java.util.Comparator;

import examenColecciones_JorgeTapia.Tienda.Producto;

public class OrdenaPorNombre implements Comparator<Producto>
{
    @Override
    public int compare(Producto arg0, Producto arg1) {
        return arg0.getNombreProducto().compareTo(arg1.getNombreProducto());
    }
}
