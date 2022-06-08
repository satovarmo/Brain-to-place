package braintoplace;

import java.nio.charset.Charset;
import java.util.Random;

public class Test2Entrega {

	public static void testAgregarTareaListaDobleRandom(int iteraciones) {
		ListaTareasDobleEnlace listaTest = new ListaTareasDobleEnlace();
		int contador = 0;
		long tiempoTotal = 0;
		while(contador < iteraciones) {
			int randomNum = (int)(Math.random() * 6);  // 0 to 5
			
			byte[] array = new byte[7]; // length is bounded by 7
		    new Random().nextBytes(array);
		    String generatedString = new String(array, Charset.forName("UTF-8"));
		    String generatedString2 = new String(array, Charset.forName("UTF-8"));
			
			Fecha fechaTest = new Fecha(31,8,1993);
			Tarea tareaTest = new Tarea(generatedString,generatedString2,fechaTest,randomNum);
			long tiempoInicial = System.nanoTime();
			listaTest.agregarNodoInicio(tareaTest);
			long tiempoFinal = System.nanoTime();
			tiempoTotal += tiempoFinal-tiempoInicial;
			contador++;
		}
		System.out.println(tiempoTotal);
	}
	public static void testAgregarTareaListaDobleFull(int iteraciones) {
		ListaTareasDobleEnlace listaTest = new ListaTareasDobleEnlace();
		int contador = 0;
		long tiempoTotal = 0;
		while(contador < iteraciones) {
			Fecha fechaTest = new Fecha(31,8,1993);
			Tarea tareaTest = new Tarea("tituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTesttituloTest"
										,"descripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTestdescripcionTest"
										,fechaTest,5);
			long tiempoInicial = System.nanoTime();
			listaTest.agregarNodoInicio(tareaTest);
			long tiempoFinal = System.nanoTime();
			tiempoTotal += tiempoFinal-tiempoInicial;
			contador++;
		}
		System.out.println(tiempoTotal);
	}
	
	public static void testAgregarTareaListaDoble(int iteraciones) {
		ListaTareasDobleEnlace listaTest = new ListaTareasDobleEnlace();
		int contador = 0;
		long tiempoTotal = 0;
		while(contador < iteraciones) {
			Fecha fechaTest = new Fecha(31,8,1993);
			Tarea tareaTest = new Tarea("tituloTest","decpTest",fechaTest,5);
			long tiempoInicial = System.nanoTime();
			listaTest.agregarNodoInicio(tareaTest);
			long tiempoFinal = System.nanoTime();
			tiempoTotal += tiempoFinal-tiempoInicial;
			contador++;
		}
		System.out.println(tiempoTotal);
	}
	public static void testAgregarTareaListaSimple(int iteraciones) {
		ListaTareasSimpleEnlace listaTest = new ListaTareasSimpleEnlace();
		int contador = 0;
		long tiempoTotal = 0;
		while(contador < iteraciones) {
			Fecha fechaTest = new Fecha(31,8,1993);
			Tarea tareaTest = new Tarea("tituloTest","descripcionTest",fechaTest,5);
			NodoSimpleEnlace nodoTest = new NodoSimpleEnlace(tareaTest);
			long tiempoInicial = System.nanoTime();
			listaTest.agregarPrincipio(nodoTest);
			long tiempoFinal = System.nanoTime();
			tiempoTotal += tiempoFinal-tiempoInicial;
			contador++;
		}
		System.out.println(tiempoTotal);
	}
	public static void testAgregarTareaArbolHeap(int iteraciones) {
		HeapTareas arbolTest = new HeapTareas();
		int contador = 0;
		long tiempoTotal = 0;
		while(contador < iteraciones) {
			Fecha fechaTest = new Fecha(31,8,1993);
			Tarea tareaTest = new Tarea("tituloTest","descripcionTest",fechaTest,5);
			long tiempoInicial = System.nanoTime();
			arbolTest.insert(tareaTest);
			long tiempoFinal = System.nanoTime();
			tiempoTotal += tiempoFinal-tiempoInicial;
			contador++;
		}
		System.out.println(tiempoTotal);
	}
	
	public static void testCompletarTareaListaDoble(int iteraciones) {
		ListaTareasDobleEnlace listaTest = new ListaTareasDobleEnlace();
		Historial historialTest = new Historial();
		int contador1 = 0;
		while(contador1 < iteraciones) {
			Fecha fechaTest = new Fecha(31,8,1993);
			Tarea tareaTest = new Tarea("tituloTest","descripcionTest",fechaTest,5);
			listaTest.agregarNodoInicio(tareaTest);
			contador1++;
		}
		int contador2 = 0;
		long tiempoTotal = 0;
		while(contador2 < iteraciones) {
			long tiempoInicial = System.nanoTime();
			listaTest.completarTarea(1,historialTest);
			long tiempoFinal = System.nanoTime();
			tiempoTotal += tiempoFinal-tiempoInicial;
			contador2++;
		}
		System.out.println(tiempoTotal);
	}
	public static void testCompletarTareaListaSimple(int iteraciones) {
		ListaTareasSimpleEnlace listaTest = new ListaTareasSimpleEnlace();
		Historial historialTest = new Historial();
		int contador1 = 0;
		while(contador1 < iteraciones) {
			Fecha fechaTest = new Fecha(31,8,1993);
			Tarea tareaTest = new Tarea("tituloTest","descripcionTest",fechaTest,5);
			NodoSimpleEnlace nodoTest = new NodoSimpleEnlace(tareaTest);
			listaTest.agregarPrincipio(nodoTest);
			contador1++;
		}
		int contador2 = 0;
		long tiempoTotal = 0;
		while(contador2 < iteraciones) {
			long tiempoInicial = System.nanoTime();
			listaTest.completarIndice(1,historialTest);
			long tiempoFinal = System.nanoTime();
			tiempoTotal += tiempoFinal-tiempoInicial;
			contador2++;
		}
		System.out.println(tiempoTotal);
	}
	public static void testCompletarTareaArbolHeap(int iteraciones) {
		HeapTareas arbolTest = new HeapTareas();
		Historial historialTest = new Historial();
		int contador1 = 0;
		while(contador1 < iteraciones) {
			Fecha fechaTest = new Fecha(31,8,1993);
			Tarea tareaTest = new Tarea("tituloTest","descripcionTest",fechaTest,5);
			arbolTest.insert(tareaTest);
			contador1++;
		}
		int contador2 = 0;
		long tiempoTotal = 0;
		while(contador2 < iteraciones) {
			long tiempoInicial = System.nanoTime();
			arbolTest.completarTarea(1,historialTest);
			long tiempoFinal = System.nanoTime();
			tiempoTotal += tiempoFinal-tiempoInicial;
			contador2++;
		}
		System.out.println(tiempoTotal);
	}
	
	
	/*
	public static void testCompletarTareaArbolHeap(int iteraciones) {
		ListaEnlazadaTareas listaTest = new ListaEnlazadaTareas();
		Historial historialTest = new Historial();
		int contador1 = 0;
		while(contador1 < iteraciones) {
			Tarea tareaTest = new Tarea("tituloTest","descripcionTest","fechaTest",5);
			listaTest.agregarNodoInicio(tareaTest);
			contador1++;
		}
		int contador2 = 0;
		long tiempoInicial = System.nanoTime();
		while(contador2 < iteraciones) {
			listaTest.completarTarea(1,historialTest);
			contador2++;
		}
		long tiempoFinal = System.nanoTime();
		long tiempoTotal = tiempoFinal-tiempoInicial;
		System.out.println(tiempoTotal);
		//System.out.println("Test "+iteraciones+" iteraciones de Agregar Tarea a lista enlazada:"+tiempoTotal+" nanosegundos");
	}
	*/
	
	
	
}
