import Interfaz.MotorInterfaz;
import braintoplace.Fecha;
import braintoplace.HeapTareas;
import braintoplace.Tarea;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		HeapTareas priorizador = new HeapTareas();
		Tarea t1 = new Tarea("Taller 2", "", new Fecha(), 2);
		Tarea t2 = new Tarea("Evaluación 1", "", new Fecha(), 4);
		Tarea t3 = new Tarea("Tarea coordenadas polares", "", new Fecha(), 3);
		Tarea t4 = new Tarea("revisión parcial 2", "", new Fecha(), 1);
		Tarea t5 = new Tarea("ensayo crítico", "", new Fecha(), 5);
		priorizador.insert(t1);
		priorizador.insert(t2);
		priorizador.insert(t3);
		priorizador.insert(t4);
		priorizador.insert(t5);
		priorizador.print();
		MotorInterfaz mot = new MotorInterfaz();
		/*
		ListaEnlazadaTareas tareas = new ListaEnlazadaTareas();
		Historial historial = new Historial();
                ColaQuejasSugerencias ColaQyS=new ColaQuejasSugerencias();
		
		boolean salir = false;
		while(salir ==  false) {
			System.out.println("\n------- Brain-to-Place -------\n");
			System.out.println("1. Agregar Tarea");
			System.out.println("2. Completar Tarea");
			System.out.println("3. Eliminar Tarea");
			System.out.println("4. Modificar Tarea");
			System.out.println("5. Tareas Pendientes");
			System.out.println("6. Historial de Tareas");
			System.out.println("7. Quejas o Sugerencias");
			System.out.println("8. Pruebas de rendimiento");
			System.out.println("9. Salir\n");
			
			Scanner lector = new Scanner(System.in);
		    String entrada1 = lector.nextLine();
			int indice;
			
			switch(entrada1) {
			  case "1":
				  System.out.println("Ingrese el titulo de su Tarea:");
				  String titulo = lector.nextLine();
				  System.out.println("Ingrese la descripcion de su Tarea:");
				  String descripcion = lector.nextLine();
				  System.out.println("Ingrese la fecha maxima, para la realizacion de su Tarea:");
				  String fecha = lector.nextLine();
				  System.out.println("Ingrese un numero de 1 a 5, donde 5 es la prioridad mas alta:");
				  int prioridad = lector.nextInt();
				  
				  Tarea tarea = new Tarea(titulo, descripcion, fecha, prioridad);
				  tareas.agregarNodoInicio(tarea);
				  
				  break;
			  case "2":
			  		tareas.printLista();
					if(!tareas.estaVacia()){
						System.out.println("Ingrese el indice de la tarea a completar");
						indice = lector.nextInt();
						tareas.completarTarea(indice, historial);
					}
				  break;
			  case "3":
			  		tareas.printLista();
					if(!tareas.estaVacia()){
						System.out.println("Ingrese el indice de la tarea a eliminar");
						indice = lector.nextInt();
						tareas.eliminarTarea(indice);
					}
				  break;
			  case "4":
			        tareas.printLista();
					if(!tareas.estaVacia()){
						System.out.println("Ingrese el indice de la tarea a modificar");
						indice = lector.nextInt();
						System.out.println("Ingrese el nuevo titulo de la tarea");
						titulo = lector.nextLine();
						lector.nextLine();
						System.out.println("Ingrese la nueva descripcion de la tarea");
						descripcion = lector.nextLine();
						System.out.println("Ingrese la nueva fecha máxima de la tarea");
						fecha = lector.nextLine();
						System.out.println("Ingrese la nueva prioridad de la tarea");
						prioridad = lector.nextInt();
						tareas.modificarTarea(indice, titulo, descripcion, fecha, prioridad);
					}
					
				  break;
			  case "5":
			  		tareas.printLista();
				  break;
			  case "6":
				  historial.printHistorial();
				  break;
			  case "7":
				  ColaQyS.menuQuejas();
				  break;
			  case "8":
				  Pruebas.test();
				  break;
			  case "9":
				  salir = true;
				  break;
			  default:
			}
		}*/
	}
}
