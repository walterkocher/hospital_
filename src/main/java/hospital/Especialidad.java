package hospital;

public enum Especialidad {
	PEDIATRIA("Pediatria"),
	TRAUMATOLOGIA("Traumatologia"),
	OFTALMOLOGIA("Oftalmologia"),
	DERMATOLOGIA("Dermatologia");
	private String especialidad;

	private Especialidad(String especialidad) {
		especialidad=especialidad;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}
}