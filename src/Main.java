import Modelo.Conexion;
import Modelo.Perro;
import Modelo.Perro_db;


import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

       /* Scanner x =new Scanner(System.in);
        int division=0;
       try{
           int num1=x.nextInt();
           int num2=x.nextInt();
           division= num1/num2;
           System.out.println(division);
        }catch (ArithmeticException e){
           System.out.println("El divisor no puede 0");
           division=0;
        }catch (InputMismatchException e){
           System.out.println("Los datos deben ser numeros enteros, para hacer la division");
           division=0;
       }

        System.out.println(division);*/
        /*Conexion prueba=new Conexion();
        prueba.conecta();*/

        //Perro p=new Perro("Prueba","Macho","prueba2",12.5f,3,"300");
        Perro_db p_db=new Perro_db();
        //p_db.insertarPerro(p);

        //System.out.println(p_db.buscarPerro("Juno334","Dalmatian","1900"));
        System.out.println(p_db.consultarTodos());
        //System.out.println(p_db.buscarCodigo(12));
        Perro p=new Perro(30,"Osito","Hembra","prueba2",10.5f,1,"1400");
        p_db.actualizarPerro(p);
        System.out.println(p_db.consultarTodos());
    }}