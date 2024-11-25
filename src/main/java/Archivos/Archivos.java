/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Archivos {
     public static void serializar ( String sNombreArchivo, Object  obj ) {
        try {
            ObjectOutputStream escritor = new  ObjectOutputStream (new FileOutputStream (sNombreArchivo));
            escritor.writeObject(obj);
            escritor.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object deserializarObject (String sNombreArchivo) {
        Object  obj  = new Object ();
        try{
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(sNombreArchivo)); 
            obj  = (Object)lector.readObject();
        } catch ( FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    
}
