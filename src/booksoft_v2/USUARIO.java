/**
 *
 * @author Juddy
 */
package booksoft_v2;

import java.util.Scanner;


public class USUARIO {
    private String nombre;
    private String cedula;
    private final Scanner teclado= new Scanner (System.in);//para entrada por teclado

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public void registrar(){
        System.out.println("Ingrese nombre: ");
        nombre=teclado.nextLine();
        System.out.println("Ingrese cedula: ");
        cedula=teclado.nextLine();
    }
    
    
}
