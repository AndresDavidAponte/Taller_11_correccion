package Ppal;
import objeto.AudioLibro;
import objeto.Libro;
import objeto.Publicacion;
import Informacion.Archivos.*;
import Informacion.ArchivosObjetos;
import Informacion.IAccesoDatos;
import Informacion.ListaPublicacion;
import java.io.IOException;
import java.util.List;

public class Ppal {
    public static void main(String[] args) {
         VentanaPrincipal principal = new VentanaPrincipal();
        
    }
        //Publicacion pA = new Libro(12, 3 , "341", "Despacito", "Dady yankee", 2018, 10000);
       // Publicacion pB = new AudioLibro(90, 65, "mp3", "456", "Cien años de soledad", "Gabriel", 2000, 20000);
        //Publicacion pC = new Libro(34, 7, "890", "inolvidables", "Juan francisco", 2018, 30000);
        
        //IAccesoDatos datos = new ListaPublicacion();
        

        //try {
         
           //datos.insertarPublicacion(pA);
            //datos.insertarPublicacion(pB);
            //datos.insertarPublicacion(pC);
            
            //System.out.println("Todas las Publicaciones Registradas");
           // System.out.println("----------------------------------------");
            //List<Publicacion>listas=datos.leerPublicacion();
            //imprimirLista(listas);
            
            //System.out.println("\nBusqueda Publicaciones Por Isbn");
            //System.out.println("-----------------------------------");
            //String Isbn="456";
            //Publicacion p = datos.buscarPublicacion(Isbn);
           // if(p!=null){
          //      System.out.println("Publicaciones encontrada: ");
          //      System.out.println(p);
          //  }
          //  else{
          //      System.out.println("La Publicacion con isbn "+p+" no se encuentra registrada");
          //  }
            
          //  System.out.println("\n Eliminar Publicacion por Isbn");
          //  System.out.println("---------------------------------------");
          //  Isbn ="890";
          //  int eliminados = datos.eliminarPublicacion(Isbn);
          //  System.out.println(eliminados + " registros eliminados");
            
          //  System.out.println("\nTodas las Publicacion Registradas");
          //  System.out.println("----------------------------------------");
          //  listas =datos.leerPublicacion();
          //  imprimirLista (listas);

        //} catch(IOException ioe) {
          //  ioe.printStackTrace(System.out);
        //}
   // }

    public static void imprimirLista(List<Publicacion> lista) {
        for (Publicacion p : lista) {
            System.out.println(p);
        }
        System.out.println("Total registradas: " + lista.size());
    }
}//
