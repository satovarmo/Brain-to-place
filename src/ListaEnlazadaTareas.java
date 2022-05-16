
public class ListaEnlazadaTareas {
	private Nodo cabeza;
	private Nodo cola;
	
	public ListaEnlazadaTareas(){
		this.cabeza = null;
		this.cola = null;
	}

	public Nodo getCabeza() {
		return cabeza;
	}

	public boolean estaVacia(){
		return this.cabeza == null;
	}

	public void agregarNodoInicio(Tarea tarea) {
		Nodo nuevoNodo = new Nodo(tarea);
		nuevoNodo.setSiguiente(cabeza);
		cabeza = nuevoNodo;
	}
	public void agregarNodoFinal(Tarea tarea) {
		Nodo nuevoNodo = new Nodo(tarea);
		nuevoNodo.setAnterior(cola);
		cola = nuevoNodo;
	}
	public void imprimirListaEnlazada(Nodo puntero) {
		if(puntero != null) {
			if(puntero != cabeza) {
				System.out.println(",");	
			}
			System.out.println(puntero.getTarea().getTitulo()+","+puntero.getTarea().getDescripcion()+","+puntero.getTarea().getFecha()+","+puntero.getTarea().getPrioridad());
			imprimirListaEnlazada(puntero.getSiguiente());
		}
	}

	//Probando métodos

	public void printLista(){
		if(!this.estaVacia()){
			Nodo nodotarea = this.getCabeza();
			int indice = 1;
			while(nodotarea != null){
				System.out.println(indice+" | "+nodotarea.getTarea().getTitulo()+" | "+nodotarea.getTarea().getDescripcion()+" | "+nodotarea.getTarea().getFecha()+" | "+nodotarea.getTarea().getPrioridad());
				nodotarea = nodotarea.getSiguiente();
				indice++;
		}
		}else{
			System.out.println("Lista vacia");
		}
	}

	public void completarTarea(int indice){
		if(!this.estaVacia()){
			Nodo nodotarea = this.getCabeza();
			int contador = 0;
			while(nodotarea != null){
				if(contador == indice){
					enviarAHistorial(nodotarea.getTarea());
					break;
				}
				nodotarea = nodotarea.getSiguiente();
				contador++;
			}
		}
		else{
			System.out.println("No hay tareas para completar");
		}
	}

	private void enviarAHistorial(Tarea tarea) {
	}

	public void eliminarTarea(int indice){		
		if(!this.estaVacia()){
			Nodo nodotarea = this.getCabeza();
			for(int i = 0; i < indice; i++){
				nodotarea = nodotarea.getSiguiente();
			}
			//enviarAHistorial(nodotarea);
			if(nodotarea.getSiguiente() == null){
				this.cola = nodotarea.getAnterior();
				nodotarea.getAnterior().setSiguiente(null);
			}
			else if(nodotarea.getAnterior() == null){
				this.cabeza = nodotarea.getSiguiente();
				nodotarea.getSiguiente().setAnterior(null);
			}
			else{
				nodotarea.getAnterior().setSiguiente(nodotarea.getSiguiente());
				nodotarea.getSiguiente().setAnterior(nodotarea.getAnterior());
			}
		}
		else{
			System.out.println("No hay tareas para eliminar");
		}
	}

  	public void modificarTarea(int indice, String titulo, String descripcion, String fecha, int prioridad){
  		if(!this.estaVacia()){
			Nodo nodotarea = this.getCabeza();
			for(int i = 0; i < indice; i++){
				nodotarea = nodotarea.getSiguiente();
			}
			nodotarea.getTarea().setTitulo(titulo);
			nodotarea.getTarea().setDescripcion(descripcion);
			nodotarea.getTarea().setFecha(fecha);
			nodotarea.getTarea().setPrioridad(prioridad);
		}
  		else{
			System.out.println("No hay tareas para modificar");
		}
  	}

	public void verTarea(int indice){
		if(!this.estaVacia()){
			int i = 0;
			Nodo nodotarea = this.getCabeza();
			while(i <= indice){
				nodotarea = nodotarea.getSiguiente();
				i++;
			}
			System.out.println(indice+" | "+nodotarea.getTarea().getTitulo()+" | "+nodotarea.getTarea().getDescripcion()+" | "+nodotarea.getTarea().getFecha()+" | "+nodotarea.getTarea().getPrioridad());
		}
		else{
			System.out.println("No hay tareas para ver");
		}
	}
}
