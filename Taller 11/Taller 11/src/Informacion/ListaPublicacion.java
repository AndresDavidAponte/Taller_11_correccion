/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

import Informacion.IAccesoDatos;
import objeto.Publicacion;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class ListaPublicacion implements IAccesoDatos, Serializable {

     private List<Publicacion> lista;

    public ListaPublicacion() {
        this.lista = new ArrayList();
    }


    @Override
    public void insertarPublicacion(Publicacion p) throws IOException {
        this.lista.add(p);
    }

    @Override
    public List<Publicacion> consultarPublicacion() throws IOException {
         List<Publicacion> consulta= new ArrayList();
        for(Publicacion publicacion: this.lista){
            if(publicacion.getIsbn().equals(publicacion)){
             } else {
                consulta.add(publicacion);
             }
        }
         return null;
    }

    @Override
    public List<Publicacion> leerPublicacion() throws IOException {
        return this.lista;
        
    }

    @Override
    public Publicacion buscarPublicacion(String Isbn) throws IOException {
         List<Publicacion> consulta= new ArrayList();
        for(Publicacion p: this.lista){
            if(p.getIsbn().equals(Isbn)){
                return p;
            }
        }
        return null;
  
    }

    @Override
    public int eliminarPublicacion(String Isbn) throws IOException {
        Iterator<Publicacion> i = this.lista.iterator();
        int contador=0;
        while(i.hasNext()){
            Publicacion p = (Publicacion)i.next();
            if(p.getIsbn().equals(Isbn)){
                i.remove();
                contador ++;
            }
        }
        return contador;
    }

    @Override
    public void eliminarp(String Isbn) throws IOException {
          Iterator<Publicacion> i = this.lista.iterator();
        int contador=0;
        while(i.hasNext()){
            Publicacion publicacion = (Publicacion)i.next();
            if(publicacion.getIsbn().equalsIgnoreCase(Isbn)){
                i.remove();
            }
        }
    }

    @Override
    public List<Publicacion> consultarp(String texto) throws IOException {
         List<Publicacion> consulta= new ArrayList();
        for(Publicacion publicacion: this.lista){
            if(publicacion.getIsbn().toUpperCase().contains(texto.toUpperCase()) || publicacion.getTitulo().toUpperCase().contains(texto.toUpperCase())){
                consulta.add(publicacion);
            }
        }
        return consulta;
    }
  }
    

