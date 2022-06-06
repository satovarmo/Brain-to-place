package braintoplace;

public class NodoSimpleEnlace {
	private Tarea tarea;
	private NodoSimpleEnlace siguiente;

	public NodoSimpleEnlace(Tarea tarea) {
		setTarea(tarea);
		setSiguiente(null);
	}
	public NodoSimpleEnlace(Tarea tarea, NodoSimpleEnlace siguiente) {
		setTarea(tarea);
		setSiguiente(siguiente);
	}
	public Tarea getTarea() {
		return tarea;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	public NodoSimpleEnlace getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoSimpleEnlace siguiente) {
		this.siguiente = siguiente;
	}
}