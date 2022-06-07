package braintoplace;

public class ListaTareasSimpleEnlace {
	private NodoSimpleEnlace cabeza;

	public ListaTareasSimpleEnlace(){
		this.cabeza = null;
	}

	public boolean vacia(){
		return this.cabeza == null;
	}

	public void agregarPrincipio(NodoSimpleEnlace nodo) {
		if(!this.vacia()){
			nodo.setSiguiente(cabeza);
		}
		cabeza = nodo;
	}
	public void agregarFinal(NodoSimpleEnlace nodo) {
		NodoSimpleEnlace referencia = cabeza;
		while(referencia.getSiguiente()!=null) {
			referencia = referencia.getSiguiente();
		}
		referencia.setSiguiente(nodo);
	}
	public void agregarIndice(int indice, NodoSimpleEnlace nodo) {
		NodoSimpleEnlace referencia = cabeza;
		int bandera = 1;
		while(bandera!=indice) {
			referencia = referencia.getSiguiente();
			bandera++;
		}
		nodo.setSiguiente(referencia.getSiguiente());
		referencia.setSiguiente(nodo);
	}
	public NodoSimpleEnlace extraerPrincipio() {
		return cabeza;
	}
	public NodoSimpleEnlace extraerFinal() {
		NodoSimpleEnlace referencia = cabeza;
		while(referencia.getSiguiente()!=null) {
			referencia = referencia.getSiguiente();
		}
		return referencia;
	}
	public NodoSimpleEnlace extraerIndice(int indice) {
		NodoSimpleEnlace referencia = cabeza;
		int bandera = 1;
		while(bandera!=indice) {
			referencia = referencia.getSiguiente();
			bandera++;
		}
		return referencia;
	}
	
	public void removerPrincipio() {
		cabeza = cabeza.getSiguiente();
	}
	public void removerFinal() {
		NodoSimpleEnlace referencia = cabeza;
		while(referencia.getSiguiente()!=null) {
			if(referencia.getSiguiente().getSiguiente()==null) {
				referencia.setSiguiente(null);
			}
			referencia = referencia.getSiguiente();
		}
	}
	public void removerIndice(int indice) {
		if(indice==1) {
			removerPrincipio();
		}
		else {
			NodoSimpleEnlace referencia = cabeza;
			int bandera = 1;
			while(bandera!=indice-1) {
				referencia = referencia.getSiguiente();
				bandera++;
			}
			referencia.setSiguiente(null);
		}
	}
	

	public void completarIndice(int indice, Historial historia) {
		historia.insert(extraerIndice(indice).getTarea());
		removerIndice(indice);
	}
	
	public NodoSimpleEnlace getCabeza() {
		return cabeza;
	}
	public void setCabeza(NodoSimpleEnlace nodo) {
		this.cabeza = nodo;
	}
	
	//otros metodos x revisar
	
	/*
	public void imprimirListaEnlazada(NodoDobleEnlace puntero) {
		if(puntero != null) {
			if(puntero != cabeza) {
				System.out.println(",");
			}
			System.out.println(puntero.getTarea().getTitulo()+","+puntero.getTarea().getDescripcion()+","+puntero.getTarea().getFecha()+","+puntero.getTarea().getPrioridad());
			imprimirListaEnlazada(puntero.getSiguiente());
		}
	}

	public void ordenarPorPrioridadDescendente(){
		NodoDobleEnlace actual = cabeza;
		while(actual != null){
			NodoDobleEnlace siguiente = actual.getSiguiente();
			while(siguiente != null){
				if(actual.getTarea().getPrioridad() < siguiente.getTarea().getPrioridad()){
					Tarea aux = actual.getTarea();
					actual.setTarea(siguiente.getTarea());
					siguiente.setTarea(aux);
				}
				siguiente = siguiente.getSiguiente();
			}
			actual = actual.getSiguiente();
		}
	}
	//Probando métodos

	public void printLista(){
		if(!this.vacia()){
			NodoDobleEnlace nodotarea = this.getCabeza();
			int indice = 1;
			while(nodotarea != null){
				System.out.println(indice+" | "+nodotarea.getTarea().getTitulo()+" | "+nodotarea.getTarea().getDescripcion()+" | "+nodotarea.getTarea().getFecha()+" | "+nodotarea.getTarea().getPrioridad());
				nodotarea = nodotarea.getSiguiente();
				indice++;
			}
		}
		else{
			System.out.println("Lista vacia");
		}
	}

	public int buscarTarea(String tit){
		if(!this.vacia()){
			NodoDobleEnlace nodotarea = this.getCabeza();
			int indice=1;
			while(!nodotarea.getTarea().getTitulo().equals(tit)){
				nodotarea=nodotarea.getSiguiente();
				indice++;
			}
			return indice;
		}
		return -1;
	}


	public Tarea buscarTareaConIndice(int indice){
		if(!this.vacia()){
			NodoDobleEnlace nodotarea = this.getCabeza();
			for(int i = 1; i < indice; i++){
				nodotarea = nodotarea.getSiguiente();
			}
			return nodotarea.getTarea();

		}
		return null;
	}

	public void completarTarea(int indice, Historial historial){
		if(!this.vacia()){
			NodoDobleEnlace nodotarea = this.getCabeza();
			int contador = 1;
			while(nodotarea != null){
				if(contador == indice){
					historial.insert(nodotarea.getTarea());
					this.eliminarTarea(indice);
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
	public void eliminarTarea(int indice){
		if(!this.vacia()){
			NodoDobleEnlace nodotarea = this.getCabeza();
			for(int i = 1; i < indice; i++){
				nodotarea = nodotarea.getSiguiente();
			}
			if(cabeza == cola){
				cabeza = null;
				cola = null;
			}
			else if(nodotarea.getSiguiente() == null){
				cola = nodotarea.getAnterior();
				nodotarea.getAnterior().setSiguiente(null);
			}else if(nodotarea.getAnterior() == null){
				this.cabeza = nodotarea.getSiguiente();
				nodotarea.getSiguiente().setAnterior(null);
			}else{
				nodotarea.getAnterior().setSiguiente(nodotarea.getSiguiente());
				nodotarea.getSiguiente().setAnterior(nodotarea.getAnterior());
			}
		}
		else{
			System.out.println("No hay tareas para eliminar");
		}
	}
	public void modificarTarea(int indice, String titulo, String descripcion, Fecha fecha, int prioridad){
		if(!this.vacia()){
			NodoDobleEnlace nodotarea = this.getCabeza();
			for(int i = 1; i < indice; i++){
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
		if(!this.vacia()){
			int i = 0;
			NodoDobleEnlace nodotarea = this.getCabeza();
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
	
	*/
}