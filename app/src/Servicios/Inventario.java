package Servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Modelo.Producto;

public class Inventario extends Producto {
    static Scanner s = new Scanner(System.in);
    Producto producto = new Producto();
    private HashMap<Integer, ArrayList<Producto>> manejarProducto = new HashMap<>();
    static ArrayList<Producto> agregarProducto = new ArrayList<>();

    // Método para agregar productos
    public HashMap<Integer, ArrayList<Producto>> agregarProductos() {
        System.out.print("Ingrese la cantidad de veces que va a subir productos: ");
        while (!s.hasNextInt()) {
            System.out.println("La entrada tiene que ser entera.");
            System.out.print("Ingrese la cantidad de veces que va a subir productos: ");
            s.next();
        }
        int cantidadVeces = s.nextInt();
        while (cantidadVeces < 0) {
            System.out.print("La cantidad de veces que va a subir productos tiene que ser mayor o igual a cero. ");
            System.out.print("Ingrese la cantidad de veces que va a subir productos: ");
            s.next();
        }
        for (int i = 0; i < cantidadVeces; i++) {
            Producto productoPasador = new Producto();
            System.out.print("\nIngrese el nombre del producto: ");
            while (!s.hasNextLine()) {
                System.out.print("La entrada es incorrecta. Debe ser de tipo String. ");
                s.next();
            }
            String pasadorstring = s.nextLine();
            while (pasadorstring.isEmpty()) {
                System.out.print("La entrada no puede estar vacía. Ingrese un valor válido: ");
                pasadorstring = s.nextLine();
            }
            productoPasador.setNombre(pasadorstring);

            System.out.print("Ingrese el precio de su producto: ");
            while (!s.hasNextDouble()) {
                System.out.print("La entrada debe ser de tipo decimal y mayor a cero. ");
                s.next();
            }
            double pasadordouble = s.nextDouble();
            while (pasadordouble < 0) {
                System.out.print("El precio debe ser mayor o igual a cero. ");
                System.out.print("Ingrese el precio de su producto: ");
                pasadordouble = s.nextDouble();
            }
            productoPasador.setPrecio(pasadordouble);

            System.out.print("Ingrese la cantidad de elementos de su producto: ");
            while (!s.hasNextInt()) {
                System.out.print("La entrada debe ser de tipo entero. ");
                s.next();
            }
            int pasadorint = s.nextInt();
            while (pasadorint < 0) {
                System.out.print("La cantidad debe ser mayor o igual a cero. ");
                System.out.print("Ingrese la cantidad de elementos de su producto: ");
                pasadorint = s.nextInt();
            }
            productoPasador.setCantidad(pasadorint);

            // Ahora agregamos la instancia del producto al ArrayList
            agregarProducto.add(productoPasador);
            manejarProducto.put(i, agregarProducto);
        }

        return this.manejarProducto;
    }

    // Método para mostrar productos
    public void mostrarProducto() {
        int valor = 0;
        do {
            System.out.println("\nSeleccione una acción:");
            System.out.println("1 - Para visualizar todos los productos dentro del inventario");
            System.out.println("2 - Para salir");
            System.out.print("Ingrese su respuesta: ");
            while (!s.hasNextInt()) {
                System.out.println("La entrada debe ser un número entero.");
                s.next();
            }
            valor = s.nextInt();
            while (valor < 0 || valor > 2) {
                System.out.println("El valor ingresado no debe ser ni menor a cero ni mayor que dos.");
                System.out.print("Ingrese un valor válido: ");
                valor = s.nextInt();
            }
            switch (valor) {
                case 1 -> {
                    System.out.println("\nProductos en inventario:");
                    for (var entry : manejarProducto.entrySet()) {
                        System.out.println("ID de producto: " + entry.getKey());
                        for (Producto prod : entry.getValue()) {
                            System.out.printf("Nombre: %-20s | Precio: %.2f | Cantidad: %-3d%n", 
                                                prod.getNombre(), prod.getPrecio(), prod.getCantidad());
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Muchas gracias por utilizar esta sección del programa. ¡Continúe utilizándolo!");
                }
            }
        } while (valor != 2);
    }

    // Método para calcular el valor total de todos los productos
    public Integer Valortotal() {
        int valor = 0;
        for (Producto producto : agregarProducto) {
            valor += producto.getPrecio() * producto.getCantidad(); // Calcular el total según la cantidad de productos
        }
        return valor;
    }

    // Getter para manejar los productos
    public HashMap<Integer, ArrayList<Producto>> getManejarProducto() {
        return manejarProducto;
    }
}
