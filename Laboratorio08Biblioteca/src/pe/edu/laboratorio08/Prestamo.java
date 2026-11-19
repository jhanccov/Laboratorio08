package pe.edu.laboratorio08;

public class Prestamo {

	private String codigoPrestamo;
	private Libro libro;
	private String nombreUsuario;
	private String fechaPrestamo;
	private boolean devuelto;

	public Prestamo() {
	}

	public Prestamo(String codigoPrestamo, Libro libro, String nombreUsuario, String fechaPrestamo, boolean devuelto) {
		this.codigoPrestamo = codigoPrestamo;
		this.libro = libro;
		this.nombreUsuario = nombreUsuario;
		this.fechaPrestamo = fechaPrestamo;
		this.devuelto = devuelto;
	}

	public String getCodigoPrestamo() {
		return codigoPrestamo;
	}

	public void setCodigoPrestamo(String codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	@Override
	public String toString() {
		String estado;
		if (devuelto) {
			estado = "DEVUELTO";
		} else {
			estado = "PENDIENTE";
		}
		return "Código: " + codigoPrestamo + "\n"
				+ "Código del libro: " + libro.getCodigo() + "\n"
				+ "Libro: " + libro.getTitulo() + "\n"
				+ "Usuario: " + nombreUsuario + "\n"
				+ "Fecha: " + fechaPrestamo + "\n"
				+ "Estado: " + estado;
	}
}
