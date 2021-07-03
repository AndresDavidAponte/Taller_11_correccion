/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ppal;

import objeto.*;
import Negocio.GestionPublicacion;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class VentanaRegistro extends JDialog {

    private JLabel lpublicacion, lIsbn, lTitulo, lAutor, lCosto, lAnio, lPaginas, ledicion, lduracion, lpeso,lformato;
    private JTextField tIsbn,tTitulo,tAutor,tformato,tduracion,tpeso,tedicion;
    private JComboBox cPublicacion;
    private ButtonGroup grupoRadio;
    private JButton bGuardar, bCancelar, bNuevo, bBuscar, bEliminar;
    private JSpinner sAnio, sPaginas;
    private JFormattedTextField tfCosto;
    private JPanel panelDatos, panelBotones;
    private Container contenedor;

    private GestionPublicacion negocio;


    VentanaRegistro(JFrame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("Registro de Publicacion - V1");
        this.negocio = new GestionPublicacion();
        this.iniciarComponentes();
        //this.setSize(600, 400);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.panelDatos();
        this.panelBotones();
    }

    private void panelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(12, 2, 5, 5));
        
        
        this.lpublicacion = new JLabel("  Publicacion: ");
        this.lIsbn = new JLabel("  Isbn: ");
        this.lTitulo = new JLabel("  Titulo: ");
        this.lAutor = new JLabel("  Autor: ");
        this.lCosto = new JLabel("  Costo: ");
        this.lAnio = new JLabel("   Años: ");
        this.lPaginas = new JLabel(" Paginas: ");
        this.ledicion = new JLabel(" Edicion: ");
        this.lduracion = new JLabel(" Duracion: ");
        this.lpeso = new JLabel(" Peso: ");
        this.lformato = new JLabel(" Formato: ");
        
        
        this.tIsbn = new JTextField(null);
        this.tIsbn.setEnabled(false);
        this.tformato= new JTextField(null);
        this.tpeso= new JTextField(null);
        this.tAutor = new JTextField(null);
        this.tedicion = new JTextField(null);
        this.tTitulo = new JTextField(null);
        this.tduracion = new JTextField(null);
        
        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(0, 0, 100000, 1);
        this.sAnio = new JSpinner();
        this.sAnio.setModel(modeloSpinner);
        
        SpinnerNumberModel modeloSpinnerr = new SpinnerNumberModel(0, 0, 100000, 1);
        this.sPaginas = new JSpinner();
        this.sPaginas.setModel(modeloSpinnerr);

        NumberFormat formato = NumberFormat.getCurrencyInstance();
        this.tfCosto = new JFormattedTextField(formato);
        
        this.cPublicacion = new JComboBox();
        this.cPublicacion.addItem("Libro");
        this.cPublicacion.addItem("Audiolibro");
        this.cPublicacion.addActionListener(new EventoClickComboMarca());
        
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new EventoClickBotonGuardar());
        this.bGuardar.setEnabled(false);
        this.bCancelar = new JButton("Cancelar");
        this.bCancelar.setEnabled(false);

        this.panelDatos.add(this.lpublicacion);
        this.panelDatos.add(this.cPublicacion);
        
        this.panelDatos.add(this.lIsbn);
        this.panelDatos.add(this.tIsbn);

        this.panelDatos.add(this.lAutor);
        this.panelDatos.add(this.tAutor);

        this.panelDatos.add(this.lAnio);
        this.panelDatos.add(this.sAnio);
        
       

        this.panelDatos.add(this.lTitulo);
        this.panelDatos.add(this.tTitulo);

        this.panelDatos.add(this.lCosto);
        this.panelDatos.add(this.tfCosto);
        
        this.panelDatos.add(this.lPaginas);
        this.panelDatos.add(this.sPaginas);
        
         this.panelDatos.add(this.ledicion);
        this.panelDatos.add(this.tedicion);
        
        this.panelDatos.add(this.lduracion);
        this.panelDatos.add(this.tduracion);
        
        this.panelDatos.add(this.lpeso);
        this.panelDatos.add(this.tpeso);
        
         this.panelDatos.add(this.lformato);
        this.panelDatos.add(this.tformato);

        this.panelDatos.add(this.bGuardar);
        this.panelDatos.add(this.bCancelar);

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
        
        this.lduracion.setVisible(false);
        this.tduracion.setVisible(false);
        this.lpeso.setVisible(false);
        this.tpeso.setVisible(false);
        this.lformato.setVisible(false);
        this.tformato.setVisible(false);
 
    }

    
  
    private void panelBotones() {
      this.panelBotones = new JPanel();

        this.bNuevo = new JButton("Nuevo");
        this.bNuevo.addActionListener(new EventoClickBotonNuevo());
        
        this.bBuscar = new JButton("Buscar");
        this.bBuscar.addActionListener(new EventoClickBotonBuscar());
        this.bBuscar.setEnabled(false);
         
         
        this.bEliminar = new JButton("Eliminar");
        this.bEliminar.addActionListener(new EventoClickBotonEliminar());
        this.bEliminar.setEnabled(false);
     

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(this.bNuevo);
        panel.add(this.bBuscar);
        panel.add(this.bEliminar);

        this.panelBotones.add(panel);

        this.contenedor.add(this.panelBotones, BorderLayout.EAST);
    }
    
    
     public void activarComponentes() {
        this.tIsbn.setEnabled(true);
        this.bGuardar.setEnabled(true);
        this.bCancelar.setEnabled(true);
        this.bBuscar.setEnabled(true);
        this.bEliminar.setEnabled(true);
        this.tIsbn.grabFocus();
    }
     
      public Publicacion leerDatos() {
        String p=this.cPublicacion.getSelectedItem().toString();
        String Isbn = this.tIsbn.getText();
        String titulo = this.tTitulo.getText();
        String autor = this.tAutor.getText();
        int Anio = (int) this.sAnio.getValue();
        
        double costo;
        Object objectCosto = this.tfCosto.getValue();
        if (objectCosto instanceof Long) {
            costo = ((Long) (objectCosto)).doubleValue();
        } else if (objectCosto instanceof Double) {
            costo = (Double) (objectCosto);
        } else {
            costo = 0;
        }
        
        if(p.equals("Libro")){
            
        int Paginas = (int) this.sPaginas.getValue();
        int edicion = Integer.parseInt(this.tedicion.getText());
        Publicacion publicacion = new Libro(Paginas,edicion,Isbn,titulo,autor,Anio,costo);
        return publicacion;
        }else{
           double Duracion=Double.parseDouble(this.tduracion.getText());
           double Peso=Double.parseDouble(this.tpeso.getText());
           String formato= this.tformato.getText();
           Publicacion publicacion2= new AudioLibro(Duracion, Peso, formato, Isbn, titulo, autor, Anio, costo);
           return publicacion2;
        }
       
      }
       
    
     
     public void eliminarPublicacion() {

        String Isbn = this.tIsbn.getText();
        int confirmacion = JOptionPane.showConfirmDialog(this, "Desea eliminar el elemento", "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
        if (confirmacion == 0) {
            try {
               this.negocio.eliminarp(Isbn);
               this.mostrarMsg("Exito", "Elemento eliminado con exito", JOptionPane.INFORMATION_MESSAGE);
               this.limpiarComponentes();
            } catch (IOException | NullPointerException ex) {
                this.mostrarMsg("Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }

    }
     
     public void mostrarPublicacion() {

        try {
            String Isbn = this.tIsbn.getText();
            Publicacion publicacion = this.negocio.buscarPublicacion(Isbn);

            if (publicacion == null) {
                throw new NullPointerException("La Publicacion no se encuentra registrada");
            }

            this.tIsbn.setText(Isbn);
            this.tTitulo.setText(publicacion.getTitulo());
             this.tAutor.setText(publicacion.getAutor());
            this.sAnio.setValue(publicacion.getAnio());
            this.tfCosto.setText("$" + String.valueOf(publicacion.getCosto()));

        } catch (IOException | NullPointerException ex) {
            this.mostrarMsg("Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiarComponentes() {
        this.tIsbn.setText(null);
        this.tTitulo.setText(null);
        this.tAutor.setText(null);
        this.tduracion.setText(null);
        this.tedicion.setText(null);
        this.tformato.setText(null);
        this.cPublicacion.setSelectedIndex(0);
        this.tpeso.setText("0");
        this.sAnio.setValue(0);
        this.tfCosto.setText("$0");
        this.tIsbn.grabFocus();
    }

    public void mostrarMsg(String titulo, String msg, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    public void guardar() {

        try {
            Publicacion publicacion = this.leerDatos();
            this.negocio.insertarPublicacion(publicacion);
            this.mostrarMsg("Exito", "Registro almacenado cone xito", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarComponentes();
        } catch (IOException | NullPointerException ex) {
            //ex.printStackTrace();
            this.mostrarMsg("Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        }

    }

     
     
     public void ocultarComponentes() {
        String Publicacion= this.cPublicacion.getSelectedItem().toString();
        if (Publicacion.equals("Libro")) {
            this.lduracion.setVisible(false);
            this.tduracion.setVisible(false);
            this.lpeso.setVisible(false);
            this.tpeso.setVisible(false);
            this.lformato.setVisible(false);
            this.tformato.setVisible(false);
            
            this.lPaginas.setVisible(true);
            this.sPaginas.setVisible(true);
            this.ledicion.setVisible(true);
            this.tedicion.setVisible(true);
            
        } else {
           this.lPaginas.setVisible(false);
            this.sPaginas.setVisible(false);
            this.ledicion.setVisible(false);
            this.tedicion.setVisible(false);
            
            this.lduracion.setVisible(true);
            this.tduracion.setVisible(true);
            this.lpeso.setVisible(true);
            this.tpeso.setVisible(true);
            this.lformato.setVisible(true);
            this.tformato.setVisible(true);
        }
    }
     
      class EventoClickBotonNuevo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            activarComponentes();
        }
    }

    class EventoClickBotonGuardar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            guardar();
        }
    }

    class EventoClickBotonBuscar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mostrarPublicacion();
        }
    }

    class EventoClickBotonEliminar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            eliminarPublicacion();
        }
    }
      class EventoClickComboMarca implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            ocultarComponentes();
        }
    }
}
