package view;

import controller.GrupoCursoController;

import java.util.Scanner;

public class GrupoCursoView {
    private GrupoCursoController controller = new GrupoCursoController();
    private Scanner scanner = new Scanner(System.in);

    public GrupoCursoView() {}

    public void agregarRelacion() {
        try {
            System.out.print("Ingrese el ID de un Grupo: ");
            int idGrupo= Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el ID de un Curso: ");
            int idCurso= Integer.parseInt(scanner.nextLine());

            controller.agregarRelacion(idGrupo, idCurso);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarRelacion() {
        try {
            System.out.print("Ingrese el ID de la relacion a modificar: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el ID del nuevo grupo: ");
            int idGrupo= Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el ID del nuevo curso: ");
            int idCurso= Integer.parseInt(scanner.nextLine());

            controller.modificarRelacion(id, idGrupo, idCurso);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarRelacion() {
        try {
            System.out.print("Ingrese el ID de la relacion a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            controller.eliminarRelacion(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarRelacion() {
        controller.obtenerRelaciones();
    }
}
