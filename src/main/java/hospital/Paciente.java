package hospital;

public class Paciente extends Persona {

	public Paciente(String nombre, int edad, String rut) {
		this.nombre = nombre;
		this.rut = rut;
		this.edad = edad;
	}

	public String toString() {
		return this.nombre+","+this.edad+","+this.rut;
	}

	public String getTipo() {
		return "Paciente";
	}
}