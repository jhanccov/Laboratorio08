package pe.edu.laboratorio08;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Libro> libros = new ArrayList<>();

		Libro libro1 = new Libro("L001", "Programación en Java", "Juan Pérez", 2022);
		Libro libro2 = new Libro("L002", "Estructuras de Datos", "María López", 2023);
		Libro libro3 = new Libro("L003", "Programación Orientada a Objetos", "Carlos Torres", 2024);

		libros.add(libro1);
		libros.add(libro2);
		libros.add(libro3);

		System.out.println("====================================");
		System.out.println("       SISTEMA DE BIBLIOTECA");
		System.out.println("====================================");
		System.out.println();
		System.out.println("LISTADO DE LIBROS");
		System.out.println();

		for (Libro libro : libros) {
			System.out.println(libro);
			System.out.println();
		}

		System.out.println("Total de libros registrados: " + libros.size());
	}
}
