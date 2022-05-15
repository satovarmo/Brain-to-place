
public class Tarea {

	private String titulo;
	private String descripcion;
	private String fecha;
	private int prioridad;

	//private int FechaInicio;
	//private int Prioridad2;
	//private int Prioridad3;
	
	public Tarea(String titulo, String descripcion, String fecha, int prioridad) {
		setTitulo(titulo);
		setDescripcion(descripcion);
		setFecha(fecha);
		setPrioridad(prioridad);
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
}
