package braintoplace;

public class NodoDobleEnlace {
	private Tarea tarea;
	private NodoDobleEnlace siguiente;
	private NodoDobleEnlace anterior;

	public NodoDobleEnlace(Tarea tarea) {
		setTarea(tarea);
		setSiguiente(null);
		setAnterior(null);
	}
	public NodoDobleEnlace(Tarea tarea, NodoDobleEnlace siguiente, NodoDobleEnlace anterior) {
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
	public NodoDobleEnlace getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoDobleEnlace siguiente) {
		this.siguiente = siguiente;
	}
	public NodoDobleEnlace getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoDobleEnlace anterior) {
		this.anterior = anterior;
	}
}