package view;

import controller.ProfesorController;

import java.util.Scanner;

public class ProfesorView {
    private ProfesorController controller = new ProfesorController();
    private Scanner scanner = new Scanner(System.in);

    public ProfesorView() {}

    public void agregarProfesor() {
        try {
            System.out.print("Ingrese el nombre del profesor: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la identificacion del profesor: ");
            String identificacion = scanner.nextLine();
            System.out.print("Ingrese el email del profesor: ");
            String email = scanner.nextLine();
            System.out.print("Ingrese el departamento del profesor: ");
            String departamento = scanner.nextLine();

            controller.agregarProfesor(nombre, identificacion, email, departamento, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarProfesor() {
        boolean estado = false;
        try {
            System.out.print("Ingrese el ID del profesor a modificar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nuevo nombre del profesor: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva identificacion del profesor: ");
            String identificacion = scanner.nextLine();
            System.out.print("Ingrese el nuevo email del profesor: ");
            String email = scanner.nextLine();
            System.out.print("Ingrese el nuevo departamento del profesor: ");
            String departamento = scanner.nextLine();
            System.out.print("Ingrese el nuevo estado del profesor (Activo / Inactivo): ");
            String estadoStr = scanner.nextLine();
            if (estadoStr.trim().equalsIgnoreCase("Activo")) estado = true;

            controller.modificarProfesor(id, nombre, identificacion, email, departamento, estado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarProfesor() {
        try {
            System.out.print("Ingrese el ID del profesor: ");
            int id = Integer.parseInt(scanner.nextLine());
            controller.eliminarProfesor(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarProfesores() {
        controller.obtenerProfesores();
    }
}
