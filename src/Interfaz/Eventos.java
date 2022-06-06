
package Interfaz;

import braintoplace.Fecha;
import braintoplace.QuejaSugerencia;
import braintoplace.Tarea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

public class Eventos implements ActionListener, FocusListener{
    public int indexModificacion;
    MotorInterfaz motint;
    public Eventos(MotorInterfaz motint){
        this.motint=motint;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==motint.agregarTarea){
            motint.CambiarPantalla(2);
        }
        if(e.getSource()==motint.Mes){
            if(motint.Mes.getSelectedIndex()!=0){
                if((int) motint.Mes.getSelectedItem()==1 || (int)motint.Mes.getSelectedItem()==3 || (int)motint.Mes.getSelectedItem()==5 || (int)motint.Mes.getSelectedItem()==7 || (int)motint.Mes.getSelectedItem()==8 || (int)motint.Mes.getSelectedItem()==10  || (int)motint.Mes.getSelectedItem()==12){
                    motint.dias(31);
                }else if((int) motint.Mes.getSelectedItem()==2 && motint.Ano.getSelectedIndex()!=0 && (int)motint.Ano.getSelectedItem()==2024){
                    motint.dias(29);
                }else if((int) motint.Mes.getSelectedItem()==2){
                    motint.dias(28);
                }else
                    motint.dias(30);
            }else
                motint.dias(0);

        }
        if(e.getSource()==motint.Ano && motint.Mes.getSelectedIndex()!=0 && motint.Ano.getSelectedIndex()!=0){
            if((int) motint.Ano.getSelectedItem()==2024 && (int) motint.Mes.getSelectedItem()==2){
                motint.dias(29);
            }else if((int) motint.Mes.getSelectedItem()==2){
                motint.dias(28);
            }
        }
        if(e.getSource()==motint.agregar){
            if(motint.tituloTarea.getText().equals("Ingresa el t\u00edtulo de tu tarea") || motint.descripcionTarea.getText().equals("Ingresa la descripci\u00f3n de tu\n                   tarea") || motint.Dia.getSelectedIndex()==0 || motint.Mes.getSelectedIndex()==0 || motint.Ano.getSelectedIndex()==0 || motint.Prioridad.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
            }else{
                Tarea tarea = new Tarea(motint.tituloTarea.getText(), motint.descripcionTarea.getText(), new Fecha((int) motint.Dia.getSelectedItem(),(int) motint.Mes.getSelectedItem(),(int) motint.Ano.getSelectedItem()), (int) motint.Prioridad.getSelectedItem());
                motint.listaTareas.agregarNodoInicio(tarea);
                motint.ReiniciarIngTarea();
            }
        }
        if(e.getSource()==motint.prueba){
            motint.listaTareas.printLista();
            motint.CambiarPantalla(1);
        }

        if(e.getSource()==motint.eliminarTarea){
            if(!motint.listaTareas.estaVacia()){
                motint.CambiarPantalla(3);
            }else
                JOptionPane.showMessageDialog(null, "Tu lista de tareas est\u00e1 vacía, no puedes eliminar.");

        }
        if(e.getSource()==motint.eliminar){
            for (Enumeration<AbstractButton> buttons = motint.bg.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    int i=motint.listaTareas.buscarTarea(button.getText());
                    motint.listaTareas.eliminarTarea(i);
                    motint.ImprimirTareasSelc();
                    motint.ventana.repaint();
                    if(motint.listaTareas.estaVacia()){
                        JOptionPane.showMessageDialog(null, "Has eliminado el último elemento, no puedes eliminar más.");
                        motint.CambiarPantalla(1);
                    }
                }
            }
        }
        if(e.getSource()==motint.completarTarea){
            if(!motint.listaTareas.estaVacia()){
                motint.CambiarPantalla(4);
            }else
                JOptionPane.showMessageDialog(null, "Tu lista de tareas est\u00e1 vacía, no puedes completar ninguna.");

        }
        if(e.getSource()==motint.completar){
            for (Enumeration<AbstractButton> buttons = motint.bg.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    int i=motint.listaTareas.buscarTarea(button.getText());
                    motint.listaTareas.completarTarea(i, motint.historial);
                    motint.ImprimirTareasSelc();
                    motint.ventana.repaint();
                    if(motint.listaTareas.estaVacia()){
                        JOptionPane.showMessageDialog(null, "Has completado todas tus tareas. ¡Felicitaciones!.");
                        motint.CambiarPantalla(1);
                    }
                }
            }
        }
        if(e.getSource()==motint.modificarTarea){
            if(!motint.listaTareas.estaVacia()){
                motint.CambiarPantalla(5);
            }else
                JOptionPane.showMessageDialog(null, "Tu lista de tareas esta� vacia, no puedes modificar ninguna.");

        }
        if(e.getSource()==motint.ElegirModificar){
            for (Enumeration<AbstractButton> buttons = motint.bg.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    indexModificacion=motint.listaTareas.buscarTarea(button.getText());
                    Tarea t=motint.listaTareas.buscarTareaConIndice(indexModificacion);
                    motint.ModificarTarea(t);
                    motint.ventana.repaint();
                }
            }
        }
        if(e.getSource()==motint.modificar){
            if(motint.tituloTarea.getText().equals("Ingresa el t\u00edtulo de tu tarea") || motint.descripcionTarea.getText().equals("Ingresa la descripci\u00f3n de tu\n                   tarea") || motint.Dia.getSelectedIndex()==0 || motint.Mes.getSelectedIndex()==0 || motint.Prioridad.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
            }else{
                //tareas.modificarTarea(indice, titulo, descripcion, fecha, prioridad);
                motint.listaTareas.modificarTarea(indexModificacion,motint.tituloTarea.getText(), motint.descripcionTarea.getText(), new Fecha((int) motint.Dia.getSelectedItem(),(int) motint.Mes.getSelectedItem(),(int) motint.Ano.getSelectedItem()), (int) motint.Prioridad.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Tarea modificada");
                motint.ReiniciarIngTarea();
                motint.CambiarPantalla(5);
            }
        }

        if(e.getSource()==motint.tareasPendientes){
            if(!motint.listaTareas.estaVacia()){
                motint.CambiarPantalla(6);
            }else
                JOptionPane.showMessageDialog(null, "Tu lista de tareas est\u00e1 vacía, no tienes tareas pendientes.");
        }
        if(e.getSource()==motint.verDetalles){
            for (Enumeration<AbstractButton> buttons = motint.bg.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    int i=motint.listaTareas.buscarTarea(button.getText());
                    Tarea t=motint.listaTareas.buscarTareaConIndice(i);
                    JOptionPane.showMessageDialog(null,t);
                }
            }
        }

        if(e.getSource()==motint.tareasHistorial){
            if(!motint.historial.isEmpty()){
                motint.CambiarPantalla(7);
            }else
                JOptionPane.showMessageDialog(null, "Tu historial est\u00e1 vac\u00edo, no has completado ninguna tarea.");
        }
        if(e.getSource()==motint.verDetallesHist){
            for (Enumeration<AbstractButton> buttons = motint.bg.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    Tarea t=motint.historial.buscarTarea(button.getText());
                    JOptionPane.showMessageDialog(null,t);
                }
            }
        }
        if(e.getSource()==motint.BorrarHist){
            motint.historial.deleteHistorial();
            motint.ImprimirTareasSelc();
            motint.ventana.repaint();
            if(motint.historial.isEmpty()){
                JOptionPane.showMessageDialog(null, "Tu historial ha sido borrado.");
                motint.CambiarPantalla(1);
            }
        }
        if(e.getSource()==motint.quejasSugerencias){
            motint.CambiarPantalla(8);
        }
        if(e.getSource()==motint.verDetallesQueja){
            if(motint.bg.getElements().hasMoreElements()){
                for (Enumeration<AbstractButton> buttons = motint.bg.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    for(QuejaSugerencia q:motint.listaQuejas){
                        if (button.isSelected() && button.getText().equals(q.toString())) {
                            JOptionPane.showMessageDialog(null,"La "+q+"\n es: "+q.getDetalles());
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null,"No hay ninguna queja seleccionada para mostrar");
            }
        }
        if(e.getSource()==motint.resolverQueja){
            if(motint.bg.getElements().hasMoreElements()){
                JOptionPane.showMessageDialog(null,"Se ha solucionado la "+motint.QuejaSug.deq());
                motint.ImprimirQuejSug();
                motint.ventana.repaint();
            }else{
                JOptionPane.showMessageDialog(null,"No hay ninguna queja para solucionar");
            }
        }
        if(e.getSource()==motint.AnadirQueja){
            motint.VentanaQueja();
        }
        if(e.getSource()==motint.agregarQueja){
            if(motint.usuarioQueja.getText().equals("Ingresa el tusuario") || motint.descripcionQueja.getText().equals("Ingresa la descripci\u00f3n de tu\n                   queja")){
                JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
            }else{
                QuejaSugerencia q = new QuejaSugerencia(motint.usuarioQueja.getText(), motint.descripcionQueja.getText());
                motint.QuejaSug.enq(q);
                motint.ReiniciarIngQueja();
                motint.ventanaQueja.dispose();
                motint.CambiarPantalla(8);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==motint.tituloTarea && motint.tituloTarea.getText().equals("Ingresa el t\u00edtulo de tu tarea")){
            motint.tituloTarea.setText("");
            motint.tituloTarea.setForeground(Color.black);
        }

        if(e.getSource()==motint.descripcionTarea && motint.descripcionTarea.getText().equals("Ingresa la descripci\u00f3n de tu\n                   tarea")){
            motint.descripcionTarea.setText("");
            motint.descripcionTarea.setForeground(Color.black);
        }


        if(e.getSource()==motint.usuarioQueja && motint.usuarioQueja.getText().equals("Ingresa el usuario")){
            motint.usuarioQueja.setText("");
            motint.usuarioQueja.setForeground(Color.black);
        }

        if(e.getSource()==motint.descripcionQueja && motint.descripcionQueja.getText().equals("Ingresa la descripci\u00f3n de tu\n                   queja")){
            motint.descripcionQueja.setText("");
            motint.descripcionQueja.setForeground(Color.black);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource()==motint.tituloTarea && motint.tituloTarea.getText().equals("")){
            motint.tituloTarea.setText("Ingresa el t\u00edtulo de tu tarea");
            motint.tituloTarea.setForeground(Color.white);
        }

        if(e.getSource()==motint.descripcionTarea && motint.descripcionTarea.getText().equals("")){
            motint.descripcionTarea.setText("Ingresa la descripci\u00f3n de tu\n                   tarea");
            motint.descripcionTarea.setForeground(Color.white);
        }

        if(e.getSource()==motint.usuarioQueja && motint.usuarioQueja.getText().equals("")){
            motint.usuarioQueja.setText("Ingresa el usuario");
            motint.usuarioQueja.setForeground(Color.white);
        }
        if(e.getSource()==motint.descripcionQueja && motint.descripcionQueja.getText().equals("")){
            motint.descripcionQueja.setText("Ingresa la descripci\u00f3n de tu\n                   queja");
            motint.descripcionQueja.setForeground(Color.white);
        }
    }

}
