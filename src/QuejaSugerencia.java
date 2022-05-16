
public class QuejaSugerencia {
	private String usuario;
	private String detalles;
	
        public QuejaSugerencia(){
            setUsuario("Sin Registro");
            setUsuario("Sin Queja");
        }
	public QuejaSugerencia(String usuario, String detalles) {
		setUsuario(usuario);
		setDetalles(detalles);
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
        
        @Override
        public String toString(){
            return "Queja implementada por el usuaruio "+usuario;
        }
        
        
}
