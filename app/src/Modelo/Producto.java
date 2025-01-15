package Modelo;

public class Producto {
    // id no esta siendo utilizando cuando tenga mas experiencia voy a mejoarar esto
    private String id;
    private String nombre;
    private int cantidad; 
    private double precio; 
    // creamos 2 constructores uno vacio y uno de inicializacion 
    public Producto(){
    }
    public Producto(String id,String nombre,int cantidad,double precio){
        this.id = id;
        this.nombre = nombre; 
        this.cantidad = cantidad;
        this.precio = precio;
    }
    // creamos los setters 
    public void setId(String id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    // creamos los getters 
    public String getID(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public double getPrecio(){
        return this.precio;
    }
}
