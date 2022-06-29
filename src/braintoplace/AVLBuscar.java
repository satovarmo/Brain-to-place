package braintoplace;
public class AVLBuscar{

    NodoBinario raiz;
    int numNodos;

    public AVLBuscar() 
    { 
        raiz = null;
        numNodos = 0;
    }

    public boolean isEmpty(){
        return raiz == null;
    }

    public int altura(NodoBinario nodo) {
        if (nodo == null)
            return 0;
        return nodo.getAltura();
    }

    public int numberNodes(NodoBinario nodo){
        if(!this.isEmpty()){
            numNodos += 1;
            if(nodo.getIzq() != null){
                numberNodes(nodo.getIzq());
            }
            if(nodo.getDer() != null){ 
                numberNodes(nodo.getDer());
            }
        }else{
            numNodos = 0;
        }
        return numNodos;
    }


    public NodoBinario insert(Tarea tarea, NodoBinario nodo){
        /* 1.  Perform the normal BST insertion */
        if (nodo == null){
            raiz = new NodoBinario(tarea);
            return raiz;
        }

        if (tarea.compareTo(nodo.getTarea()) < 0)
            nodo.setIzq(insert(tarea, nodo.getIzq()));
        else if (tarea.compareTo(nodo.getTarea()) > 0)
            nodo.setDer(insert(tarea, nodo.getDer()));
        else 
            return nodo;
            
        nodo.setAltura(1 + max(altura(nodo.getIzq()), altura(nodo.getDer())));
 
        int balance = balance(nodo);
        // Izq-Izq
        if (balance > 1 && tarea.compareTo(nodo.getIzq().getTarea()) < 0)
            return rotarDerecha(nodo);
 
        // Der-Der
        if (balance < -1 && tarea.compareTo(nodo.getDer().getTarea()) > 0)
            return rotarIzquierda(nodo);
 
        // Izq-Der
        if (balance > 1 && tarea.compareTo(nodo.getIzq().getTarea()) > 0) {
            nodo.setIzq(rotarIzquierda(nodo.getIzq()));
            return rotarDerecha(nodo);
        }
        // Izq-Der
        if (balance < -1 && tarea.compareTo(nodo.getDer().getTarea()) < 0) {
            nodo.setDer(rotarDerecha(nodo.getDer()));
            return rotarIzquierda(nodo);
        }
        return nodo;
    }    

    public NodoBinario find(Tarea tarea, NodoBinario nodo){
        if(nodo == null){
            return null;
        }
        if(tarea.compareTo(nodo.getTarea()) == 0){
            return nodo;
        }else if(tarea.compareTo(nodo.getTarea()) < 0){
            if(nodo.getIzq() != null){
                return find(tarea, nodo.getIzq());
            }
            return nodo;
        }else if(tarea.compareTo(nodo.getTarea()) > 0){
            if(nodo.getDer() != null){
                return find(tarea, nodo.getDer());
            }
            return nodo;
        }
        return nodo;
    }

    public NodoBinario findMin(NodoBinario nodo){
        NodoBinario min = nodo;
        if(min.getIzq() != null){
            findMin(min.getIzq());
        }
        return min;
    }

    public NodoBinario findMax(NodoBinario nodo){
        NodoBinario max = nodo;
        if(max.getDer() != null){
            findMax(max.getDer());
        }  
        return max;
    }

    public void preOrder(NodoBinario nodo) {
        if (nodo != null) {
            System.out.print(nodo.getTarea() + " ");
            preOrder(nodo.getIzq());
            preOrder(nodo.getDer());
        }
    }

    public void preOrden(NodoBinario nodo){
        System.out.println(nodo.getTarea());
        if(!(nodo.getIzq() == null || nodo.getDer() == null)){
            preOrden(nodo.getIzq());
            preOrden(nodo.getDer());
        }
    }

    public void nivelOrden(NodoBinario nodo){
        System.out.println(nodo.getTarea());
        if(!(nodo.getIzq() == null)){
            System.out.println(nodo.getIzq().getTarea());
        }
        if(!(nodo.getDer() == null)){
            System.out.println(nodo.getDer().getTarea());
        }
        
    }

    public void inOrden(NodoBinario nodo){
        if(nodo.getIzq() != null){
            inOrden(nodo.getIzq());
        }
        System.out.println(nodo.getTarea());
        if(nodo.getDer() != null){
            inOrden(nodo.getDer());
        }
    }

    public void posOrden(NodoBinario nodo){
        if(!(nodo.getIzq() == null || nodo.getDer() == null)){
            posOrden(nodo.getIzq());
            posOrden(nodo.getDer());
        }
        System.out.println(nodo.getTarea());
    }

    public void prefijo(NodoBinario raiz){
        System.out.println("prefijo");
        preOrden(raiz);
    }

    public void infijo(NodoBinario raiz){
        System.out.println("infijo");
        inOrden(raiz);
    }

    public void postfijo(NodoBinario raiz){
        System.out.println("postfijo");
        posOrden(raiz);
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public NodoBinario rotarDerecha(NodoBinario y){
        NodoBinario x = y.getIzq();
        NodoBinario ysub2 = x.getDer();
        x.setDer(y);
        y.setIzq(ysub2);
        y.setAltura(max(altura(y.getIzq()), altura(y.getDer())) + 1);
        x.setAltura(max(altura(x.getIzq()), altura(x.getDer())) + 1);;
        return x;
    }

    public NodoBinario rotarIzquierda(NodoBinario x){
        NodoBinario y = x.getDer();
        NodoBinario xsub2 = y.getIzq();
        y.setIzq(x);
        x.setDer(xsub2);
        x.setAltura(max(altura(x.getIzq()), altura(x.getDer()))+1);
        y.setAltura(max(altura(y.getIzq()), altura(y.getDer()))+1);
        return y;
    }

    public int balance(NodoBinario nodo){
        if (nodo == null)
            return 0;
        return altura(nodo.getIzq()) - altura(nodo.getDer());
    }

    public NodoBinario contains(Tarea tarea) {
        NodoBinario current = raiz;
    
        while (current != null) {
            int comparison = tarea.compareTo(current.getTarea());
            if (comparison == 0) {
                return current;
            } else if (comparison < 0) {
                current = current.getIzq();
            } else { //comparison > 0
                current = current.getDer();
            }
        }
        return current;
    }
}