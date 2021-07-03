/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

import objeto.AudioLibro;
import objeto.Libro;
import objeto.Publicacion;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class ArchivosObjetos implements IAccesoDatos{
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
 public ArchivosObjetos(String name) {
        this.archivo = new File(name);
    }
 public ArchivosObjetos() {
        this("PublicacionObjetos.obj");
    }
    
 private void guardar(ListaPublicacion lista) throws IOException{
        
        this.oos=null;
        try{
            this.aEscritura = new FileOutputStream(this.archivo, false);
            this.oos = new ObjectOutputStream(this.aEscritura);
            this.oos.writeObject(lista);
        }catch(IOException ioe){
            throw ioe;
        }
        finally{
            if(this.oos!=null)
                this.oos.close();
            
            if(this.aEscritura!=null)
                this.aEscritura.close();
        }
    
    }
    
    private ListaPublicacion leer() throws IOException{
        
        ListaPublicacion lista = null;
        if(this.archivo.exists()){
            
            this.ois=null;
            try{
                this.aLectura = new FileInputStream(this.archivo);
                this.ois= new ObjectInputStream(this.aLectura);
                lista = (ListaPublicacion) this.ois.readObject();
                return lista;
            }catch(IOException ioe){
                throw ioe;
            } catch (ClassNotFoundException ex) {
                throw new IOException("La clase Lista Motocicleta no existe");
            } 
            finally{
                if(this.ois!=null)
                    this.ois.close();
                
                if(this.aLectura!=null)
                    this.aLectura.close();
            }
        }
        else{
            lista = new ListaPublicacion();
            return lista;
        }
        
    }
        
    
    @Override
    public void insertarPublicacion(Publicacion p) throws IOException {
        ListaPublicacion lista = this.leer();
        lista.insertarPublicacion(p);
        this.guardar(lista);
    }

    @Override
    public List<Publicacion> consultarPublicacion() throws IOException {
        ListaPublicacion lista = this.leer();
         return lista.consultarPublicacion();
    }

    @Override
    public Publicacion buscarPublicacion(String Isbn) throws IOException {
        ListaPublicacion lista = this.leer();
         return lista.buscarPublicacion(Isbn);
    }

    @Override
    public int eliminarPublicacion(String Isbn) throws IOException {
        ListaPublicacion lista = this.leer();
         int cont=lista.eliminarPublicacion(Isbn);
         this.guardar(lista);
         return cont;
    }

    @Override
    public List<Publicacion> leerPublicacion() throws IOException {
        ListaPublicacion lista = this.leer();
         return lista.leerPublicacion();
    }

    @Override
    public void eliminarp(String Isbn) throws IOException {
        ListaPublicacion lista = this.leer();
         lista.eliminarp(Isbn);
         this.guardar(lista);
    }

    @Override
    public List<Publicacion> consultarp(String texto) throws IOException {
       ListaPublicacion lista = this.leer();
        return lista.consultarp(texto);
    }
    
}
