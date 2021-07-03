/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Informacion.*;
import java.io.IOException;
import java.util.List;
import objeto.*;

/**
 *
 * @author Fabian
 */
public class GestionPublicacion {
    
    private IAccesoDatos datos;

    public GestionPublicacion(){
        
        this.datos = new ArchivosObjetos();
        //this.datos = new ArchivoTexto();
        //this.datos = new ListaMotocicleta();
    }
    public void insertarPublicacion(Publicacion publicacion) throws IOException {
        
        if(publicacion==null)
            throw new NullPointerException("Debe registrar una publicacion");
        
        if(publicacion.getIsbn()==null || publicacion.getIsbn().isEmpty())
            throw new NullPointerException("Debe registrar la Placa de la Motocicleta");
        
        if(publicacion.getAutor()==null || publicacion.getAutor().isEmpty())
            throw new NullPointerException("Debe registrar la marca de la motocicleta");
        
        if(publicacion.getCosto()<0)
            throw new NullPointerException("Debe registrar un valor valido para los KMS de la motocicleta");
        
        if(publicacion.getAnio()<=0)
            throw new NullPointerException("Debe registrar un Valor valido de la motocicleta");
        
        if(this.buscarPublicacion(publicacion.getIsbn())!=null)
            throw new NullPointerException("La motocicleta ya se encuentra Registrada");
        
        this.datos.insertarPublicacion(publicacion);
    }

    public List<Publicacion> leerPublicacion() throws IOException {
        return this.datos.leerPublicacion();
    }

    public Publicacion buscarPublicacion(String isbn) throws IOException {
        if(isbn==null || isbn.isEmpty())
            throw new NullPointerException("Se reqiere un valor valido para la Placa");
        
        return this.datos.buscarPublicacion(isbn);
    }

    public List<Publicacion> consultarMotocicleta() throws IOException {
        return this.datos.consultarPublicacion();
    }

    public int eliminarMotocicletas(String Isbn) throws IOException {
        return this.datos.eliminarPublicacion(Isbn);
    }

    public void eliminarPublicacion(String Isbn) throws IOException {
        if(Isbn==null || Isbn.isEmpty())
            throw new NullPointerException("Se reqiere un valor valido para la Placa");
        
        this.datos.eliminarPublicacion(Isbn);
    }
    
    public List<Publicacion> consultarPublicacion () throws IOException{
        return this.datos.consultarPublicacion();
    }
    
    public void eliminarp(String Isbn) throws IOException {
        if(Isbn==null || Isbn.isEmpty())
            throw new NullPointerException("Se reqiere un valor valido para la Placa");
        
        this.datos.eliminarp(Isbn);
    }
    
    public List<Publicacion> consultarp(String texto) throws IOException {
        return this.datos.consultarp(texto);
    }
}
