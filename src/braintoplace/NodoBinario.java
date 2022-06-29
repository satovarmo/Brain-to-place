package braintoplace;

public class NodoBinario {
    private Tarea tarea;
    private int altura;
    private NodoBinario izq;
    private NodoBinario der;

    public NodoBinario(Tarea tarea) {
        this.tarea = tarea;
        this.altura = 1;
        this.izq = null;
        this.der = null;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public int getAltura(){
        return this.altura;
    }

    public void setAltura(int altura){
        this.altura = altura;
    }

    public NodoBinario getIzq() {
        return izq;
    }

    public void setIzq(NodoBinario izq) {
        this.izq = izq;
    }

    public NodoBinario getDer() {
        return der;
    }

    public void setDer(NodoBinario der) {
        this.der = der;
    }
}
