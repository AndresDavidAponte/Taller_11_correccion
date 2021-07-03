package Informacion;

import objeto.Publicacion;
import java.io.IOException;
import java.util.List;

public interface IAccesoDatos {
    
    void insertarPublicacion(Publicacion p) throws IOException;
     List<Publicacion> consultarPublicacion()throws IOException;
     List<Publicacion> leerPublicacion()throws IOException;
    Publicacion buscarPublicacion(String Isbn)throws IOException;
    public int eliminarPublicacion(String Isbn) throws IOException;
    void eliminarp(String placa) throws IOException;
    List<Publicacion> consultarp(String texto) throws IOException;
 
}
