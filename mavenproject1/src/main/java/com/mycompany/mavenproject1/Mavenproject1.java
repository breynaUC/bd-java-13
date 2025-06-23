
package com.mycompany.mavenproject1;
import com.google.gson.Gson;
import com.mycompany.config.Conexion;
import com.mycompany.dao.ProductoDao;
import com.mycompany.daoImpl.PrductoDaoImpl;
import com.mycompany.model.Producto;

/**
 *
 * @author Docente
 */
public class Mavenproject1 {
static ProductoDao dao = new PrductoDaoImpl();
static Gson gson = new Gson();
    public static void main(String[] args) throws ClassNotFoundException {
        eliminar();
    }
    
    static void conexion(){
        if(Conexion.getConnection()!=null){
           System.out.println("SI");
       }else{
           System.out.println("NO");
       }
    }
    static void listar(){
        System.out.println(gson.toJson(dao.readAll()));
    }
    static void buscar(){
        System.out.println(gson.toJson(dao.read(4)));
    }
    static void insertar(){
        System.out.println(gson.toJson(dao.create(new Producto(0,"Teclado",20.20,10))));
    }
    static void eliminar(){
        System.out.println(gson.toJson(dao.delete(1)));
    }
    static void actualizar(){
        System.out.println(gson.toJson(dao.update(new Producto(5,"Teclado 2",50.50,5))));
    }
}
