package hospital;

public class Doctor extends Persona {
	private String especialidad;

	public Doctor(String nombre, String rut, int edad, String especialidad) {
		this.nombre = nombre;
		this.rut = rut;
		this.edad = edad;
		this.especialidad=especialidad;
	}

	public String toString() {
		return this.nombre+","+this.edad+","+this.rut+","+this.especialidad;
	}

	public String getTipo() {
		return "Doctor";
	}
}