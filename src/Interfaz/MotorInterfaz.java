
package Interfaz;

import braintoplace.*;
import braintoplace.ColaQuejasSugerencias.NodoQueja;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public final class MotorInterfaz {
    ListaEnlazadaTareas listaTareas = new ListaEnlazadaTareas();
    Historial historial=new Historial();
    ColaQuejasSugerencias QuejaSug=new ColaQuejasSugerencias();
    List<QuejaSugerencia> listaQuejas;

    Eventos evt=new Eventos(this);

    public Image iconoCerebro;
    public Image iconoAgregar;
    public Image iconoQuitar;
    public Image iconoCompletar;
    public Image iconoModificar;
    public Image iconoHistorial;
    public Image iconoPendientes;
    public Image iconoQuejas;

    public JFrame ventana=new JFrame();
    public JPanel primerPanel=new JPanel();
    public JPanel panelAuxiliar=new JPanel();
    public JLabel Título=new JLabel("Brain To Place");
    public JLabel iconoTitulo=new JLabel();
    public JButton agregarTarea=new JButton();
    public JButton completarTarea=new JButton();
    public JButton modificarTarea=new JButton();
    public JButton tareasPendientes=new JButton();
    public JButton tareasHistorial=new JButton();
    public JButton quejasSugerencias=new JButton();
    public JButton eliminarTarea=new JButton();


    public JTextField tituloTarea=new JTextField();
    public JTextArea descripcionTarea=new JTextArea();
    public JComboBox Dia=new JComboBox();
    public JComboBox Mes=new JComboBox();
    public JComboBox Año=new JComboBox();
    public JComboBox Prioridad=new JComboBox();
    public JButton agregar=new JButton("Agrega tu tarea");
    public JButton prueba=new JButton();


    public JScrollPane panelTareas= new JScrollPane(new JPanel(new GridLayout(0, 1)));
    public ButtonGroup bg = new ButtonGroup();
    public JButton eliminar=new JButton("Elimina la tarea seleccionada");

    public JButton completar=new JButton("Completa tu tarea");


    public JButton ElegirModificar=new JButton("Modifica tu tarea");
    public JButton modificar=new JButton("Modifica tu tarea");

    public JButton verDetalles=new JButton("Mira los detalles de tu tarea");

    public JButton verDetallesHist=new JButton("Mira los detalles de tu tarea");
    public JButton BorrarHist=new JButton("Borrar historial");

    public JButton AñadirQueja=new JButton("Añadir");
    public JButton verDetallesQueja=new JButton("Detalles");
    public JButton resolverQueja=new JButton("Resolver 1ra queja");


    public JFrame ventanaQueja=new JFrame();
    public JPanel panelQueja=new JPanel();
    public JTextField usuarioQueja=new JTextField();
    public JTextArea descripcionQueja=new JTextArea();
    public JButton agregarQueja=new JButton("Agrega tu queja");


    public MotorInterfaz(){
        CreacionIconos();
        CreacionVentana();
        CambiarPantalla(1);
    }

    public void CreacionIconos(){
        iconoCerebro=new ImageIcon(getClass().getResource("/iconos/brain.png")).getImage();
        iconoCompletar=new ImageIcon(getClass().getResource("/iconos/checked.png")).getImage();
        iconoAgregar=new ImageIcon(getClass().getResource("/iconos/plus.png")).getImage();
        iconoQuitar=new ImageIcon(getClass().getResource("/iconos/cancel.png")).getImage();
        iconoModificar=new ImageIcon(getClass().getResource("/iconos/writing (1).png")).getImage();
        iconoHistorial=new ImageIcon(getClass().getResource("/iconos/history.png")).getImage();
        iconoPendientes=new ImageIcon(getClass().getResource("/iconos/danger.png")).getImage();
        iconoQuejas=new ImageIcon(getClass().getResource("/iconos/speech-bubble.png")).getImage();
    }

    public void CambiarPantalla(int n){
        primerPanel.removeAll();
        ventana.repaint();
        switch (n){
            case 1 -> PrimeraPantalla();
            case 2 -> {
                ReiniciarIngTarea();
                PantallaAgregar();
            }
            case 3 -> PantallaCancelar();
            case 4 -> PantallaCompletar();
            case 5 -> PantallaModificar();
            case 6 -> PantallaPendientes();
            case 7 -> PantallaHistorial();
            case 8 -> PantallaQuejas();

        }
    }

    public void CreacionVentana(){

        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(null);
        ventana.setResizable(false);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setIconImage(iconoCerebro);
        ventana.setTitle("Brain to place");


        primerPanel.setBounds(0,0,800,600);
        primerPanel.setLayout(null);
        primerPanel.setBackground(new Color(90,160,255));


        Dia.addItem("Día");

        Mes.addItem("Mes");
        Año.addItem("Año");
        Prioridad.addItem("Prioridad");
        for(int j=1;j<=12;j++){
            Mes.addItem(j);
        }

        for(int j=2022;j<=2025;j++){
            Año.addItem(j);
        }


        for(int j=1;j<=5;j++){
            Prioridad.addItem(j);
        }

    }

    public void UsarPanelAux(){
        panelAuxiliar.setBounds(570,0,230,800);
        panelAuxiliar.setLayout(null);
        panelAuxiliar.setBackground(new Color(0,0,0));

        iconoTitulo.setBounds(85,50,60,60);
        panelAuxiliar.add(iconoTitulo);
        panelAuxiliar.add(agregarTarea);
        panelAuxiliar.add(eliminarTarea);
        panelAuxiliar.add(completarTarea);
        panelAuxiliar.add(modificarTarea);
        panelAuxiliar.add(tareasPendientes);
        panelAuxiliar.add(tareasHistorial);
        panelAuxiliar.add(quejasSugerencias);

        agregarTarea.setBounds(40,150,70,70);
        agregarTarea.setBorderPainted(false);
        agregarTarea.setText("");

        eliminarTarea.setBounds(120,150,70,70);
        eliminarTarea.setBorderPainted(false);
        eliminarTarea.setText("");

        completarTarea.setBounds(40,250,70,70);
        completarTarea.setBorderPainted(false);
        completarTarea.setText("");

        modificarTarea.setBounds(120,250,70,70);
        modificarTarea.setBorderPainted(false);
        modificarTarea.setText("");

        tareasPendientes.setBounds(40,350,70,70);
        tareasPendientes.setBorderPainted(false);
        tareasPendientes.setText("");

        tareasHistorial.setBounds(120,350,70,70);
        tareasHistorial.setBorderPainted(false);
        tareasHistorial.setText("");

        quejasSugerencias.setBounds(80,450,70,70);
        quejasSugerencias.setBorderPainted(false);
        quejasSugerencias.setText("");


        primerPanel.add(panelAuxiliar);
    }

    public void PrimeraPantalla(){

        primerPanel.add(iconoTitulo);
        primerPanel.add(Título);
        primerPanel.add(agregarTarea);
        primerPanel.add(eliminarTarea);
        primerPanel.add(completarTarea);
        primerPanel.add(modificarTarea);
        primerPanel.add(tareasPendientes);
        primerPanel.add(tareasHistorial);
        primerPanel.add(quejasSugerencias);

        ventana.add(primerPanel);

        Título.setBounds(120,20,600,120);
        Título.setFont(new Font("Coffee Extra",0,60));
        Título.setBorder(null);
        Título.setBackground(null);
        Título.setForeground(new Color(255,0,0));
        Título.setVisible(true);

        iconoTitulo.setBounds(570,50,60,60);
        iconoTitulo.setBorder(null);
        iconoTitulo.setBackground(null);
        iconoTitulo.setVisible(true);
        iconoTitulo.setIcon(new ImageIcon(iconoCerebro.getScaledInstance(60,60, EXIT_ON_CLOSE)));



        agregarTarea.setFont(new Font("Comic Sans MS",0,20));
        agregarTarea.setBounds(50,170,320,60);
        agregarTarea.setBackground(new Color(0,0,0));
        agregarTarea.setForeground(new Color(90,160,255));
        agregarTarea.setCursor(new Cursor(Cursor.HAND_CURSOR));
        agregarTarea.setFocusPainted(false);
        agregarTarea.removeActionListener(evt);
        agregarTarea.addActionListener(evt);
        agregarTarea.setIcon(new ImageIcon(iconoAgregar.getScaledInstance(50,50, EXIT_ON_CLOSE)));
        agregarTarea.setText("Agrega tu nueva tarea");


        eliminarTarea.setFont(new Font("Comic Sans MS",0,20));
        eliminarTarea.setBounds(420,170,320,60);
        eliminarTarea.setBackground(new Color(0,0,0));
        eliminarTarea.setForeground(new Color(90,160,255));
        eliminarTarea.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eliminarTarea.setFocusPainted(false);
        eliminarTarea.removeActionListener(evt);
        eliminarTarea.addActionListener(evt);
        eliminarTarea.setIcon(new ImageIcon(iconoQuitar.getScaledInstance(50,50, EXIT_ON_CLOSE)));
        eliminarTarea.setText("Elimina tu tarea");


        completarTarea.setFont(new Font("Comic Sans MS",0,20));
        completarTarea.setBounds(50,240,320,60);
        completarTarea.setBackground(new Color(0,0,0));
        completarTarea.setForeground(new Color(90,160,255));
        completarTarea.setCursor(new Cursor(Cursor.HAND_CURSOR));
        completarTarea.setFocusPainted(false);
        completarTarea.removeActionListener(evt);
        completarTarea.addActionListener(evt);
        completarTarea.setIcon(new ImageIcon(iconoCompletar.getScaledInstance(50,50, EXIT_ON_CLOSE)));
        completarTarea.setText("Completa tu tarea");



        modificarTarea.setFont(new Font("Comic Sans MS",0,20));
        modificarTarea.setBounds(420,240,320,60);
        modificarTarea.setBackground(new Color(0,0,0));
        modificarTarea.setForeground(new Color(90,160,255));
        modificarTarea.setCursor(new Cursor(Cursor.HAND_CURSOR));
        modificarTarea.setFocusPainted(false);
        modificarTarea.removeActionListener(evt);
        modificarTarea.addActionListener(evt);
        modificarTarea.setIcon(new ImageIcon(iconoModificar.getScaledInstance(50,50, EXIT_ON_CLOSE)));
        modificarTarea.setText("Modifica tu tarea");



        tareasPendientes.setFont(new Font("Comic Sans MS",0,20));
        tareasPendientes.setBounds(50,310,320,60);
        tareasPendientes.setBackground(new Color(0,0,0));
        tareasPendientes.setForeground(new Color(90,160,255));
        tareasPendientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tareasPendientes.setFocusPainted(false);
        tareasPendientes.removeActionListener(evt);
        tareasPendientes.addActionListener(evt);
        tareasPendientes.setIcon(new ImageIcon(iconoPendientes.getScaledInstance(50,50, EXIT_ON_CLOSE)));
        tareasPendientes.setText("Tareas pendientes");



        tareasHistorial.setFont(new Font("Comic Sans MS",0,20));
        tareasHistorial.setBounds(420,310,320,60);
        tareasHistorial.setBackground(new Color(0,0,0));
        tareasHistorial.setForeground(new Color(90,160,255));
        tareasHistorial.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tareasHistorial.setFocusPainted(false);
        tareasHistorial.removeActionListener(evt);
        tareasHistorial.addActionListener(evt);
        tareasHistorial.setIcon(new ImageIcon(iconoHistorial.getScaledInstance(50,50, EXIT_ON_CLOSE)));
        tareasHistorial.setText("Imprime tu historial");


        quejasSugerencias.setFont(new Font("Comic Sans MS",0,20));
        quejasSugerencias.setBounds(225,380,350,60);
        quejasSugerencias.setBackground(new Color(0,0,0));
        quejasSugerencias.setForeground(new Color(90,160,255));
        quejasSugerencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quejasSugerencias.setFocusPainted(false);
        quejasSugerencias.removeActionListener(evt);
        quejasSugerencias.addActionListener(evt);
        quejasSugerencias.setIcon(new ImageIcon(iconoQuejas.getScaledInstance(50,50, EXIT_ON_CLOSE)));
        quejasSugerencias.setText("Añade tu queja");


    }

    public void PantallaAgregar(){
        UsarPanelAux();

        Título.setBounds(80,20,600,120);
        primerPanel.add(Título);

        tituloTarea.setBounds(150,150,270,30);
        tituloTarea.setText("Ingresa el título de tu tarea");
        tituloTarea.setFont(new Font("Comic Sans MS",0,20));
        tituloTarea.setBorder(null);
        tituloTarea.setBackground(null);
        tituloTarea.setForeground(Color.white);
        tituloTarea.removeFocusListener(evt);
        tituloTarea.addFocusListener(evt);
        tituloTarea.setVisible(true);
        primerPanel.add(tituloTarea);


        JSeparator SeparadorN=new JSeparator();
        SeparadorN.setBounds(150,190,270,10);
        SeparadorN.setVisible(true);
        primerPanel.add(SeparadorN);

        descripcionTarea.setBounds(135,270,300,100);
        descripcionTarea.setText("Ingresa la descripción de tu\n                   tarea");
        descripcionTarea.setLineWrap(true);
        descripcionTarea.setFont(new Font("Comic Sans MS",0,20));
        descripcionTarea.setBorder(null);
        descripcionTarea.setBackground(null);
        descripcionTarea.setForeground(Color.white);
        descripcionTarea.removeFocusListener(evt);
        descripcionTarea.addFocusListener(evt);
        descripcionTarea.setVisible(true);
        primerPanel.add(descripcionTarea);


        JSeparator Separador2=new JSeparator();
        Separador2.setBounds(135,380,280,10);
        Separador2.setVisible(true);
        primerPanel.add(Separador2);


        Dia.setBounds(335,210, 80,30);
        Dia.setFont(new Font("Comic Sans MS",1,17));
        Dia.setForeground(new Color(0,0,0));
        Dia.setVisible(true);

        Mes.setBounds(245,210, 80,30);
        Mes.setFont(new Font("Comic Sans MS",1,17));
        Mes.setForeground(new Color(0,0,0));
        Mes.setVisible(true);
        Mes.addActionListener(evt);

        Año.setBounds(155,210, 80,30);
        Año.setFont(new Font("Comic Sans MS",1,17));
        Año.setForeground(new Color(0,0,0));
        Año.setVisible(true);
        Año.addActionListener(evt);


        Prioridad.setBounds(235,420, 100,30);
        Prioridad.setFont(new Font("Comic Sans MS",1,17));
        Prioridad.setForeground(new Color(0,0,0));
        Prioridad.setVisible(true);
        Prioridad.removeActionListener(evt);
        Prioridad.addActionListener(evt);


        primerPanel.add(Dia);


        primerPanel.add(Mes);

        primerPanel.add(Año);


        primerPanel.add(Prioridad);

        agregar.setFont(new Font("Comic Sans MS",0,20));
        agregar.setBounds(160,470,250,60);
        agregar.setBackground(new Color(0,0,0));
        agregar.setForeground(new Color(90,160,255));
        agregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        agregar.setFocusPainted(false);
        agregar.removeActionListener(evt);
        agregar.addActionListener(evt);
        primerPanel.add(agregar);

        /*
        prueba.setBounds(400,200,150,60);
        prueba.setBackground(new Color(0,0,0));
        prueba.setForeground(new Color(90,160,255));
        prueba.setCursor(new Cursor(Cursor.HAND_CURSOR));
        prueba.setFocusPainted(false);
        prueba.removeActionListener(evt);
        prueba.addActionListener(evt);
        primerPanel.add(prueba);
*/
    }

    public void PantallaCancelar(){
        UsarPanelAux();

        Título.setBounds(80,20,600,120);
        primerPanel.add(Título);

        ImprimirTareasSelc();


        eliminar.setFont(new Font("Comic Sans MS",0,16));
        eliminar.setBounds(160,470,250,60);
        eliminar.setBackground(new Color(0,0,0));
        eliminar.setForeground(new Color(90,160,255));
        eliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eliminar.setFocusPainted(false);
        eliminar.removeActionListener(evt);
        eliminar.addActionListener(evt);
        primerPanel.add(eliminar);
    }

    public void PantallaCompletar(){
        UsarPanelAux();

        Título.setBounds(80,20,600,120);
        primerPanel.add(Título);

        ImprimirTareasSelc();


        completar.setFont(new Font("Comic Sans MS",0,20));
        completar.setBounds(160,470,250,60);
        completar.setBackground(new Color(0,0,0));
        completar.setForeground(new Color(90,160,255));
        completar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        completar.setFocusPainted(false);
        completar.removeActionListener(evt);
        completar.addActionListener(evt);
        primerPanel.add(completar);
    }

    public void PantallaModificar(){
        UsarPanelAux();

        Título.setBounds(80,20,600,120);
        primerPanel.add(Título);

        ImprimirTareasSelc();


        ElegirModificar.setFont(new Font("Comic Sans MS",0,20));
        ElegirModificar.setBounds(160,470,250,60);
        ElegirModificar.setBackground(new Color(0,0,0));
        ElegirModificar.setForeground(new Color(90,160,255));
        ElegirModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ElegirModificar.setFocusPainted(false);
        ElegirModificar.removeActionListener(evt);
        ElegirModificar.addActionListener(evt);
        primerPanel.add(ElegirModificar);
    }

    public void ModificarTarea(Tarea t){
        primerPanel.removeAll();
        ventana.repaint();

        UsarPanelAux();

        Título.setBounds(80,20,600,120);
        primerPanel.add(Título);

        tituloTarea.setBounds(150,150,270,30);
        tituloTarea.setText(t.getTitulo());
        tituloTarea.setFont(new Font("Comic Sans MS",0,20));
        tituloTarea.setBorder(null);
        tituloTarea.setBackground(null);
        tituloTarea.setForeground(Color.white);
        tituloTarea.removeFocusListener(evt);
        tituloTarea.addFocusListener(evt);
        tituloTarea.setVisible(true);
        primerPanel.add(tituloTarea);


        JSeparator SeparadorN=new JSeparator();
        SeparadorN.setBounds(150,190,270,10);
        SeparadorN.setVisible(true);
        primerPanel.add(SeparadorN);

        descripcionTarea.setBounds(135,270,300,100);
        descripcionTarea.setText(t.getDescripcion());
        descripcionTarea.setLineWrap(true);
        descripcionTarea.setFont(new Font("Comic Sans MS",0,20));
        descripcionTarea.setBorder(null);
        descripcionTarea.setBackground(null);
        descripcionTarea.setForeground(Color.white);
        descripcionTarea.removeFocusListener(evt);
        descripcionTarea.addFocusListener(evt);
        descripcionTarea.setVisible(true);
        primerPanel.add(descripcionTarea);


        JSeparator Separador2=new JSeparator();
        Separador2.setBounds(135,380,280,10);
        Separador2.setVisible(true);
        primerPanel.add(Separador2);


        Dia.setBounds(335,210, 80,30);
        Dia.setFont(new Font("Comic Sans MS",1,17));
        Dia.setForeground(new Color(0,0,0));
        Dia.setVisible(true);
        Dia.setSelectedItem(t.getFecha().getDia());

        Mes.setBounds(245,210, 80,30);
        Mes.setFont(new Font("Comic Sans MS",1,17));
        Mes.setForeground(new Color(0,0,0));
        Mes.setVisible(true);
        Mes.addActionListener(evt);
        Mes.setSelectedItem(t.getFecha().getMes());

        Año.setBounds(155,210, 80,30);
        Año.setFont(new Font("Comic Sans MS",1,17));
        Año.setForeground(new Color(0,0,0));
        Año.setVisible(true);
        Año.addActionListener(evt);
        Año.setSelectedItem(t.getFecha().getAño());


        Prioridad.setBounds(235,420, 100,30);
        Prioridad.setFont(new Font("Comic Sans MS",1,17));
        Prioridad.setForeground(new Color(0,0,0));
        Prioridad.setVisible(true);
        Prioridad.removeActionListener(evt);
        Prioridad.addActionListener(evt);
        Prioridad.setSelectedItem(t.getPrioridad());


        primerPanel.add(Dia);


        primerPanel.add(Mes);

        primerPanel.add(Año);


        primerPanel.add(Prioridad);

        modificar.setFont(new Font("Comic Sans MS",0,20));
        modificar.setBounds(160,470,250,60);
        modificar.setBackground(new Color(0,0,0));
        modificar.setForeground(new Color(90,160,255));
        modificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        modificar.setFocusPainted(false);
        modificar.removeActionListener(evt);
        modificar.addActionListener(evt);
        primerPanel.add(modificar);
    }

    public void PantallaPendientes(){
        UsarPanelAux();

        Título.setBounds(80,20,600,120);
        primerPanel.add(Título);

        ImprimirTareasSelc();


        verDetalles.setFont(new Font("Comic Sans MS",0,16));
        verDetalles.setBounds(160,470,250,60);
        verDetalles.setBackground(new Color(0,0,0));
        verDetalles.setForeground(new Color(90,160,255));
        verDetalles.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verDetalles.setFocusPainted(false);
        verDetalles.removeActionListener(evt);
        verDetalles.addActionListener(evt);
        primerPanel.add(verDetalles);
    }

    public void PantallaHistorial(){
        UsarPanelAux();

        Título.setBounds(80,20,600,120);
        primerPanel.add(Título);

        ImprimirHistorialSelc();


        verDetallesHist.setFont(new Font("Comic Sans MS",0,16));
        verDetallesHist.setBounds(30,470,250,60);
        verDetallesHist.setBackground(new Color(0,0,0));
        verDetallesHist.setForeground(new Color(90,160,255));
        verDetallesHist.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verDetallesHist.setFocusPainted(false);
        verDetallesHist.removeActionListener(evt);
        verDetallesHist.addActionListener(evt);
        primerPanel.add(verDetallesHist);

        BorrarHist.setFont(new Font("Comic Sans MS",0,20));
        BorrarHist.setBounds(290,470,250,60);
        BorrarHist.setBackground(new Color(0,0,0));
        BorrarHist.setForeground(new Color(90,160,255));
        BorrarHist.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BorrarHist.setFocusPainted(false);
        BorrarHist.removeActionListener(evt);
        BorrarHist.addActionListener(evt);
        primerPanel.add(BorrarHist);
    }

    public void PantallaQuejas(){
        UsarPanelAux();

        Título.setBounds(80,20,600,120);
        primerPanel.add(Título);

        ImprimirQuejSug();


        AñadirQueja.setFont(new Font("Comic Sans MS",0,16));
        AñadirQueja.setBounds(8,470,180,60);
        AñadirQueja.setBackground(new Color(0,0,0));
        AñadirQueja.setForeground(new Color(90,160,255));
        AñadirQueja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AñadirQueja.setFocusPainted(false);
        AñadirQueja.removeActionListener(evt);
        AñadirQueja.addActionListener(evt);
        primerPanel.add(AñadirQueja);

        verDetallesQueja.setFont(new Font("Comic Sans MS",0,16));
        verDetallesQueja.setBounds(197,470,180,60);
        verDetallesQueja.setBackground(new Color(0,0,0));
        verDetallesQueja.setForeground(new Color(90,160,255));
        verDetallesQueja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verDetallesQueja.setFocusPainted(false);
        verDetallesQueja.removeActionListener(evt);
        verDetallesQueja.addActionListener(evt);
        primerPanel.add(verDetallesQueja);

        resolverQueja.setFont(new Font("Comic Sans MS",0,16));
        resolverQueja.setBounds(386,470,180,60);
        resolverQueja.setBackground(new Color(0,0,0));
        resolverQueja.setForeground(new Color(90,160,255));
        resolverQueja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resolverQueja.setFocusPainted(false);
        resolverQueja.removeActionListener(evt);
        resolverQueja.addActionListener(evt);
        primerPanel.add(resolverQueja);
    }

    public void dias(int n){
        for(int j=1;j<Dia.getItemCount();){
            Dia.removeItemAt(j);
        }
        for(int j=1;j<=n;j++){
            Dia.addItem(j);
        }
    }

    public void ReiniciarIngTarea(){
        tituloTarea.setText("Ingresa el título de tu tarea");
        tituloTarea.setForeground(Color.white);
        descripcionTarea.setText("Ingresa la descripción de tu\n                   tarea");
        descripcionTarea.setForeground(Color.white);
        dias(0);
        Mes.setSelectedIndex(0);
        Año.setSelectedIndex(0);
        Prioridad.setSelectedIndex(0);
    }
    public void ReiniciarIngQueja(){
        usuarioQueja.setText("Ingresa el usuario");
        usuarioQueja.setForeground(Color.white);
        descripcionQueja.setText("Ingresa la descripción de tu\n                   queja");
        descripcionQueja.setForeground(Color.white);
    }

    public void ImprimirTareasSelc(){
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            bg.remove(button);
        }
        panelTareas.removeAll();
        panelTareas.setBounds(120,140,330,300);
        panelTareas.setLayout(null);
        panelTareas.setBackground(new Color(90,160,255));

        Nodo nodotarea = listaTareas.getCabeza();
        int indice=1;
        while(nodotarea != null){
            JRadioButton jrb = new JRadioButton(nodotarea.getTarea().getTitulo());
            jrb.setForeground(Color.black);
            jrb.setFont(new Font("Comic Sans MS",0,20));
            jrb.setBounds(40,35*indice,250,30);
            jrb.setBackground(null);
            bg.add(jrb);
            panelTareas.add(jrb);
            nodotarea=nodotarea.getSiguiente();
            indice++;
        }

        panelTareas.setBorder(null);
        primerPanel.add(panelTareas);
    }

    public void ImprimirHistorialSelc(){
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            bg.remove(button);
        }
        panelTareas.removeAll();
        panelTareas.setBounds(120,140,330,300);
        panelTareas.setLayout(null);
        panelTareas.setBackground(new Color(90,160,255));

        Nodo nodotarea = historial.cabeza;
        int indice=1;
        while(nodotarea != null){
            JRadioButton jrb = new JRadioButton(nodotarea.getTarea().getTitulo());
            jrb.setForeground(Color.black);
            jrb.setFont(new Font("Comic Sans MS",0,20));
            jrb.setBounds(40,35*indice,250,30);
            jrb.setBackground(null);
            bg.add(jrb);
            panelTareas.add(jrb);
            nodotarea=nodotarea.getSiguiente();
            indice++;
        }

        panelTareas.setBorder(null);
        primerPanel.add(panelTareas);
    }

    public void ImprimirQuejSug(){
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            bg.remove(button);
        }
        panelTareas.removeAll();
        panelTareas.setBounds(35,140,500,300);
        panelTareas.setLayout(null);
        panelTareas.setBackground(new Color(90,160,255));
        listaQuejas=new ArrayList<>();
        NodoQueja nodoQueja = QuejaSug.seek();
        int indice=1;
        while(nodoQueja != null){
            listaQuejas.add(nodoQueja.getQueja());
            JRadioButton jrb = new JRadioButton(nodoQueja.getQueja().toString());
            jrb.setForeground(Color.black);
            jrb.setFont(new Font("Comic Sans MS",0,20));
            jrb.setBounds(25,35*indice,450,30);
            jrb.setBackground(null);
            bg.add(jrb);
            panelTareas.add(jrb);
            nodoQueja=nodoQueja.getSiguiente();
            indice++;
        }

        panelTareas.setBorder(null);
        primerPanel.add(panelTareas);
    }

    public void VentanaQueja(){
        ventanaQueja.setSize(500, 500);
        ventanaQueja.getContentPane().setBackground(null);
        ventanaQueja.setResizable(false);
        ventanaQueja.setLayout(null);
        ventanaQueja.setVisible(true);
        ventanaQueja.setLocationRelativeTo(null);
        ventanaQueja.setIconImage(iconoCerebro);
        ventanaQueja.setTitle("Quejas y Sugerencias");


        panelQueja.setBounds(0,0,500,500);
        panelQueja.setLayout(null);
        panelQueja.setBackground(new Color(90,160,255));


        usuarioQueja.setBounds(115,50,270,30);
        usuarioQueja.setText("Ingresa el usuario");
        usuarioQueja.setFont(new Font("Comic Sans MS",0,20));
        usuarioQueja.setBorder(null);
        usuarioQueja.setBackground(null);
        usuarioQueja.setForeground(Color.white);
        usuarioQueja.removeFocusListener(evt);
        usuarioQueja.addFocusListener(evt);
        usuarioQueja.setVisible(true);
        panelQueja.add(usuarioQueja);


        JSeparator SeparadorN=new JSeparator();
        SeparadorN.setBounds(115,90,270,10);
        SeparadorN.setVisible(true);
        panelQueja.add(SeparadorN);

        descripcionQueja.setBounds(100,170,300,100);
        descripcionQueja.setText("Ingresa la descripción de tu\n                   queja");
        descripcionQueja.setLineWrap(true);
        descripcionQueja.setFont(new Font("Comic Sans MS",0,20));
        descripcionQueja.setBorder(null);
        descripcionQueja.setBackground(null);
        descripcionQueja.setForeground(Color.white);
        descripcionQueja.removeFocusListener(evt);
        descripcionQueja.addFocusListener(evt);
        descripcionQueja.setVisible(true);
        panelQueja.add(descripcionQueja);


        JSeparator Separador2=new JSeparator();
        Separador2.setBounds(100,280,280,10);
        Separador2.setVisible(true);
        panelQueja.add(Separador2);


        agregarQueja.setFont(new Font("Comic Sans MS",0,20));
        agregarQueja.setBounds(125,320,250,60);
        agregarQueja.setBackground(new Color(0,0,0));
        agregarQueja.setForeground(new Color(90,160,255));
        agregarQueja.setCursor(new Cursor(Cursor.HAND_CURSOR));
        agregarQueja.setFocusPainted(false);
        agregarQueja.removeActionListener(evt);
        agregarQueja.addActionListener(evt);
        panelQueja.add(agregarQueja);

        ventanaQueja.add(panelQueja);
    }
}
