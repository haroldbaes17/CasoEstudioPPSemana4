package view;

import controller.ProfesorController;
import utils.Helpers;

import java.io.IOException;
import java.util.Scanner;

public class MenuUI {
    private Scanner sc = new Scanner(System.in);
    private EstudianteView estudianteView = new EstudianteView();
    private ProfesorView profesorView = new ProfesorView();
    private CursoView cursoView = new CursoView();
    private GrupoView grupoView = new GrupoView();

    public MenuUI() {}

    //Metodo de menu
    public void menu() throws IOException {
        while (true) {
            try {
                System.out.println("=======Menú Principal=======");
                System.out.println("Bienvenido al Menú Principal");
                System.out.println("¿A qué menú desea acceder?");
                System.out.println("1. Menú Estudiantes");
                System.out.println("2. Menú Profesores");
                System.out.println("3. Menú Cursos");
                System.out.println("4. Menú Grupos");
                System.out.println("5. Salir");
                System.out.print("¿Que desea hacer?: ");
                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> menuEstudiante();
                    case 2 -> menuProfesor();
                    case 3 -> menuCurso();
                    case 4 -> menuGrupo();
                    case 5 -> Helpers.salir();
                    default -> System.out.println("Opcion no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public void menuEstudiante() throws IOException {
        while (true) {
            try {
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
                    case 6 -> Helpers.salir();
                    default -> System.out.println("Opcion no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public void menuProfesor() throws IOException {
        while (true) {
            try {
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
                    case 1 -> profesorView.agregarProfesor();
                    case 2 -> profesorView.modificarProfesor();
                    case 3 -> profesorView.eliminarProfesor();
                    case 4 -> profesorView.listarProfesores();
                    case 5 -> menu();
                    case 6 -> Helpers.salir();
                    default -> System.out.println("Opcion no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public void menuCurso() throws IOException {
        while (true) {
            try {
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
                    case 1 -> cursoView.agregarCurso();
                    case 2 -> cursoView.modificarCurso();
                    case 3 -> cursoView.eliminarCurso();
                    case 4 -> cursoView.listarCursos();
                    case 5 -> menu();
                    case 6 -> Helpers.salir();
                    default -> System.out.println("Opcion no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public void menuGrupo() throws IOException {
        while (true) {
            try {
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
                    case 1 -> grupoView.agregarGrupo();
                    case 2 -> grupoView.modificarGrupo();
                    case 3 -> grupoView.eliminarGrupo();
                    case 4 -> grupoView.listarGrupos();
                    case 5 -> menu();
                    case 6 -> Helpers.salir();
                    default -> System.out.println("Opcion no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}