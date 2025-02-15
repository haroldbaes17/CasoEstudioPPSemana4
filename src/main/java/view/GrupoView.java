package view;

import controller.GrupoController;

import java.util.Scanner;

public class GrupoView {
    private GrupoController controller = new GrupoController();
    private Scanner scanner = new Scanner(System.in);

    public GrupoView() {}

    public void agregarGrupo() {
        try {
            System.out.print("Ingrese el nombre del grupo: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el descripcion del grupo: ");
            String descripcion = scanner.nextLine();
            controller.agregarGrupo(nombre, descripcion, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarGrupo() {
        boolean estado = false;
        try {
            System.out.print("Ingrese el ID del grupo a modificar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nuevo nombre del grupo: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva descripcion del grupo: ");
            String descripcion = scanner.nextLine();
            System.out.print("Ingrese el nuevo estado del grupo (Activo / Inactivo): ");
            String estadoStr = scanner.nextLine();
            if (estadoStr.trim().equalsIgnoreCase("Activo")) estado = true;

            controller.modificarGrupo(id, nombre, descripcion, estado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarGrupo() {
        try {
            System.out.print("Ingrese el ID del grupo a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            controller.eliminarGrupo(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void listarGrupos() {
        controller.obtenerGrupos();
    }
}
