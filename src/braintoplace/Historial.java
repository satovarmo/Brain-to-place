package braintoplace;

import java.util.Scanner;
public class Historial{
//Implementación pila usando referencias

  public Nodo cabeza;

  public Historial(){
    this.cabeza = null;
  }

  public void insert(Tarea tarea){
    Nodo nElemento = new Nodo(tarea);
    if (this.isEmpty()){
      cabeza = nElemento;
    }else{
      nElemento.setSiguiente(cabeza);
      cabeza = nElemento;
    }
  }

  public boolean isEmpty()
  {
    return cabeza == null;
  }

  public void printHistorial(){
    Nodo elemento = cabeza;
    System.out.println("Historial de Tareas Completas:");
    while(elemento != null){
      System.out.println( "* "  + elemento.getTarea().getTitulo() + "\t\t" + elemento.getTarea().getFecha() + "\t\t"+ elemento.getTarea().getDescripcion() +"\t \t"+ elemento.getTarea().getPrioridad());
      elemento = elemento.getSiguiente();
    }
    if (this.isEmpty()){
      System.out.println("El historial está vacio");
    }
    else{
      System.out.println("¿Desea borrar el historial? y/n");
      Scanner lector = new Scanner(System.in);
      char x = lector.next().charAt(0);
      deleteHistorial();
    }

  }

  public void deleteHistorial(){
    cabeza=null;
  }

  public Tarea buscarTarea(String t){
    Nodo el=cabeza;
    while(el!=null){
      if(el.getTarea().getTitulo().equals(t)){
        return el.getTarea();
      }
      el=el.getSiguiente();
    }
    return null;
  }
}

