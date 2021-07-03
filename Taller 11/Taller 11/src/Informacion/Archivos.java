/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

import objeto.Publicacion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fabian
 */
public class Archivos {
    
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

      public Archivos(String name) {
        this.archivo = new File(name);
    }

    public Archivos() {
        this("VentaLibros.dat");
        
    }
    
    
        public void abrirArchivo()throws IOException{
        
        this.oos = null;
        this.aEscritura = new FileOutputStream(this.archivo, true);
        this.oos = new ObjectOutputStream(this.aEscritura);
         
    }
    
    public void cerrarArchivo()throws IOException{
       if(this.oos!=null)   
           this.oos.close();
       
       if(this.aEscritura!=null)
           this.aEscritura.close();
    }
    public void guardar(Publicacion librPublicacion) throws IOException{
        
            this.oos.writeObject(librPublicacion);
        
    }

   List<Publicacion> consultarPublicacion()throws IOException{
        
        this.ois=null;
        List<Publicacion> lista = new ArrayList();
        
        try{
            this.aLectura= new FileInputStream(this.archivo);
            this.ois = new ObjectInputStream(this.aLectura);
            while(true){
                try{
                    Publicacion moto = (Publicacion)this.ois.readObject();
                    lista.add(moto);
                }catch(EOFException eoe){
                    break;
                }    
            }
            return lista;
        }
        catch(FileNotFoundException fne){
            throw new IOException("El archivo no existe");
            
        } catch (ClassNotFoundException ex) {
            throw new IOException("La clase Motocicleta no existe");
        }
        finally{
            if(this.ois!=null)
                this.ois.close();
            
            if(this.aLectura!=null)
                this.aLectura.close();
        }
        
    }
    
    
}