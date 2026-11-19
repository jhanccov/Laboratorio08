package pe.edu.laboratorio08;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Libro> libros = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		libros.add(new Libro("L001", "Programación en Java", "Juan Pérez", 2022));
		libros.add(new Libro("L002", "Estructuras de Datos", "María López", 2023));
		libros.add(new Libro("L003", "Programación Orientada a Objetos", "Carlos Torres", 2024));

		int opcion = 0;

		while (opcion != 6) {
			mostrarMenu();
			opcion = leerEntero("Seleccione una opción: ");
			System.out.println();

			switch (opcion) {
			case 1:
				registrarLibro();
				break;
			case 2:
				listarLibros();
				break;
			case 3:
				buscarLibro();
				break;
			case 4:
				modificarLibro();
				break;
			case 5:
				eliminarLibro();
				break;
			case 6:
				System.out.println("Gracias por usar el sistema.");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			System.out.println();
		}
		sc.close();
	}

	static void mostrarMenu() {
		System.out.println("====================================");
		System.out.println("       SISTEMA DE BIBLIOTECA");
		System.out.println("====================================");
		System.out.println();
		System.out.println("1. Registrar libro");
		System.out.println("2. Listar libros");
		System.out.println("3. Buscar libro por código");
		System.out.println("4. Modificar información de libro");
		System.out.println("5. Eliminar libro");
		System.out.println("6. Salir");
		System.out.println();
	}

	static void registrarLibro() {
		System.out.println("REGISTRO DE LIBRO");
		System.out.println();

		String codigo = leerTexto("Ingrese código: ");
		if (buscarPorCodigo(codigo) != null) {
			System.out.println("Error: ya existe un libro con el código " + codigo + ".");
			return;
		}

		String titulo = leerTexto("Ingrese título: ");
		String autor = leerTexto("Ingrese autor: ");
		int anio = leerAnio("Ingrese año: ");

		Libro libro = new Libro(codigo, titulo, autor, anio);
		libros.add(libro);

		System.out.println();
		System.out.println("¡Libro registrado correctamente!");
	}

	static void listarLibros() {
		System.out.println("LISTADO DE LIBROS");
		System.out.println();

		if (libros.isEmpty()) {
			System.out.println("No hay libros registrados.");
			return;
		}

		for (Libro libro : libros) {
			System.out.println(libro);
			System.out.println();
		}
		System.out.println("Total de libros registrados: " + libros.size());
	}

	static void buscarLibro() {
		String codigo = leerTexto("Ingrese código a buscar: ");
		Libro libro = buscarPorCodigo(codigo);

		System.out.println();
		if (libro == null) {
			System.out.println("No existe un libro con el código " + codigo + ".");
		} else {
			System.out.println("LIBRO ENCONTRADO");
			System.out.println(libro);
		}
	}

	static void modificarLibro() {
		String codigo = leerTexto("Ingrese código del libro a modificar: ");
		Libro libro = buscarPorCodigo(codigo);

		if (libro == null) {
			System.out.println("No existe un libro con el código " + codigo + ".");
			return;
		}

		System.out.println();
		System.out.println("Datos actuales:");
		System.out.println(libro);
		System.out.println();

		libro.setTitulo(leerTexto("Nuevo título: "));
		libro.setAutor(leerTexto("Nuevo autor: "));
		libro.setAnioPublicacion(leerAnio("Nuevo año: "));

		System.out.println();
		System.out.println("¡Libro modificado correctamente!");
	}

	static void eliminarLibro() {
		String codigo = leerTexto("Ingrese código del libro a eliminar: ");

		int posicion = -1;
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				posicion = i;
			}
		}

		if (posicion == -1) {
			System.out.println("No existe un libro con el código " + codigo + ".");
			return;
		}

		libros.remove(posicion);
		System.out.println("¡Libro eliminado correctamente!");
	}

	static Libro buscarPorCodigo(String codigo) {
		for (Libro libro : libros) {
			if (libro.getCodigo().equalsIgnoreCase(codigo)) {
				return libro;
			}
		}
		return null;
	}

	static String leerTexto(String mensaje) {
		String texto = "";
		while (texto.isEmpty()) {
			System.out.print(mensaje);
			texto = sc.nextLine().trim();
			if (texto.isEmpty()) {
				System.out.println("El dato no puede estar vacío.");
			}
		}
		return texto;
	}

	static int leerEntero(String mensaje) {
		while (true) {
			System.out.print(mensaje);
			String texto = sc.nextLine().trim();
			try {
				return Integer.parseInt(texto);
			} catch (NumberFormatException e) {
				System.out.println("Debe ingresar un número entero.");
			}
		}
	}

	static int leerAnio(String mensaje) {
		int anioActual = LocalDate.now().getYear();
		int anio = leerEntero(mensaje);
		while (anio < 1450 || anio > anioActual) {
			System.out.println("El año debe estar entre 1450 y " + anioActual + ".");
			anio = leerEntero(mensaje);
		}
		return anio;
	}
}
