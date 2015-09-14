/**
 *
 * @author Juddy
 */
package booksoft_v2;

import java.util.Scanner;


public class LIBROS {
    private String nombre;
    private String autor;
    private String fecha;
    private String codigo;
    private int cantidad;
    private String area;
    private int ediciones;
    private int cantPres;
    
    private final Scanner teclado= new Scanner (System.in);//para entrada por teclado

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(int ediciones) {
        this.ediciones = ediciones;
    }

    public int getCantPres() {
        return cantPres;
    }

    public void setCantPres(int cantPres) {
        this.cantPres = cantPres;
    }

    public void almacenar(){
        String aux;
        System.out.println("Nombre: ");
        nombre=teclado.nextLine();
        System.out.println("Autor: ");
        autor=teclado.nextLine();
        System.out.println("Año de publicación: ");
        fecha=teclado.nextLine();
        System.out.println("Codigo: ");
        codigo=teclado.nextLine();
        System.out.println("Cantidad: ");
        cantidad=teclado.nextInt();
        aux=teclado.nextLine();
        System.out.println("Area: ");
        System.out.print("Quimica, ");
        System.out.print("Fisica, ");
        System.out.print("Tecnologia, ");
        System.out.print("Calculo, ");
        System.out.println("Programacion");
        area=teclado.nextLine();
    }
}
