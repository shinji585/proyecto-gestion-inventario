package Utilidad;
import java.util.*;

import Modelo.Producto;
import Servicios.*;
public class Metodos extends Inventario{
    static Scanner s = new Scanner(System.in);
    static HashMap<Integer,ArrayList<Producto>> hashMap = new HashMap<>();
    // metodo para buscar producto por ID 
    public Producto manejarProductoPorId(Integer valor){
        mostrarProducto(); // Suponiendo que este método muestra los productos previamente.
    
        // Pedimos al usuario que ingrese el ID del producto que quiere visualizar
        System.out.print("Ingrese el ID del producto que quiere visualizar: ");
        while (!s.hasNextInt()) {
            System.out.print("El valor tiene que ser entero. Ingrese un valor: ");
            s.next(); // Limpiar el buffer del Scanner
        }
        Integer id = s.nextInt(); // Obtener el ID ingresado
    
        // Verificamos si el ID está en la lista de productos
        if (getManejarProducto().containsKey(id)) {
            // Si el HashMap contiene el ID como clave
            ArrayList<Producto> productos = getManejarProducto().get(id); // Obtener los productos asociados a esa clave
    
            // Mostrar los productos asociados a ese ID
            for (Producto producto : productos) {
                // Retornar el primer producto encontrado
                return producto;
            }
        } else {
            // Si no se encuentra la clave en el HashMap
            System.out.println("No se encontró un producto con el ID " + id);
        }
    
        return null; 
    }
}
