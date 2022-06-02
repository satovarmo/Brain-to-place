package braintoplace;

public class Nodo {
	private Tarea tarea;
	private Nodo siguiente;
	private Nodo anterior;

	public Nodo(Tarea tarea) {
		setTarea(tarea);
		setSiguiente(null);
		setAnterior(null);
	}
	public Nodo(Tarea tarea, Nodo siguiente, Nodo anterior) {
		setTarea(tarea);
		setSiguiente(siguiente);
		setAnterior(anterior);
	}
	public Tarea getTarea() {
		return tarea;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public Nodo getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
}