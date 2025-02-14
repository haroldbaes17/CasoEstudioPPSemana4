package view;

import controller.EstudianteController;

import java.util.Scanner;

public class EstudianteView {
    public EstudianteController controller = new EstudianteController();
    private Scanner scanner = new Scanner(System.in);

    public EstudianteView() {}

    public void estudianteMenu(int opcion) {

    }

    public void agregarEstudiante() {
        try {
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la identificacion del estudiante: ");
            String identificacion = scanner.nextLine();
            System.out.print("Ingrese el Email del estudiante: ");
            String email = scanner.nextLine();
            System.out.print("Ingrese la fehca de nacimiento del estudiante: ");
            String fecha_nacimiento = scanner.nextLine();

            controller.agregarEstudiante(nombre, identificacion, email, fecha_nacimiento, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarEstudiante() {
        boolean estado = false;
        try {
            System.out.print("Ingrese el ID del estudiante a modificar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nuevo nombre del estudiante: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva identificacion del estudiante: ");
            String identificacion = scanner.nextLine();
            System.out.print("Ingrese el nuevo email del estudiante: ");
            String email = scanner.nextLine();
            System.out.print("Ingrese la nueva fecha del estudiante: ");
            String fecha_nacimiento = scanner.nextLine();
            System.out.print("Ingrese el nuevo estado del estudiante (Activo / Inactivo): ");
            String estadoStr = scanner.nextLine();
            if (estadoStr.equalsIgnoreCase("Activo"))  estado = true;

            controller.modificarEstudiante(id, nombre, identificacion, email, fecha_nacimiento, estado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarEstudiante() {
        try {
            System.out.print("Ingrese el ID del estudiante a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            controller.eliminarEstudiante(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarEstudiantes() {
        controller.obtenerEstudiantes();
    }


}
