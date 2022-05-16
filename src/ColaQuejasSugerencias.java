
import java.util.Scanner;
//Implementamos las quejas y sugerencias como colas para que la primera en ser resuelta sea la primera en haber sido agregada (FIFO)

public class ColaQuejasSugerencias {
        //Usamos una clase auxiliar de Nodo para las quejas, con un enlace simple
        public class NodoQueja{
            private QuejaSugerencia Queja;
            private NodoQueja next;

            public NodoQueja(QuejaSugerencia q) {
                    this.Queja=q;
                    this.next= null;
            }
            public NodoQueja(QuejaSugerencia q, NodoQueja siguiente) {
                this.Queja=q;
                this.next=siguiente;
            }
            public QuejaSugerencia getQueja() {
                    return Queja;
            }
            public void setTarea(QuejaSugerencia q) {
                    this.Queja = q;
            }
            public NodoQueja getSiguiente() {
                    return next;
            }
            public void setSiguiente(NodoQueja siguiente) {
                    this.next = siguiente;
            }
        }
        
        
        private NodoQueja cabeza;
        private NodoQueja cola;
	
	public ColaQuejasSugerencias() {
		this.cabeza = null;
	}
        public ColaQuejasSugerencias(NodoQueja n){
            this.cabeza=n;
        }
        
        
        public boolean empty(){
            if(this.cabeza==null && this.cola==null){
                return true;
            }
            return false;
        }
        
        
        public void enq(QuejaSugerencia data){
            NodoQueja r=new NodoQueja(data);
            if(this.empty()){
                cola=r;
                cabeza=r;
            }else{
                cola.setSiguiente(r);
                cola=r;
            }
        }
       
        public QuejaSugerencia deq(){
            if(this.empty()){
                System.out.println("No se puede");
                return new QuejaSugerencia();
            }else {
                QuejaSugerencia r=cabeza.getQueja();
                cabeza=cabeza.getSiguiente();
                if(cabeza==null){
                    cola=null;
                }
                return r;
            }
           
        }
       
        public NodoQueja seek(){
            return this.cabeza;
        }
        
        public void ImprimirCola(){
            NodoQueja n=this.cabeza;
            if(n==null){
                System.out.println("No hay quejas ni sugerencias nuevas");
            }
            while(n!=null){
                System.out.println(n.getQueja().toString());
                n=n.getSiguiente();
            }
        }
        
        public void menuQuejas(){
            System.out.println("1. Agregar Queja o Sugerencia");
            System.out.println("2. Ver la lista de quejas y sugerencias");
            System.out.println("3. Resolver quejas y sugerencias");
            System.out.println("0. Regresar al menu anterior\n");
            Scanner lector = new Scanner(System.in);
            String entrada1 = lector.nextLine();
            switch(entrada1) {
                case "1":
                    System.out.println("Ingrese su usuario");
                    String usuario = lector.nextLine();
                    System.out.println("Ingrese su queja o sugerencia");
                    String datosQueja = lector.nextLine();
                    QuejaSugerencia queja=new QuejaSugerencia(usuario,datosQueja);
                    this.enq(queja);
                    break;
                case "2":
                    this.ImprimirCola();
                    break;
                case "3":
                    if(!this.empty()){
                        QuejaSugerencia quejaResuelta=this.deq();
                        System.out.println("Se ha resuelto "+quejaResuelta.toString());
                    }else{
                        System.out.println("No hay quejas por resolver");
                    }    
                    break;
                default:
                    System.out.println("Opción inválida, se le regresará al menú anterior.");
            }        
        }
}
