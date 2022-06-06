package braintoplace;
import java.util.ArrayList;
import java.util.Collections;

public class HeapTareas {
    private ArrayList<Tarea> heapArray; //arreglo dinámico
    private int size;

    public HeapTareas(){
        this.heapArray = new ArrayList<>();
        this.size = 0;
    }

    public boolean estaVacio(){
        return this.size == 0;
    }

    public int padre(int key) {
        return (key - 1) / 2;
    }
    
    public int getIzqChild(int key){   
        return 2 * key + 1;
    }
    
    public int getDerChild(int key){
        return 2 * key + 2;
    }

    //Intercambiando nodos
    public void swap(int first, int second)
    {
        Tarea holder;
        holder = heapArray.get(first);
        heapArray.set(first, heapArray.get(second));
        heapArray.set(second, holder);
    }

    public void insert(Tarea element){
        heapArray.add(element);


        int current = size;
        while (heapArray.get(current).getPrioridad() > heapArray.get(padre(current)).getPrioridad()) {
            swap(current, padre(current));
            current = padre(current);
        }
        size++;
    }

    public void completarTarea(int indice, Historial historial){
		if(!this.estaVacio()){
			historial.insert(heapArray.get(indice));
            this.delete(indice);
		}else{
			System.out.println("No hay tareas para completar");
		}
	}

    public Tarea extractMax(){
        Tarea max = heapArray.get(0);
        heapArray.set(0, heapArray.get(size-1));
        size--;
        siftDown(0);
        return max; 
    }

    public void delete(int index){
        if(!this.estaVacio()){
            System.out.println("Deleted:" + heapArray.get(index));
            heapArray.set(index, heapArray.get(size-1));
            size--;
            siftDown(index);
        }else{
            System.out.println("El heap está vacío");
        }
    }

    public void modificarTarea(int indice, String titulo, String descripcion, Fecha fecha, int prioridad){
		if(!this.estaVacio()){
            Tarea tarea = heapArray.get(indice);
			tarea.setTitulo(titulo);
			tarea.setDescripcion(descripcion);
			tarea.setFecha(fecha);
			changePriority(indice, prioridad);
		}else{
			System.out.println("No hay tareas para modificar");
		}
	}

    public void changePriority(int index, int priority){
        Tarea tarea = heapArray.get(index);
        tarea.setPrioridad(priority);
        heapArray.set(index, tarea);
        siftUp(index);
        siftDown(index);
    }

    public void siftUp(int index){
        try {
            //Si el elemento actual tiene mayor prioridad que su padre entonces se intercambian
            if(heapArray.get(index).getPrioridad() > heapArray.get(padre(index)).getPrioridad()){
                swap(index, padre(index));
                siftUp(index);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("SiftUp terminado");
        }
    }

    public void siftDown(int index){
        //Si el número en pos máx es menor que sus hijos se hace un siftdown
        try {
            if (heapArray.get(index).getPrioridad() < heapArray.get(getIzqChild(index)).getPrioridad() || heapArray.get(index).getPrioridad() < heapArray.get(getDerChild(index)).getPrioridad()) {
 
                //Se intercambia con el mayor de los hijos
                try {
                    if (heapArray.get(getIzqChild(index)).getPrioridad() > heapArray.get(getDerChild(index)).getPrioridad()) {
                        swap(index, getIzqChild(index));
                        siftDown(getIzqChild(index));
                    }
                    else {
                        swap(index, getDerChild(index));
                        siftDown(getDerChild(index));
                    }
                } catch (IndexOutOfBoundsException ex) {
                    swap(index, getIzqChild(index));
                    siftDown(getIzqChild(index));
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Heap restaurado");
        }
    }

    public Tarea peekMax(){
        return heapArray.get(0);
    }

    public ArrayList<Tarea> ordenarDescendente() {         
        Collections.sort(this.heapArray, Collections.reverseOrder());         
        return this.heapArray;     
    }

    public void print(){
        ordenarDescendente();
      for(int i=0;i<size/2;i++){
 
            System.out.print("Padre: " + heapArray.get(i).getTitulo() );
             
            if(getIzqChild(i) < size)
               System.out.print( " Hijo izquierdo: " + heapArray.get(getIzqChild(i)).getTitulo());
             
            if(getDerChild(i) < size)
                System.out.print(" Hijo derecho: " + heapArray.get(getDerChild(i)).getTitulo());
                System.out.println();
             
        }
           
    }
}
