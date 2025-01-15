package main;

import Modelo.Producto;
import Servicios.Inventario;
import Utilidad.Metodos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Instancia del Inventario
        Inventario inventario = new Inventario();
        
        // Instancia de los métodos que gestionan el inventario
        Metodos metodos = new Metodos();

        // Agregar productos
        inventario.agregarProductos();

        // Mostrar productos
        inventario.mostrarProducto();

        // Buscar un producto por ID
        System.out.println("¿Desea salir defenitivamente o buscar algun producto por ID?\nIngrese un valor: ");
        while (!s.hasNextBoolean()) {
            System.out.println("la entrada tiene que ser booleana\nIngrese un valor: ");
            s.nextLine();
        }
        boolean valor = s.nextBoolean();
        if (valor == true){
            Producto productoEncontrado = metodos.manejarProductoPorId(0);  // Llama al método para manejar productos por ID
            if (productoEncontrado != null) {
                System.out.println("Producto encontrado: " + productoEncontrado.getNombre() + " con precio: " + productoEncontrado.getPrecio());
            }
    
            // Calcular el valor total
            System.out.println("El valor total del inventario es: " + inventario.Valortotal());
        }else{
            System.out.println("el programa a finalizado muchas gracias por utilizarlo....");
        }
        
        
        
        s.close();
    }

}
