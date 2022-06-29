package braintoplace;

public class Hasher {
	String[] Passwords = new String[1024];
	
	public Hasher() {
		
	}
	
	public void insert(String user, String Password) {
		int id = userID(user);
		if (Passwords[id] == null) {
			Passwords[id] = Password;
			//System.out.println("Usuario: " + user);
			//System.out.println("ID: " + id);
			//System.out.println("Contraseña: " + Password);
		}
		else if (Passwords[id] != Password) {
			//System.out.println("Usuario ya tomado o contraseña incorrecta");
		}
	}
	public int userID(String User) {
		char x;
		int sum = 0;
		for (int i = 0; i <=3; i++) {
			x = User.charAt(i);
			int n = (int) x;
			sum = sum + n;
		}
		return sum;
	}
}