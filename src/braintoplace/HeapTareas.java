package braintoplace;
import java.util.ArrayList;

public class HeapTareas {
    private ArrayList<Integer> heapArray;
    private int size;

    public HeapTareas(){
        this.heapArray = new ArrayList<>();
        this.size = 0;
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
        int holder;
        holder = heapArray.get(first);
        heapArray.set(first, heapArray.get(second));
        heapArray.set(second, holder);
    }

    public void insert(int element){
        heapArray.add(element);
        
        // Traverse up and fix violated property
        int current = size;
        while (heapArray.get(current) > heapArray.get(padre(current))) {
            swap(current, padre(current));
            current = padre(current);
        }
        size++;
    }

    public double geometricMean(){
        int result = 1;
        for (int i = 15; i < size; i++){
            result *= heapArray.get(i);
        }
        return Math.pow(result, 1/size);
    }

    public int extractMax(){
        int max = heapArray.get(0);
        heapArray.set(0, heapArray.get(size-1));
        size--;
        siftDown(0);
        return max; 
    }

    public void delete(int index){
        System.out.println("Deleted:" + heapArray.get(index));
        heapArray.set(index, heapArray.get(size-1));
        size--;
        siftDown(index);
    }

    public void changePriority(int index, int priority){
        heapArray.set(index, priority);
        siftUp(index);
        siftDown(index);
    }

    public void siftUp(int index){
        try {
            //Si el elemento actual tiene mayor prioridad que su padre entonces se intercambian
            if(heapArray.get(index) > heapArray.get(padre(index))){
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
            if (heapArray.get(index) < heapArray.get(getIzqChild(index)) || heapArray.get(index) < heapArray.get(getDerChild(index))) {
 
                //Se intercambia con el mayor de los hijos
                try {
                    if (heapArray.get(getIzqChild(index)) > heapArray.get(getDerChild(index))) {
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

    public int peekMax(){
        return heapArray.get(0);
    }

    public void print()
    {
       
      for(int i=0;i<size/2;i++){
 
            System.out.print("Parent Node : " + heapArray.get(i) );
             
            if(getIzqChild(i) < size) //if the child is out of the bound of the array
               System.out.print( " Left Child Node: " + heapArray.get(getIzqChild(i)));
             
            if(getDerChild(i) < size) //if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: "+ heapArray.get(getDerChild(i)));
                System.out.println(); //for new line
             
        }
           
    }
}
