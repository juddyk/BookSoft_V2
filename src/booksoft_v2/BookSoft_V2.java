/**
 * @author Juddy
 */
package booksoft_v2;

import java.sql.*;
import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class BookSoft_V2 {
    private LIBROS lib;
    private USUARIO usr;
    Scanner t=new Scanner(System.in);
    
    BookSoft_V2(){
        lib=new LIBROS();
        usr=new USUARIO();
    }

    public LIBROS getLib() {
        return lib;
    }

    public void setLib(LIBROS lib) {
        this.lib = lib;
    }

    public USUARIO getUsr() {
        return usr;
    }

    public void setUsr(USUARIO usr) {
        this.usr = usr;
    }
    
    public static void main(String[] args) {
        BookSoft_V2 BS=new BookSoft_V2 ();
        String aux;
        /*
        String user="root";
        String password="xapipi23";
        String url="jdbc:mysql://localhost/libreria_jk";
        */
        // /*
        String user="juddyk";
        String password="xapipi23";
        String url="jdbc:mysql://db4free.net/libreria_jk";
        //*/
     
        Scanner teclado=new Scanner(System.in);
        int n=100;
        try {
            System.out.println("Intentando conectar a la base de datos...");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url, user, password);
            System.out.println("¡¡¡Conexion exitosa!!!\n\n");
            
            Statement state = con.createStatement();
            
            while(n!=0){
                System.out.println("\n ***MENU PRINCIPAL*** \n ");
                System.out.println("Ingrese el numero de la opcion: ");
                System.out.println("Gestionar Informacion         [1] ");
                System.out.println("Gestionar Prestamo/Devolución [2] ");
                System.out.println("Salir [0] ");
                n=teclado.nextInt();
                aux=teclado.nextLine();
                switch(n){
                    case 0:
                        System.out.println("\n***HASTA LUEGO***\n");
                        break;
                    case 1://///////////////////////////////////////////////////////INFORMACION
                        int n1;
                        System.out.println("\n ***GESTIONAR INFORMACION*** \n ");
                        System.out.println("Ingrese el numero de la opcion: ");
                        System.out.println("INGRESAR   [1] ");
                        System.out.println("ACTUALIZAR [2] ");
                        System.out.println("ELIMIAR    [3] ");
                        System.out.println("MIRAR      [4] ");
                        n1=teclado.nextInt();
                        switch(n1){
                            case 1://///////////////////////////////////////////////////////////////////////////////////////INGRESAR
                                String f;
                                f=teclado.nextLine();
                                BS.getLib().almacenar();
                                ResultSet resultado1=state.executeQuery("SELECT * FROM `libreria_jk`.`libros` WHERE `codigo` LIKE '"+BS.getLib().getCodigo()+"'");
                                if(resultado1.next()){
                                    System.out.println("***************YA EXISTE UN LIBRO CON ESE CODIGO, INTENTELO DE NUEVO*************");
                                    break;
                                }
                                else{
                                    state.executeUpdate("INSERT INTO `libreria_jk`.`libros`(`nombre`, `autor`, `fecha`,`codigo`,`cantidad`,`area` ) VALUES ('"+BS.getLib().getNombre()+"', '"+BS.getLib().getAutor()+"', '"+BS.getLib().getFecha()+"' ,'"+BS.getLib().getCodigo()+"' ,'"+BS.getLib().getCantidad()+"' ,'"+BS.getLib().getArea()+"')");
                                    System.out.println("¡¡INGRESO EXITOSO!!");
                                    break;
                                }
                            case 2:///////////////////////////////////////////////////////////////////////////////////////ACTUALIZAR
                                int sel;
                                String f1,ff,nm;
                                f1=teclado.nextLine();
                                System.out.println("codigo del libro: ");
                                nm=teclado.nextLine();
                                ResultSet resultado2=state.executeQuery("SELECT * FROM `libreria_jk`.`libros` WHERE `codigo` LIKE '"+nm+"'");
                                if(resultado2.next()){
                                
                                    System.out.println("**ACTUALIZAR DATOS** ");
                                    System.out.println("Ingrese el numero de la opcion: ");
                                    System.out.println("Nombre             [1] ");
                                    System.out.println("Autor              [2] ");
                                    System.out.println("Año de Publicacion [3] ");
                                    System.out.println("Codigo             [4] ");
                                    System.out.println("Cantidad           [5] ");
                                    System.out.println("Area               [6] ");
                                    System.out.println("Todos los datos    [7] ");
                                    sel=teclado.nextInt();
                                    ff=teclado.nextLine();
                                    switch(sel){
                                        case 1:
                                            String nom;
                                            System.out.println("Nombre:");
                                            nom=teclado.nextLine();
                                            state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `nombre` = '"+nom+"' WHERE `libros`.`codigo` = '"+nm+"'");
                                            System.out.println("¡¡ACTUALIZADO!! ");
                                            break;
                                        case 2:
                                            String at;
                                            System.out.println("Autor:");
                                            at=teclado.nextLine();
                                            state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `autor` = '"+at+"' WHERE `libros`.`codigo` = '"+nm+"'");
                                            System.out.println("¡¡ACTUALIZADO!! ");
                                            break;
                                        case 3:
                                            String fch;
                                            System.out.println("Año de publicacion:");
                                            fch=teclado.nextLine();
                                            state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `fecha` = '"+fch+"' WHERE `libros`.`codigo` = '"+nm+"'");
                                            System.out.println("¡¡ACTUALIZADO!! ");
                                            break;
                                        case 4:
                                            String cd;
                                            System.out.println("Codigo:");
                                            cd=teclado.nextLine();
                                            state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `codigo` = '"+cd+"' WHERE `libros`.`codigo` = '"+nm+"'");
                                            System.out.println("¡¡ACTUALIZADO!! ");
                                            break;
                                        case 5:
                                            int cnt;
                                            String cntt;
                                            System.out.println("Cantidad:");
                                            cnt=teclado.nextInt();
                                            cntt=teclado.nextLine();
                                            state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `cantidad` = '"+cnt+"' WHERE `libros`.`codigo` = '"+nm+"'");
                                            System.out.println("¡¡ACTUALIZADO!! ");
                                            break;
                                        case 6:
                                            String ar;
                                            System.out.println("Area: ");
                                            ar=teclado.nextLine();
                                            state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `area` = '"+ar+"'WHERE `libros`.`codigo` = '"+nm+"'");                                                                                
                                            System.out.println("¡¡ACTUALIZADO!! ");
                                            break;
                                        case 7:
                                            BS.getLib().almacenar();
                                            state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `nombre` = '"+BS.getLib().getNombre()+"', `autor` = '"+BS.getLib().getAutor()+"', `fecha` = '"+BS.getLib().getFecha()+"', `codigo` = '"+BS.getLib().getCodigo()+"', `cantidad` = '"+BS.getLib().getCantidad()+"', `area` = '"+BS.getLib().getArea()+"' WHERE `libros`.`codigo` = '"+nm+"'");
                                            System.out.println("¡¡ACTUALIZADO!! ");                    
                                            break;
                                        default:
                                            System.out.println("**COMANDO INCORRECTO**");
                                            break;
                                    }
                                }
                                else{
                                    System.out.println("******************CODIGO NO EXISTENTE***********************");
                                }
                                break;
                            case 3:////////////////////////////////////////////////////////////////////////////////////////////ELIMINAR
                                String f2,cdg2;
                                f2=teclado.nextLine();
                                System.out.println("Ingrese el codigo del libro: ");
                                cdg2=teclado.nextLine();
                                ResultSet resultado3=state.executeQuery("SELECT * FROM `libreria_jk`.`libros` WHERE `codigo` LIKE '"+cdg2+"'");
                                if(resultado3.next()){
                                    state.executeUpdate(" DELETE FROM `libreria_jk`.`libros`  WHERE `codigo` LIKE '"+cdg2+"'");
                                    System.out.println("¡¡ELIMINACION EXITOSA!!");
                                }
                                else{
                                    System.out.println("******************CODIGO NO EXISTENTE***********************");
                                }
                                break;
                            case 4:///////////////////////////////////////////////////////////////////////////////////////////VER
                                int count=0,n123;
                                String f3, cdg;
                                f3=teclado.nextLine();
                                System.out.println("Mostrar todos los libros        [0]");
                                System.out.println("Mostrar un libro                [1]");
                                n123=teclado.nextInt();
                                f3=teclado.nextLine();
                                switch(n123){
                                    case 0:
                                        ResultSet reeslt=state.executeQuery("SELECT * FROM `libreria_jk`.`libros`");
                                        while(reeslt.next()){
                                            System.out.println("Nombre: "+reeslt.getString("nombre")+"\nAutor: "+reeslt.getString("autor")+"\nAño de publicacion: "+reeslt.getString("fecha")+"\nCodigo: "+reeslt.getString("codigo")+"\nCantidad: "+reeslt.getString("cantidad")+"\nArea: "+reeslt.getString("area")+"\n");
                                        }
                                        break;
                                    case 1:
                                        System.out.println("Ingrese el codigo del libro: ");
                                        cdg=teclado.nextLine();
                                        ResultSet resultado4=state.executeQuery("SELECT * FROM `libreria_jk`.`libros` WHERE `codigo` LIKE '"+cdg+"'");
                                        if(resultado4.next()){
                                            System.out.println("Nombre: "+resultado4.getString("nombre")+"\nAutor: "+resultado4.getString("autor")+"\nAño de publicacion: "+resultado4.getString("fecha")+"\nCodigo: "+resultado4.getString("codigo")+"\nCantidad: "+resultado4.getString("cantidad")+"\nArea: "+resultado4.getString("area"));        
                                        }
                                        else{
                                            System.out.println("******************CODIGO NO EXISTENTE***********************");
                                        }
                                        break;
                                    default:
                                        System.out.println("*****************COMANDO INCORRECTO**********************");
                                        break;
                                } 
                                break;                        
                            default:
                                System.out.println("***COMANDO INCORRECTO***");
                                break;
                        }
                        
                        break;
                    case 2:///////////////////////////////////////////////////////////////////////PRESTAMOS & DEVOLUCIONES
                        int s;
                        String aux2;
                        System.out.println("\n ***GESTIONAR*** \n ");
                        System.out.println("Registro   [0]");
                        System.out.println("Prestamo   [1]");
                        System.out.println("Devolucion [2] ");
                        s=teclado.nextInt();
                        aux2=teclado.nextLine();
                        switch(s){
                            case 0://///////////////////////////////////////////////////////////////////////REGISTRO
                                BS.getUsr().registrar(); 
                                ResultSet resul=state.executeQuery("SELECT * FROM `libreria_jk`.`usuario` WHERE `cedula` LIKE '"+BS.getUsr().getCedula()+"'");
                                if(resul.next()){
                                    System.out.println("*** "+BS.getUsr().getNombre()+" YA SE ENCUENTRA EN EL SISTEMA****");
                                }
                                else{
                                    state.executeUpdate("INSERT INTO `libreria_jk`.`usuario`(`nombre`, `cedula` ) VALUES ('"+BS.getUsr().getNombre()+"', '"+BS.getUsr().getCedula()+"')");
                                    System.out.println("¡¡¡¡REGISTRO EXITOSO!!!!");
                                }
                                break;
                            case 1://////////////////////////////////////////////////////////////////////PRESTAMO
                                int count=0,value;
                                String ced,nomb,cod;
                                System.out.println("Ingrese su cedula: ");
                                ced=teclado.nextLine();
                                ResultSet resultado11=state.executeQuery("SELECT * FROM `libreria_jk`.`usuario` WHERE `cedula` LIKE '"+ced+"'");
                                if(resultado11.next()){
                                    System.out.println("Ingrese el nombre del libro: ");
                                    nomb=teclado.nextLine();
                                    ResultSet result=state.executeQuery("SELECT * FROM `libreria_jk`.`libros` WHERE `nombre` LIKE '"+nomb+"'");
                                    while(result.next()){
                                        System.out.println("Nombre: "+result.getString("nombre")+"\nAutor: "+result.getString("autor")+"\nCodigo: "+result.getString("codigo")+"\n");
                                        count++;
                                    }
                                    if(count!=0){
                                        System.out.println("Ingrese el codigo del libro que desea prestar ");
                                        cod=teclado.nextLine();
                                        ResultSet result1=state.executeQuery("SELECT * FROM `libreria_jk`.`libros` WHERE `codigo` LIKE '"+cod+"'");
                                        if(result1.next()){
                                            if(result1.getInt("cantidad")!=0){
                                                value=(result1.getInt("cantidad"))-1;
                                                state.executeUpdate("INSERT INTO `libreria_jk`.`prestamo`(`nombre`,`codigo`, `cedula` ) VALUES ('"+result1.getString("nombre")+"','"+result1.getString("codigo")+"', '"+ced+"')");
                                                if(true){
                                                    state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `cantidad` = '"+value+"' WHERE `libros`.`codigo` = '"+cod+"'");
                                                    System.out.println("¡¡¡¡¡PRESTAMO EXITOSO!!!!!");
                                                }
                                            }
                                            else{
                                                System.out.println("**********************NO ESTA DISPONIBLE*****************************");
                                            }
                                        }
                                        else{
                                            System.out.println("************CODIGO EQUIVOCADO***************");
                                        }
                                        
                                    }
                                    else{
                                        System.out.println("*****NO EXISTE ESE LIBRO******");
                                    }
                                    
                                }
                                else{
                                    System.out.println("***************NO SE ENCUENTRA REGISTRADO**************");
                                }
                                break;    
                            case 2:///////////////////////////////////////////////////////////////////////////////////////DEVOLUCION
                                String cedu, coodg,cc;
                                int cntt=0,vl,nnn=0,auxx=0;
                                System.out.println("Ingrese su cedula: ");
                                cedu=teclado.nextLine();
                                ResultSet resuult=state.executeQuery("SELECT * FROM `libreria_jk`.`prestamo` WHERE `cedula` LIKE '"+cedu+"'");
                                while(resuult.next()){                                    
                                    System.out.println("Nombre: "+resuult.getString("nombre")+"\nCodigo: "+resuult.getString("codigo")+"\n");
                                    cntt++;
                                }
                                if(cntt!=0){
                                        System.out.println("Ingrese el codigo del libro:");
                                        coodg=teclado.nextLine();
                                        ResultSet ressult=state.executeQuery("SELECT * FROM `libreria_jk`.`libros` WHERE `codigo` LIKE '"+coodg+"'");
                                        if(ressult.next()){
                                            vl=ressult.getInt("cantidad")+1;
                                            state.executeUpdate("UPDATE `libreria_jk`.`libros` SET `cantidad` = '"+vl+"' WHERE `libros`.`codigo` = '"+coodg+"'");
                                            if(true){
                                                state.executeUpdate(" DELETE FROM `libreria_jk`.`prestamo`  WHERE `codigo` LIKE '"+coodg+"'");
                                            }
                                            System.out.println("¡¡DEVOLUCION EXITOSA!!");
                                        }
                                        else{
                                            System.out.println("****CODIGO EQUIVOCADO*****");
                                        }  
                                }
                                else{
                                    System.out.println("*******NO TIENE LIBROS PRESTADOS********");
                                }
                                break;
                            default:
                                System.out.println("***COMANDO INCORRECTO*** ");
                                break;
                        }
                        break;
                    default:
                        System.out.println("***COMANDO INCORRECTO***");
                        break;
                } 
            }
            
        } 
        catch (SQLException ex) {
            System.out.println("** ERROR EN MySql **");
        }
        catch (Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        }
    }
}
