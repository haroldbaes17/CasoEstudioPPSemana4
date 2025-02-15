package view;

import controller.ProfesorController;

import java.io.IOException;
import java.util.Scanner;

public class MenuUI {
    private Scanner sc = new Scanner(System.in);
    private EstudianteView estudianteView = new EstudianteView();
    private ProfesorView profesorView = new ProfesorView();
    private CursoView cursoView = new CursoView();
    private GrupoView grupoView = new GrupoView();

    public MenuUI() {}

    public void menu() throws IOException {
        while (true) {
            System.out.println("Bienvenido al Menú Principal");
            System.out.println("¿A qué menú desea ir?");
            System.out.println("1. Menú Estudiantes");
            System.out.println("2. Menú Profesores");
            System.out.println("3. Menú Cursos");
            System.out.println("5. Salir");
            System.out.print("¿Que desea hacer?: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> menuEstudiante();
                case 2 -> menuProfesor();
                case 3 -> menuCurso();
                case 4 -> menuGrupo();
                case 5 -> salir();
                default -> System.out.println("Opcion no valida");
            }
        }
    }

    public void menuEstudiante() throws IOException {
        while (true) {
            System.out.println("=======Menú Estudiantes=======");
            System.out.println("Bienvenido al Menú de Estudiantes");
            System.out.println("1. Ingresar nuevo estudiante");
            System.out.println("2. Modificar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Obtener estudiantes");
            System.out.println("5. Regresar");
            System.out.println("6. Salir");
            System.out.print("¿Que desea hacer?: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> estudianteView.agregarEstudiante();
                case 2 -> estudianteView.modificarEstudiante();
                case 3 -> estudianteView.eliminarEstudiante();
                case 4 -> estudianteView.listarEstudiantes();
                case 5 -> menu();
                case 6 -> salir();
                default -> System.out.println("Opcion no valida");
            }
        }
    }

    public void menuProfesor() throws IOException {
        while (true) {
            System.out.println("=======Menú Profesor=======");
            System.out.println("Bienvenido al Menú de Profesores");
            System.out.println("1. Ingresar nuevo profesor");
            System.out.println("2. Modificar profesor");
            System.out.println("3. Eliminar profesor");
            System.out.println("4. Obtener profesores");
            System.out.println("5. Regresar");
            System.out.println("6. Salir");
            System.out.print("¿Que desea hacer?: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 5 -> menu();
                case 6 -> salir();
                default -> System.out.println("Opcion no valida");
            }
        }
    }

    public void menuCurso() throws IOException {
        while (true) {
            System.out.println("=======Menú Cursos=======");
            System.out.println("Bienvenido al Menú de Cursos");
            System.out.println("1. Ingresar nuevo curso");
            System.out.println("2. Modificar curso");
            System.out.println("3. Eliminar curso");
            System.out.println("4. Obtener curso");
            System.out.println("5. Regresar");
            System.out.println("6. Salir");
            System.out.print("¿Que desea hacer?: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 5 -> menu();
                case 6 -> salir();
                default -> System.out.println("Opcion no valida");
            }
        }
    }

    public void menuGrupo() throws IOException {
        while (true) {
            System.out.println("=======Menú Grupos=======");
            System.out.println("Bienvenido al Menú de Grupos");
            System.out.println("1. Ingresar nuevo grupo");
            System.out.println("2. Modificar grupo");
            System.out.println("3. Eliminar grupo");
            System.out.println("4. Obtener grupo");
            System.out.println("5. Regresar");
            System.out.println("6. Salir");
            System.out.print("¿Que desea hacer?: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 5 -> menu();
                case 6 -> salir();
                default -> System.out.println("Opcion no valida");
            }
        }
    }

    private void salir() {
        System.out.println("Saliendo...");
        System.exit(0);
    }


}
