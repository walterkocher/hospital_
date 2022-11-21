package hospital;

import java.util.ArrayList;


public class Hospital {
	private ArrayList<Persona> personas = new ArrayList<Persona>();

	public boolean agregarPaciente(String nombre, int edad, String rut) {
		Paciente paciente = new Paciente(nombre,edad,rut);
		this.personas.add(paciente);
		return true;
	}

	public boolean eliminarPaciente(String nombre, int edad, String rut) {
		for(Persona persona: this.personas) {
			if (persona.getTipo().equals("Paciente")) {
				if (persona.getNombre().equals(nombre) && persona.getRut().equals(rut) && persona.getEdad() == edad) {
					this.personas.remove(persona);
					return true;
				}
			}
		}
		return false;
	}

	public boolean despedirDoctor(String nombre, int edad, String rut) {
		for(Persona persona: this.personas) {
			if (persona.getTipo().equals("Doctor")) {
				if (persona.getNombre().equals(nombre) && persona.getRut().equals(rut) && persona.getEdad() == edad) {
					this.personas.remove(persona);
					return true;
				}
			}
		}
		return false;
	}

	public boolean contratarDoctor(String nombre, int edad, String rut,String especialidad) {
		Doctor doctor = new Doctor(nombre,rut,edad,especialidad);
		this.personas.add(doctor);
		return true;
	}

	public void mostrarPacientes() {
		for(Persona persona: this.personas){
			if(persona.getTipo().equals("Paciente")){

				Paciente paciente = (Paciente) persona;
				System.out.println(paciente.toString());
			}
		}
	}

	public void mostrarDoctores() {
		System.out.println("Doctores:");
		for(Persona persona: this.personas){
			if(persona.getTipo().equals("Doctor")){
				Doctor doctor=(Doctor) persona;
				System.out.println(doctor.toString());
			}
		}
	}
}