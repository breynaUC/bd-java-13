
package com.mycompany.mavenproject1;
import com.google.gson.Gson;
import com.mycompany.config.Conexion;
import com.mycompany.dao.ProductoDao;
import com.mycompany.daoImpl.PrductoDaoImpl;

/**
 *
 * @author Docente
 */
public class Mavenproject1 {
static ProductoDao dao = new PrductoDaoImpl();
static Gson gson = new Gson();
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(gson.toJson(dao.readAll()));
    }
    
    static void conexion(){
        if(Conexion.getConnection()!=null){
           System.out.println("SI");
       }else{
           System.out.println("NO");
       }
    }
}
