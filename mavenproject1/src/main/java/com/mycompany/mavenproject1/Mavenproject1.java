
package com.mycompany.mavenproject1;
import com.mycompany.config.Conexion;

/**
 *
 * @author Docente
 */
public class Mavenproject1 {

    public static void main(String[] args) throws ClassNotFoundException {
       if(Conexion.getConnection()!=null){
           System.out.println("SI");
       }else{
           System.out.println("NO");
       }
    }
}
